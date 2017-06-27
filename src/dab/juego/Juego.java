package dab.juego;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import dab.dragonBallExceptions.AunNoHayGanador;
import dab.dragonBallExceptions.EstePersonajeNoPuedeRealizarMovimientosEsteTurno;
import dab.dragonBallExceptions.MovimientoInvalido;
import dab.personajes.Personaje;
import dab.potenciadores.EsferaDelDragon;
import dab.potenciadores.NubeVoladora;
import dab.potenciadores.Potenciador;
import dab.potenciadores.SemillaDelErmitanio;
import dab.usuario.Usuario;

public class Juego {
	
	////CAMBIOS A HACER:
	///QUE JUEGO RECIBA UN USUARIO CON SU EQUIPO DENTRO YA CREADO
	///QUE LOS TURNOS SE MANEJEN POR USUARIO Y NO POR EQUIPO
	
	private static final int cantidadEsferasDelDragonAColocar = 7;
	private static final int cantidadNubesVoladorasAColocar = 5;
	private static final int cantidadSemillasDelErmitanioAColocar = 5;
	private int altoTablero;
	private int anchoTablero;
	private Tablero tablero;
	Turno turno;
	Map<Usuario, Usuario> contrincantes;
	
	private Personaje personajeSeleccionado;
	

	public Juego(int altoTablero, int anchoTablero, Usuario userGuerrerosZ, Usuario userEnemigos){
		//PRE: SOLO DOS USUARIOS Y EL PRIMERO SERA EL PRIMERO EN JUGAR

		this.altoTablero = altoTablero;
		this.anchoTablero = anchoTablero;
		this.tablero = new Tablero(altoTablero, anchoTablero, userGuerrerosZ.getEquipo(), userEnemigos.getEquipo());
		try {
			this.generarConsumibles();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		contrincantes = new HashMap<Usuario,Usuario>();
		contrincantes.put(userGuerrerosZ,  userEnemigos);
		contrincantes.put(userEnemigos, userGuerrerosZ);
	
		//Invariante: Siempre empiezan jugando los guerreros Z
		turno = new Turno(userGuerrerosZ);

	}
	
	private void generarConsumibles() throws InstantiationException, IllegalAccessException {
		ArrayList<Potenciador> potenciadores = new ArrayList<Potenciador>();
		
		this.generarPotenciadores(potenciadores, cantidadEsferasDelDragonAColocar, EsferaDelDragon.class);
		this.generarPotenciadores(potenciadores, cantidadNubesVoladorasAColocar, NubeVoladora.class);
		this.generarPotenciadores(potenciadores, cantidadSemillasDelErmitanioAColocar, SemillaDelErmitanio.class);
		colocarConsumibles(potenciadores);
	} 
	
	private void colocarConsumibles(ArrayList<Potenciador> potenciadores){

        for (int i = 0; i < potenciadores.size(); i++){

            boolean seEncontroUnaPosicionParaUbicarPotenciador = false;

            while (!seEncontroUnaPosicionParaUbicarPotenciador ){

                int randomFila = generarNumeroRandom(0, altoTablero);

                int randomColumna = generarNumeroRandom(0, anchoTablero);

                if (!tablero.celdaOcupada(randomFila, randomColumna)){
                    tablero.colocarFicha(potenciadores.get(i), randomFila, randomColumna);
                    seEncontroUnaPosicionParaUbicarPotenciador = true;
            }
        }
    }
}
	
	private int generarNumeroRandom(int min, int max){
		int random = ThreadLocalRandom.current().nextInt(min, max);
		return random;
	}

	private <T extends Potenciador> void generarPotenciadores(ArrayList<Potenciador> potenciadores, int cantidadAAnadir, Class<T> claseDelPotenciador) throws InstantiationException, IllegalAccessException {
		
		for (int i = 0; i < cantidadAAnadir; i++){
			potenciadores.add(claseDelPotenciador.newInstance());
		}
		
	}

	public void seleccionarPersonajeDeLaCelda(Celda celda){
		if (!turno.puedeJugar((Personaje) celda.getFicha())){
			throw new EstePersonajeNoPuedeRealizarMovimientosEsteTurno();
		}
		personajeSeleccionado = (Personaje)celda.getFicha();
	}
	
	public Tablero getTablero(){
		return tablero;
	}

	public void pasarTurno() {
		turno = new Turno(contrincantes.get(turno.usuarioActual()));
	}
	
	public Usuario ganador(){
		if (ganoElDelTurnoActual()){
			return turno.usuarioActual();
		}
		throw new AunNoHayGanador();
	}
	
	public boolean ganoElDelTurnoActual(){
		return contrincantes.get(turno.usuarioActual()).haPerdido() || turno.usuarioActual().haConseguidoItemsParaGanar();
	}
	
	private void seHaEfectuadoUnAtaque(){
		turno.seHaEfectuadoUnAtaque();
		if (!ganoElDelTurnoActual()){
			this.verificarFinDeTurno();
		}
	}
	
	private void seHaEfectuadoUnMovimiento(){
		turno.seHaEfectuadoUnMovimiento();
		if (!ganoElDelTurnoActual()){
			this.verificarFinDeTurno();
		}
	}
	
	public boolean personajeSeleccionadoPuedeAtacarA(Personaje otroPersonaje){
		
		return personajeSeleccionado.puedeAtacar(otroPersonaje);
		
	}
	
	public void personajeSeleccionadoAtacaA(Personaje aPersonaje){
	
		personajeSeleccionado.atacarA(aPersonaje);
		this.avisarAlContrincante(aPersonaje);
		
		this.seHaEfectuadoUnAtaque();
		
	}
	
	public void personajeSeleccionadoAtaqueEspecialA(Personaje aPersonaje){
		personajeSeleccionado.ataqueEspecial(aPersonaje);
		this.avisarAlContrincante(aPersonaje);
	    this.seHaEfectuadoUnAtaque(); 
	}
	
	private void avisarAlContrincante(Personaje aPersonaje) {
		Usuario actual = turno.usuarioActual();
		Usuario contrincante = contrincantes.get(actual);
		contrincante.notificarQueSeAtacoA(aPersonaje);
		
		if (!contrincante.sigueTeniendoAlPersonaje(aPersonaje)){
			contrincante.notificarUnaBaja();
			actual.notificarUnAsesinato();
			ArrayList<Potenciador> potenciadoresDelCaido = contrincante.getPotenciadoresPerdidos();
			colocarConsumibles(potenciadoresDelCaido);
		}
		
	}

	public boolean personajeSeleccionadoPuedeMoverseHacia(int fila, int columna){
		return tablero.puedeTrasladarse(personajeSeleccionado, fila, columna);
	}
	
	public void moverPersonajeSeleccionadoHacia(int fila, int columna){
		try{
			tablero.moverFicha(personajeSeleccionado, fila, columna);
			this.seHaEfectuadoUnMovimiento();
		}
		catch (MovimientoInvalido e){
			// no se realiza el movimiento.
			}
		}
	

	
	public boolean personajeSeleccionadoTieneAtaqueEspecialDisponible(){
		return personajeSeleccionado.ataqueEspecialDisponible();
	}
	
	public boolean personajeSeleccionadoTieneTransformacionDisponible(){
		return personajeSeleccionado.transformarDisponible();
	}
	
	public void personajeSeleccionadoTransformar(){
		personajeSeleccionado.transformar();
	}
	
	private void verificarFinDeTurno(){
		if (turno.haFinalizado()){
			this.pasarTurno();
		}
	}


	public boolean sePuedeSeleccionarUnPersonaje(Celda celda) {
		
		return celda.estaOcupada() && !celda.permitePosicionarUnaFicha();
	}
	
	public boolean elOcupantePuedeRealizarJugada(Celda celda){
		/*Devuelve si el ocupante de la celda esta en el turno*/
		Personaje personaje = (Personaje)celda.getFicha();
		return turno.puedeJugar(personaje);
	}


	public boolean sePuedeSeguirAtacando() {
		return turno.quedanAtaquesDisponibles();
	}

	
	public Collection<Personaje> getPersonajesDeTurno(){
		return turno.getEquipo().obtenerPersonajes();
		
		
	}
	
	public boolean sePuedeEfectuarUnMovimiento() {
		// TODO Auto-generated method stub
		return turno.quedanMovimientosDisponibles();
	}

	public Personaje personajeSeleccionado() {
		// TODO Auto-generated method stub
		return personajeSeleccionado;
	}

	public ArrayList<Celda> celdasPermitidasDelersonajeSeleccionado() {
		return tablero.celdasPermitidas((Celda) personajeSeleccionado.getPosicion(), personajeSeleccionado.getVelocidad());
	}

	public ArrayList<Personaje> obtenerPersonajesAtacablesDelSeleccionado() {
		return tablero.personajesAtacables(personajeSeleccionado, contrincantes.get(turno.usuarioActual()).getEquipo());
	}
	
	public void seleccionarPersonajeEnPosicion(int fila, int columna){
		this.seleccionarPersonajeDeLaCelda(tablero.obtenerCelda(fila, columna));
	}
	
	public void moverPersonajeSeleccionadoACelda(Celda celda){
		moverPersonajeSeleccionadoHacia(celda.getFila(), celda.getColumna());
	}
	
	public Usuario obtenerJugadorActual(){
		return turno.usuarioActual();
	}


}

