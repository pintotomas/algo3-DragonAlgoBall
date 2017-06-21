package dab.juego;

import dab.equipo.Equipo;
import dab.personajes.Personaje;

public class Turno {
	Equipo equipo;
	Celda celdaSeleccionada = null;
	Tablero tablero;
	private int movimientosRestantes = 1;
	private int ataquesRestantes = 1;
	
	public Turno(Equipo equipo,Tablero tablero){
		this.equipo = equipo;
		this.tablero = tablero;
		equipo.nuevoTurno();
	}
	

	public Equipo getEquipo(){
		return equipo;
	}
	
	public void seHaEfectuadoUnMovimiento(){
		movimientosRestantes -= 1;
	}
	
	public boolean quedanMovimientosDisponibles(){
		return movimientosRestantes > 0;
	}
	
	
	public void seHaEfectuadoUnAtaque(){
		ataquesRestantes -= 1;
	}
	
	public boolean quedanAtaquesDisponibles(){
		return ataquesRestantes > 0;
		
	}
	
	public boolean haFinalizado(){
		return !quedanAtaquesDisponibles() && !quedanMovimientosDisponibles();
	}

	public boolean puedeJugar(Personaje aPersonaje) {
		return equipo.existePersonajeEnEquipo(aPersonaje);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
