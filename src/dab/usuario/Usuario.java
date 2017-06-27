package dab.usuario;

import java.util.ArrayList;

import dab.equipo.Equipo;
import dab.personajes.Personaje;
import dab.potenciadores.Potenciador;

public class Usuario {
	
	public static int cantidadEsferasDelDragonParaGanar = 7;
	
	private String nombre;
	private Equipo equipo;
	private int cantidadPersonajesRestantesParaPerder = 0;
	private int cantidadDeEsferasDelDragonParaGanar = cantidadEsferasDelDragonParaGanar;

	private int cantidadMovimientos;

	private int cantidadDeAsesinatos;

	private int cantidadDeAtaques;

	private int cantidadDePersonajesPerdidos;
	
	public Usuario(Equipo equipo, String nombre){
		this.equipo = equipo;
		this.nombre = nombre;
		cantidadMovimientos = 0;
		cantidadDeAsesinatos = 0;
		cantidadDePersonajesPerdidos = 0;
		cantidadDeAtaques = 0;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
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

	public boolean sigueTeniendoAlPersonaje(Personaje aPersonaje) {
		// TODO Auto-generated method stub
		return equipo.existePersonajeEnEquipo(aPersonaje);
	}

	public ArrayList<Potenciador> getPotenciadoresPerdidos() {
		// TODO Auto-generated method stub
		return equipo.ultimosObjetosPerdidos();
	}

	public int getCantidadMovimientos() {
		// TODO Auto-generated method stub
		return cantidadMovimientos;
	}

	public int getCantidadDeAtaques() {
		// TODO Auto-generated method stub
		return cantidadDeAtaques;
	}

	public int getCantidadDeAsesinatos() {
		// TODO Auto-generated method stub
		return cantidadDeAsesinatos;
	}

	public int getCantidadDePersonajesPerdidos() {
		// TODO Auto-generated method stub
		return cantidadDePersonajesPerdidos;
	}

	public int cantidadDeItemsParaGanar() {
		// TODO Auto-generated method stub
		return equipo.cantidadItemsParaGanar();
	}

	public void haEfectuadoUnAtaque() {
		// TODO Auto-generated method stub
		cantidadDeAtaques += 1;
	}

	public void haEfectuadoUnMovimiento() {
		// TODO Auto-generated method stub
		cantidadMovimientos += 1;
	}

	public void notificarUnaBaja() {
		// TODO Auto-generated method stub
		cantidadDePersonajesPerdidos += 1;
	}

	public void notificarUnAsesinato() {
		// TODO Auto-generated method stub
		cantidadDeAsesinatos += 1;
	}


		
}