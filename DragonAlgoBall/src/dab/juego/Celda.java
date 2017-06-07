package dab.juego;
import dab.consumibles.Consumible;
import dab.dragonBallExceptions.*;
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
	
	public Personaje darPersonajeOcupante(){
		if(!ocupa_personaje) throw new CeldaVacia();
		return personaje_ocupante;
	}
	
	public Consumible darConsumibleOcupante(){
		if(!ocupa_consumible) throw new CeldaVacia();
		return consumible_ocupante;
	}
	
	public void colocarConsumible(Consumible consumible){
		if(ocupa_personaje) throw new CeldaOcupada();
		consumible_ocupante = consumible;
		ocupa_consumible = true;
	}
	
	public void colocarPersonaje(Personaje personaje_nuevo){
		if(ocupa_personaje) throw new CeldaOcupada();
		personaje_ocupante = personaje_nuevo;
		ocupa_personaje = true;
		if(ocupa_consumible) {
			this.quitarConsumible();
		}
	}
	
	public void quitarPersonaje(){
		personaje_ocupante = null;
		ocupa_personaje = false;
	}
	
	public void quitarConsumible(){
		consumible_ocupante = null;
		ocupa_consumible = false;
	}
	
	public int getFila(){
		return fila;		
	}
	
	public int getColumna(){
		return columna;
	}
	
	public boolean puedeMoverse(Celda destino){
		if(!ocupa_personaje) throw new CeldaVacia();
		if(destino.estaOcupadaPorPersonaje()) return false;
		return false;
	}	
}
