package dab.juego;
import dab.personajes.Personaje;

public class Tablero {
	int altoDeTablero = 20;
	int anchoDeTablero = 20;
	Celda[][] tablero = new Celda[altoDeTablero][anchoDeTablero];
	Personaje[] personajesEnJuego; //Guardo los pjs para aumentar ki cuando pasen los turnos, y podria servir para mas
	//Tambien se podria hacer que la lista de personajes en juego se reciba por parametro, hay que ver mas adelante
	
	public Tablero(int cantidadPersonajes){

		personajesEnJuego = new Personaje[cantidadPersonajes];
		//inicio las celdas del tablero
		for(int fila = 0; fila < altoDeTablero; fila++){
			for(int columna = 0; columna < anchoDeTablero; columna++){
				tablero[fila][columna] = new Celda(fila, columna);
			}
		}
	}
	
	public void colocarPersonaje(int fila, int columna, Personaje aPersonaje){
		
		tablero[fila][columna].colocarPersonaje(aPersonaje);
		
	}
	
}
