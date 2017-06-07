package dab.juego;

import dab.dragonBallExceptions.AtaqueNoValido;
import dab.dragonBallExceptions.CeldaNoContienePersonaje;
import dab.dragonBallExceptions.MovimientoInvalido;
import dab.dragonBallExceptions.NadaSeleccionado;
import dab.equipos.Equipo;
import dab.personajes.Personaje;

public class Turno {
	Equipo equipo;
	Personaje personajeSeleccionado;
	Celda celdaSeleccionada;
	Tablero tablero;
	boolean movio, ataco, cedioTurno;
	
	public Turno(Equipo equipo_,Tablero tablero_){
		equipo = equipo_;
		tablero = tablero_;
		otorgarKi();
		movio = false;
		ataco = false;
		personajeSeleccionado = null;
	}
	
	private void otorgarKi(){
		/*Collection<Personaje> miembros = equipo.obtenerPersonajes();
		miembros.forEach(personaje -> personaje.agregarKi(5));*/
	}
	public void terminar(){
		/*Collection<Personaje> miembros = equipo.obtenerPersonajes();
		miembros.forEach(personaje -> personaje.pasarTurno());
		*/
	}
	
	public void seleccionarPersonaje(Personaje aPersonaje){
		// verificar que personaje sea de equipo o poner como precondicion
		personajeSeleccionado = aPersonaje;
	}
	
	
	public void Mover(Celda celda){
		// a la hora de crear la interfaz grafica, asumo que los lugares de alcanze del jugador cambiaran de color o algo asi, para que se sepa a donde puede ir.
		if(personajeSeleccionado == null) throw new NadaSeleccionado();
		if(personajeSeleccionado.movimientoPosible(celda) && tablero.trayectoriaValida(celdaSeleccionada, celda)){
			 personajeSeleccionado.mover(celda);
			 movio = true;
		}
		else{
			throw new MovimientoInvalido();
		}
	}
	
	public void atacar(Celda celda){
		// el atacar es similar al mover. 
		if(!celda.estaOcupadaPorPersonaje()) throw new CeldaNoContienePersonaje();
		Personaje personaje_atacado = celda.darPersonajeOcupante();
		if(personajeSeleccionado.puedeAtacar(personaje_atacado)){
			personajeSeleccionado.atacarA(personaje_atacado);
			ataco = true;
		}else throw new AtaqueNoValido();
	}
	
	
	
}
