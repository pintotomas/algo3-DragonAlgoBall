package dab.juego;
import dab.dragonBallExceptions.CeldaNoContienePersonaje;
import dab.dragonBallExceptions.MovimientoInvalido;
import dab.equipo.Equipo;
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
		this.ubicarPersonajesEnPosicionInicial(equipo1, equipo2);		
	}
	
	private void ubicarPersonajesEnPosicionInicial(Equipo equipo1, Equipo equipo2){
		int i = 0;
		int primeraPosicion = anchoDeTablero/2;
		for(Personaje personaje : equipo1.obtenerPersonajes()){
			this.colocarPersonaje(personaje,0 , primeraPosicion + i);
			i += 1;
		}
		i = 0;
		for(Personaje personaje : equipo2.obtenerPersonajes()){
			this.colocarPersonaje(personaje,altoDeTablero - 1 , primeraPosicion + i);
			i += 1;
		}
	}
	
	public void colocarPersonaje(Personaje personaje, int fila,int columna){
		Celda celda = this.obtenerCelda(fila, columna);
		celda.colocarPersonaje(personaje);
		personaje.setPosicion(celda);
	}
	
	public void moverPersonaje(Personaje aPersonaje, int x, int y){
		
		Celda celdaInicio = tablero[aPersonaje.getPosicion().getFila()][aPersonaje.getPosicion().getColumna()];
		//Cambiar para que personaje en vez de conocer la celda, conozca sus coordenadas x,y
		Celda celdaFin = tablero[x][y];
		if (!celdaInicio.estaOcupada()){
			throw new CeldaNoContienePersonaje();
		}
		Personaje personaje = celdaInicio.getPersonaje();
		if (celdaInicio.getPersonaje().movimientoPosible(celdaFin) && !celdaFin.estaOcupada()){
			//&&hayCaminoLibre(celdaInicio, celdaFin)
			celdaInicio.quitarPersonaje();
			celdaFin.colocarPersonaje(personaje);
		}
		else{
			throw new MovimientoInvalido();
		}
	}
	
	public boolean trayectoriaValida(Celda origen, Celda destino){
		int filaO, filaD, columnaO, columnaD,x,y;
		filaO = origen.getFila();
		filaD = destino.getFila();
		columnaO = origen.getColumna();
		columnaD = destino.getColumna();
		
		if(filaO > filaD) x = -1;
		else if (filaD > filaO) x = 1;
		else x = 0;
		
		if(columnaO > filaD) y = -1;
		else if (columnaD > columnaO) y = 1;
		else y = 0;
		
		
		while(filaO != filaD || columnaO != columnaD){
			if(this.obtenerCelda(filaO, columnaO).estaOcupada()) return false;
			filaO += x;
			columnaO += y;	
		}
		return true;
		
	}
	
	public Celda obtenerCelda(int fila, int columna) {
		return tablero[fila][columna];		
	}
	
	public int filaPersonaje(Personaje personaje){
		return personaje.getPosicion().getFila();
	}
	
	public int columnaPersonaje(Personaje personaje){
		return personaje.getPosicion().getColumna();
	}
	
	public boolean celdaOcupada(int fila, int columna){
		return this.obtenerCelda(fila, columna).estaOcupada();
	}
	
}
