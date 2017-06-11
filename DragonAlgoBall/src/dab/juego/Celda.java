package dab.juego;
import dab.consumibles.Consumible;

import dab.dragonBallExceptions.CeldaNoContieneConsumible;
import dab.dragonBallExceptions.CeldaNoContienePersonaje;
import dab.dragonBallExceptions.CeldaOcupada;
import dab.personajes.Personaje;


public class Celda {
	int fila, columna;
	boolean ocupa_personaje;
	boolean ocupa_consumible;
	Personaje personaje_ocupante;
	Consumible consumible_ocupante;
	
	public Celda(int fila_, int columna_){
		fila = fila_;
		columna = columna_;
		ocupa_personaje = false;
		ocupa_consumible = false;
	}
	
	public boolean estaOcupadaPorPersonaje(){
		return ocupa_personaje;
	}
	
	public boolean estaOcupadaPorConsumible(){
		return ocupa_personaje;
	}
	
	public Personaje darPersonajeOcupante(){
		if(!ocupa_personaje) throw new CeldaNoContienePersonaje();
		return personaje_ocupante;
	}
	
	public Consumible darConsumibleOcupante(){
		if(!ocupa_consumible) throw new CeldaNoContieneConsumible();
		return consumible_ocupante;
	}
	
	public void colocarPersonaje(Personaje personaje){
		if(ocupa_personaje) throw new CeldaOcupada();
		personaje_ocupante = personaje;
		ocupa_personaje = true;
		if(ocupa_consumible){
			personaje.agregarConsumible(consumible_ocupante);
			ocupa_consumible = false;
		}
	}

	public void quitarPersonaje(){
		if(!ocupa_personaje) throw new CeldaNoContienePersonaje();
		personaje_ocupante = null;
		ocupa_personaje = false;
	}
	
	public int getFila(){
		return fila;		
	}
	
	public int getColumna(){
		return columna;
	}

}
