package dab.juego;

import dab.dragonBallExceptions.MovimientoInvalido;
import dab.personajes.Personaje;

public class Tablero {
	int altoDeTablero = 20;
	int anchoDeTablero = 20;
	Celda[][] tablero = new Celda[altoDeTablero][anchoDeTablero];
	
	//Tambien se podria hacer que la lista de personajes en juego se reciba por parametro, hay que ver mas adelante
	public Tablero(){
		//inicio las celdas del tablero
		for(int fila = 0; fila < altoDeTablero; fila++){
			for(int columna = 0; columna < anchoDeTablero; columna++){
				tablero[fila][columna] = new Celda(fila, columna);
			}
		}
		/*poner coleccionables?
		 */			
		
	}
	
	public void colocarPersonaje(int fila, int columna, Personaje aPersonaje){
		Celda celda = tablero[fila][columna];
		celda.colocarPersonaje(aPersonaje);
		aPersonaje.setPosicion(celda);
	}
	
	public void moverPersonaje(int fila, int columna, Personaje aPersonaje){
		Celda celda = tablero[fila][columna];
		if (celda.estaOcupada() || !aPersonaje.movimientoPosible(celda))
			throw new MovimientoInvalido();
		aPersonaje.getPosicion().quitarPersonaje();
		this.colocarPersonaje(fila, columna, aPersonaje);
	}
	
	public int filaPersonaje(Personaje aPersonaje){
		return aPersonaje.getPosicion().getFila();
	}
	
	public int columnaPersonaje(Personaje aPersonaje){
		return aPersonaje.getPosicion().getColumna();
	}
	
	public boolean celdaOcupada(int fila, int columna){
		return tablero[fila][columna].estaOcupada();
	}
	
}
