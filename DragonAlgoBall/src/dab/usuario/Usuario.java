package dab.usuario;

import dab.equipo.Equipo;
import dab.personajes.Personaje;

public class Usuario {
	private String nombre;
	private Equipo equipo;
	
	public Usuario(Equipo equipo, String nombre){
		this.equipo = equipo;
		this.nombre = nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombreUsuario(){
		return this.nombre;
	}
	
	public Equipo getEquipo(){
		return this.equipo;
	}

	public void notificarQueSeAtacoA(Personaje aPersonaje) {
		// TODO Auto-generated method stub
		equipo.notificarAtaqueHacia(aPersonaje);
	}


		
}