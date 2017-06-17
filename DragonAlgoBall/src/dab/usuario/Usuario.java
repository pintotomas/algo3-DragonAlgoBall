package dab.usuario;

import dab.equipo.Equipo;

public class Usuario {
	private String nombreUsuario;
	private Equipo equipoUsuario;
	
	public Usuario(Equipo equipo){
		this.equipoUsuario = equipo;
	}
	
	public void setNombre(String nombre){
		this.nombreUsuario = nombre;
	}
	
	public String getNombreUsuario(){
		return this.nombreUsuario;
	}
	
	public Equipo getEquipo(){
		return this.equipoUsuario;
	}
		
}