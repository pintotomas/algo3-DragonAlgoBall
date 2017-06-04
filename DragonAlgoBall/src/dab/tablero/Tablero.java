package dab.tablero;



public class Tablero {
	int altoDeTablero = 20;
	int anchoDeTablero = 20;
	Celda[][] tablero = new Celda[altoDeTablero][anchoDeTablero];
	
	public Tablero(){
		
		//inicio las celdas del tablero
		for(int fila = 0; fila < altoDeTablero; fila++){
			for(int columna = 0; columna < anchoDeTablero; columna++){
				tablero[fila][columna] = new Celda();
			}
		}
		/*poner coleccionables?
		 */
		
		
	
	
	}
	
	
	
}
