package dab.juego;
import dab.dragonBallExceptions.*;
import dab.personaje.Personaje;

public class Celda {
	int fila, columna;
	boolean ocupada;
	Personaje ocupante;
	boolean esferaDelDragon, semillaDelHermitanio, nubeVoladora;
	
	public Celda(int fila_, int columna_){
		fila = fila_;
		columna = columna_;
		ocupada = false;
		esferaDelDragon = false;
		semillaDelHermitanio = false;
		nubeVoladora = false;
	}
	
	public boolean estaOcupada(){
		return ocupada;
	}
	
	public Personaje darOcupante(){
		if(!ocupada) throw new CeldaVacia();
		return ocupante;
	}
	
	public void colocarPersonaje(Personaje personaje){
		if(ocupada) throw new CeldaOcupada();
		ocupante = personaje;
		ocupada = true;
	}
	
	public void quitarPersonaje(){
		ocupante = null;
		ocupada = false;
	}
	
	public void setesferaDelDragon(boolean estado){
		esferaDelDragon = estado;
	}
	
	public void setNubeVoladora(boolean estado){
		nubeVoladora = estado;		
	}
	
	public void setSemilla(boolean estado){
		semillaDelHermitanio = estado;
	}
	
	public int getFila(){
		return fila;		
	}
	
	public int getColumna(){
		return columna;
	}
	
	public boolean puedeMoverse(Celda destino){
		if(!ocupada) throw new CeldaVacia();
		if(destino.estaOcupada()) return false;
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
