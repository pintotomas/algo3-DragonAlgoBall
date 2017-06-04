package dab.juego;

import dab.dragonBallExceptions.NadaSeleccionado;
import dab.equipos.Equipo;
import dab.personajes.Personaje;

public class Turno {
	Equipo equipo;
	Personaje personajeSeleccionado;
	Celda celdaSeleccionada;
	boolean movio, ataco, cedioTurno;
	
	public Turno(Equipo equipo_){
		equipo = equipo_;
		movio = false;
		ataco = false;
		cedioTurno = false;
		celdaSeleccionada = null;
		personajeSeleccionado = null;
	}
	
	
	public void seleccionarCelda(Celda celda){
		celdaSeleccionada = celda;
	}
	
	
	public void Mover(Celda celda){
		// a la hora de crear la interfaz grafica, asumo que los lugares de alcanze del jugador cambiaran de color o algo asi, para que se sepa a donde puede ir.
		if(personajeSeleccionado == null) throw new NadaSeleccionado();
		if(personajeSeleccionado.movimientoPosible(celda)){
			 celda.colocarPersonaje(personajeSeleccionado);
			 celdaSeleccionada.quitarPersonaje();
		}
		
	}
	
	
	public void atacar(Celda celda){
		// el atacar es similar al mover. 
		
		
	}
	
}
