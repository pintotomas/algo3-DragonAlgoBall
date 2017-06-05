package dab.juego;

import dab.dragonBallExceptions.CeldaVacia;
import dab.dragonBallExceptions.MovimientoInvalido;
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
		personajeSeleccionado = null;
	}
	
	
	public void seleccionarPersonaje(Personaje aPersonaje){
		// verificar que personaje sea de equipo o poner como precondicion
		personajeSeleccionado = aPersonaje;
	}
	
	
	public void Mover(Celda celda){
		// a la hora de crear la interfaz grafica, asumo que los lugares de alcanze del jugador cambiaran de color o algo asi, para que se sepa a donde puede ir.
		if(personajeSeleccionado == null) throw new NadaSeleccionado();
		if(personajeSeleccionado.movimientoPosible(celda)){
			//if tablero.caminoDisponible   falta agregar esto.
			 personajeSeleccionado.mover(celda);
			 movio = true;
		}
		else{
			throw new MovimientoInvalido();
		}
	}
	
	public void atacar(Celda celda){
		// el atacar es similar al mover. 
		if(!celda.estaOcupada()) throw new CeldaVacia();
		if(personajeSeleccionado.puedeAtacar(celda)){
			personajeSeleccionado.atacarA(celda.ocupante);
		}
		ataco = true;
	}
	
}
