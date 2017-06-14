package dab.juego;
import java.util.ArrayList;

import dab.dragonBallExceptions.CeldaNoContieneFicha;
import dab.dragonBallExceptions.CeldaOcupada;
import dab.dragonBallExceptions.MovimientoInvalido;
import dab.equipo.Equipo;
import dab.interfaces.IFichaMovible;
import dab.interfaces.IFichaUbicable;
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
		//constructor que ubica personajes en el tablero
		for(int fila = 0; fila < altoDeTablero; fila++){
			for(int columna = 0; columna < anchoDeTablero; columna++){
				tablero[fila][columna] = new Celda(fila, columna);
			}
		}
		this.ubicarPersonajesEnPosicionInicial(equipo1, equipo2);
	}
	
	
	private void ubicarPersonajesEnPosicionInicial(Equipo equipo1, Equipo equipo2){
		//De ubicarlos en el tablero se podria ocupar la clase Juego, asi tenemos un metodo solo
		//de ubicarFichas y lo que recibiria seria una coleccion de fichas y el rango donde ponerlas
		int i = 0;
		int primeraPosicion = anchoDeTablero/2;
		for(Personaje personaje : equipo1.obtenerPersonajes()){
			this.colocarFichaMovil(personaje,0 , primeraPosicion + i);
			i += 1;
		}
		i = 0;
		for(Personaje personaje : equipo2.obtenerPersonajes()){
			this.colocarFichaMovil(personaje,altoDeTablero - 1 , primeraPosicion + i);
			i += 1;
		}
	}
	
	public void removerFicha(IFichaUbicable ficha){
		Celda celdaConLaFicha = tablero[ficha.getPosicion().getFila()][ficha.getPosicion().getColumna()];
		celdaConLaFicha.quitarFichaMovible();
	}
	
	public void colocarFichaMovil(IFichaMovible ficha, int fila,int columna){
		Celda celda = this.obtenerCelda(fila, columna);
		celda.colocarFichaMovil(ficha);
		ficha.setPosicion(celda);
	}
	
	//aca tambien vamos a tener que agregar otro metodo para colocar los consumibles
	
	public void moverFicha(IFichaMovible ficha, int x, int y){
		Celda celdaInicio = tablero[ficha.getPosicion().getFila()][ficha.getPosicion().getColumna()];
		Celda celdaFin = tablero[x][y];
		if (!celdaInicio.estaOcupada()){
			throw new CeldaNoContieneFicha();
		}
		if (celdaFin.estaOcupada()){
			throw new CeldaOcupada();
		}
		ArrayList<Celda> celdasAlcanzables = celdasPermitidas(celdaInicio, ficha.getVelocidad());
		if (ficha.movimientoPosible(celdaFin) && !celdaFin.estaOcupada() && celdasAlcanzables.contains(celdaFin)){
			//&&hayCaminoLibre(celdaInicio, celdaFin)
			celdaInicio.quitarFichaMovible();
			this.colocarFichaMovil(ficha, x, y);
		}
	
		else{
			throw new MovimientoInvalido();
		}
	}
	

	private ArrayList<Celda> adyacentesCeldaValidos(Celda celda, int colMax, int filMax, int colMin, int filMin){
		//para encontrar las 8 celdas adyacentes
		ArrayList<Celda> celdas = new ArrayList<Celda>();
		int newCol, newFil;
		Celda nuevaCelda;
		for(int fil = -1; fil < 2; fil++){
			for(int col = -1; col < 2; col ++){
				if(!(col == 0 && fil == 0)){
					newCol = celda.getColumna() + col;
					newFil =celda.getFila() + fil;
					if(newFil <= filMax && newCol <= colMax && newFil >= filMin && newCol >= colMin){
						nuevaCelda = this.obtenerCelda(newFil, newCol);
						if(!nuevaCelda.estaOcupada()){
							celdas.add(nuevaCelda);
						}
					}
				}
			}
			
		}
		return celdas;
	}
	
	
	private void celdasPermitidasAux(Celda origen, ArrayList<Celda> celdasDisponibles, int colMax, int filMax, int colMin, int filMin){
		for(Celda celda : adyacentesCeldaValidos(origen, colMax, filMax, colMin, filMin)){
			if(!celdasDisponibles.contains(celda)){
				celdasDisponibles.add(celda);
				celdasPermitidasAux(celda,celdasDisponibles, colMax, filMax, colMin, filMin);
			}
		}		
	}
	
	
	public ArrayList<Celda> celdasPermitidas(Celda origen, int rango){
		ArrayList<Celda> celdasDisponibles = new ArrayList<Celda>();
		int filaOrigen, columnaOrigen, maxFila, maxColumna, minFila, minColumna;
		filaOrigen = origen.getFila();
		columnaOrigen = origen.getColumna();
		maxFila = (filaOrigen + rango > (altoDeTablero - 1)) ? filaOrigen : (altoDeTablero - 1);
		maxColumna = (columnaOrigen + rango > (anchoDeTablero - 1)) ? columnaOrigen : (anchoDeTablero - 1);
		minFila = (filaOrigen - rango > 0 ) ? filaOrigen - rango : 0;
		minColumna = (columnaOrigen - rango > 0 ) ? columnaOrigen - rango : 0;
		celdasPermitidasAux(origen, celdasDisponibles, maxColumna, maxFila, minColumna, minFila);
		return celdasDisponibles;			
	}
	
	
	public Celda obtenerCelda(int fila, int columna) {
		return tablero[fila][columna];		
	}
	
	public int getFilaDeLaFicha(IFichaUbicable ficha){
		return ficha.getPosicion().getFila();
	}
	
	public int getColumnaDeLaFicha(IFichaUbicable ficha){
		return ficha.getPosicion().getColumna();
	}
	
	public boolean celdaOcupada(int fila, int columna){
		return this.obtenerCelda(fila, columna).estaOcupada();
	}
	
}
