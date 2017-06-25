package dab.juego;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import dab.dragonBallExceptions.EstePersonajeNoPuedeRealizarMovimientosEsteTurno;

import dab.personajes.Personaje;
import dab.potenciadores.SemillaDelErmitanio;
import dab.potenciadores.EsferaDelDragon;
import dab.potenciadores.NubeVoladora;
import dab.potenciadores.Potenciador;
import dab.usuario.Usuario;
import java.util.concurrent.ThreadLocalRandom;

public class Juego {
	
	////CAMBIOS A HACER:
	///QUE JUEGO RECIBA UN USUARIO CON SU EQUIPO DENTRO YA CREADO
	///QUE LOS TURNOS SE MANEJEN POR USUARIO Y NO POR EQUIPO
	
	private static final int cantidadEsferasDelDragon = 7;
	private static final int cantidadNubesVoladoras = 5;
	private static final int cantidadSemillasDelErmitanio = 5;
	private int altoTablero;
	private int anchoTablero;
	private Tablero tablero;
	Turno turno;
	Map<Usuario, Usuario> contrincantes;
	
	private Personaje personajeSeleccionado;
	

	public Juego(int altoTablero, int anchoTablero, Usuario userGuerrerosZ, Usuario userEnemigos){
		//PRE: SOLO DOS USUARIOS Y EL PRIMERO SERA EL PRIMERO EN JUGAR

	
		//Cambiaro esto de que el tablero conozca al equipo enemigo de un determinado equipo. Eso lo podria hacer
		//El juego o el usuario
		this.altoTablero = altoTablero;
		this.anchoTablero = anchoTablero;
		this.tablero = new Tablero(altoTablero, anchoTablero, userGuerrerosZ.getEquipo(), userEnemigos.getEquipo());
		try {
			this.colocarConsumibles();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contrincantes = new HashMap<Usuario,Usuario>();
		contrincantes.put(userGuerrerosZ,  userEnemigos);
		contrincantes.put(userEnemigos, userGuerrerosZ);
	
		//Invariante: Siempre empiezan jugando los guerreros Z
		turno = new Turno(userGuerrerosZ);

	}
	
	private void colocarConsumibles() throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		ArrayList<Potenciador> potenciadores = new ArrayList<Potenciador>();
		
		this.generarPotenciadores(potenciadores, cantidadEsferasDelDragon, EsferaDelDragon.class);
		this.generarPotenciadores(potenciadores, cantidadNubesVoladoras, NubeVoladora.class);
		this.generarPotenciadores(potenciadores, cantidadSemillasDelErmitanio, SemillaDelErmitanio.class);
		
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

		//ordenTurnos.offer(ordenTurnos.poll());
		turno = new Turno(contrincantes.get(turno.usuarioActual()));

	}
	
	public void seHaEfectuadoUnAtaque(){
		turno.seHaEfectuadoUnAtaque();
		this.verificarFinDeTurno();
	}
	
	public void seHaEfectuadoUnMovimiento(){
		turno.seHaEfectuadoUnMovimiento();
		this.verificarFinDeTurno();
	}
	
	public boolean personajeSeleccionadoPuedeAtacarA(Personaje otroPersonaje){
		
		return personajeSeleccionado.puedeAtacar(otroPersonaje);
		
	}
	
	public void personajeSeleccionadoAtacaA(Personaje otroPersonaje){
	
		personajeSeleccionado.atacarA(otroPersonaje);
		
	}
	
	public boolean personajeSeleccionadoPuedeMoverseHacia(int fila, int columna){
		return tablero.puedeTrasladarse(personajeSeleccionado, fila, columna);
	}
	
	public void moverPersonajeSeleccionadoHacia(int fila, int columna){
		tablero.moverFicha(personajeSeleccionado, fila, columna);
		turno.seHaEfectuadoUnMovimiento();
		
	}
	
	public void personajeSeleccionadoAtaqueEspecialA(Personaje otroPersonaje){
		personajeSeleccionado.ataqueEspecial(otroPersonaje);
		turno.seHaEfectuadoUnAtaque();
		
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
		// TODO Auto-generated method stub
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

