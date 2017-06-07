package dab.juego;
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
	
	public boolean estaOcupada(){
		return ocupa_personaje;
	}
	
	public Personaje darOcupante(){
		if(!ocupa_personaje) throw new CeldaVacia();
		return personaje_ocupante;
	}
	
	public void colocarPersonaje(Personaje personaje){
		if(ocupa_personaje) throw new CeldaOcupada();
		personaje_ocupante = personaje;
		ocupa_personaje = true;
		if(ocupa_consumible) {
			consumible_ocupante aplicarConsumible(personaje);
			ocupa_consumible = false;
			consumible_ocupante = null;
		}
	}
	
	public void colocarConsumible(Consumible consumible){
		if(ocupa_personaje) throw new CeldaOcupada();
		consumible_ocupante = consumible;
		ocupa_consumible = true;
	}
	
	public void quitarPersonaje(){
		personaje_ocupante = null;
		ocupa_personaje = false;
	}
	
	public int getFila(){
		return fila;		
	}
	
	public int getColumna(){
		return columna;
	}
	
	public boolean puedeMoverse(Celda destino){
		if(!ocupa_personaje) throw new CeldaVacia();
		if(destino.estaOcupada()) return false;
		return false;
		
	}	
}
