package dab.juego;

import dab.dragonBallExceptions.MovimientoInvalido;
import dab.personajes.Personaje;

public class Tablero {
	int altoDeTablero = 20;
	int anchoDeTablero = 20;
	Celda[][] tablero = new Celda[altoDeTablero][anchoDeTablero];
	
	//Tambien se podria hacer que la lista de personajes en juego se reciba por parametro, hay que ver mas adelante
	public Tablero(int cantidadPersonajes){
		//inicio las celdas del tablero
		for(int fila = 0; fila < altoDeTablero; fila++){
			for(int columna = 0; columna < anchoDeTablero; columna++){
				tablero[fila][columna] = new Celda(fila, columna);
			}
		}
	}
	
	public void colocarPersonaje(int fila, int columna, Personaje aPersonaje){
		
		tablero[fila][columna].colocarPersonaje(aPersonaje);
		aPersonaje.setPosicion(tablero[fila][columna]);
		
	}
	
	public void moverPersonaje(int fila, int columna, Personaje aPersonaje){
		if (aPersonaje.movimientoPosible(tablero[fila][columna])){
			aPersonaje.getPosicion().quitarPersonaje();
			this.colocarPersonaje(fila, columna, aPersonaje);
		}
		else throw new MovimientoInvalido();
	}
	
	public int filaPersonaje(Personaje aPersonaje){
		return aPersonaje.getPosicion().getFila();
	}
	
	public int columnaPersonaje(Personaje aPersonaje){
		return aPersonaje.getPosicion().getColumna();
	}
	
}
