package dab.usuario;

import dab.equipo.Equipo;

public class Usuario {
	private String nombre;
	private Equipo equipoUsuario;
	
	public Usuario(Equipo equipo, String nombre){
		this.equipoUsuario = equipo;
		this.nombre = nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombreUsuario(){
		return this.nombre;
	}
	
	public Equipo getEquipo(){
		return this.equipoUsuario;
	}
		
}