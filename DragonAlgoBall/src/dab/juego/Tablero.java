package dab.juego;

import dab.dragonBallExceptions.MovimientoInvalido;
import dab.equipos.Equipo;
import dab.personajes.Personaje;

public class Tablero {
	int altoDeTablero = 20;
	int anchoDeTablero = 20;
	Celda[][] tablero = new Celda[altoDeTablero][anchoDeTablero];
	
	//Tambien se podria hacer que la lista de personajes en juego se reciba por parametro, hay que ver mas adelante
	
	public Tablero(){
		//constructor que no ubica personajes en el tablero
		for(int fila = 0; fila < altoDeTablero; fila++){
			for(int columna = 0; columna < anchoDeTablero; columna++){
				tablero[fila][columna] = new Celda(fila, columna);
			}
		}
	}
		
	
	
	public Tablero(Equipo equipo1, Equipo equipo2){
		//inicio las celdas del tablero
		for(int fila = 0; fila < altoDeTablero; fila++){
			for(int columna = 0; columna < anchoDeTablero; columna++){
				tablero[fila][columna] = new Celda(fila, columna);
			}
		}
		ubicarPersonajes(equipo1, equipo2);		
	}
	
	
	
	
	public void colocarPersonaje(int fila, int columna, Personaje aPersonaje){
		Celda celda = tablero[fila][columna];
		celda.colocarPersonaje(aPersonaje);
		aPersonaje.setPosicion(celda);
	}
	
	private void ubicarPersonajes(Equipo equipo1, Equipo equipo2){
		int i = 0;
		int primeraPosicion = anchoDeTablero/2;
		for(Personaje personaje : equipo1.obtenerPersonajes()){
			this.colocarPersonaje(0,primeraPosicion + i , personaje);
			i += 1;
		}
		i = 0;
		for(Personaje personaje : equipo2.obtenerPersonajes()){
			this.colocarPersonaje(altoDeTablero - 1,primeraPosicion + i , personaje);
			i += 1;
		}
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
