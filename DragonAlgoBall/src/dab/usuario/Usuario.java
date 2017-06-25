package dab.usuario;

import dab.equipo.Equipo;
import dab.personajes.Personaje;

public class Usuario {
	
	private String nombre;
	private Equipo equipo;
	private int cantidadPersonajesRestantesParaPerder = 0;
	private int cantidadDeEsferasDelDragonParaGanar = 7;
	
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

	public boolean haPerdido() {
		// TODO Auto-generated method stub
		return equipo.cantidadParticipantes() == cantidadPersonajesRestantesParaPerder;
	}

	public boolean haConseguidoItemsParaGanar() {
		// TODO Auto-generated method stub
		return equipo.cantidadItemsParaGanar() == cantidadDeEsferasDelDragonParaGanar;
	}


		
}