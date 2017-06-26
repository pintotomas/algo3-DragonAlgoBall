package dab.juego;

import dab.equipo.Equipo;
import dab.personajes.Personaje;
import dab.usuario.Usuario;

public class Turno {
	
	private Equipo equipo;	
	private int movimientosRestantes = 1;
	private int ataquesRestantes = 1;
	private Usuario user;
	
	public Turno(Usuario user){
		this.equipo = user.getEquipo();
		equipo.nuevoTurno();
		this.user = user;
	}
	

	public Equipo getEquipo(){
		return equipo;
	}
	
	public void seHaEfectuadoUnMovimiento(){
		user.haEfectuadoUnMovimiento();
		movimientosRestantes -= 1;
	}
	
	public boolean quedanMovimientosDisponibles(){
		return movimientosRestantes > 0;
	}
	
	
	public void seHaEfectuadoUnAtaque(){
		user.haEfectuadoUnAtaque();
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


	public Usuario usuarioActual() {
		// TODO Auto-generated method stub
		return user;
	}


	public boolean esDe(Usuario jugadorActual) {
		// TODO Auto-generated method stub
		return jugadorActual.equals(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
