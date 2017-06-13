package dab.juego;
import java.util.LinkedList;
import java.util.List;

import dab.dragonBallExceptions.CeldaNoContienePersonaje;
import dab.dragonBallExceptions.CeldaOcupada;
import dab.personajes.Personaje;
import dab.potenciadores.Potenciador;


public class Celda {
	int fila, columna;
	Personaje personaje;
	protected List <Potenciador> potenciadores = new LinkedList<Potenciador>(); 
	boolean ocupada;
	
	public Celda(int fila, int columna){
		this.fila = fila;
		this.columna = columna;
		ocupada = false;
	}
	
	public boolean estaOcupada(){
		return ocupada;
	}
	
	public Personaje darPersonajeOcupante(){
		if(!ocupada) throw new CeldaNoContienePersonaje();
		return personaje;
	}
	
	public void colocarPersonaje(Personaje personaje){
		if(ocupada) throw new CeldaOcupada();
		this.personaje = personaje;
		ocupada = true;
		for(Potenciador p: potenciadores){
			personaje.agregarPotenciador(p);
			potenciadores.remove(p);
		}
	}

	public void quitarPersonaje(){
		if(!ocupada) throw new CeldaNoContienePersonaje();
		personaje = null;
		ocupada = false;
	}
	
	public int getFila(){
		return fila;		
	}
	
	public int getColumna(){
		return columna;
	}

}
