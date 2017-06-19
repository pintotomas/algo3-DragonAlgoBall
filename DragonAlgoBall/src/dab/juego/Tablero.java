package dab.juego;
import java.util.ArrayList;

import dab.dragonBallExceptions.CeldaNoContieneFicha;
import dab.dragonBallExceptions.CeldaOcupada;
import dab.dragonBallExceptions.MovimientoInvalido;
import dab.equipo.Equipo;
import dab.interfaces.IFichaMovible;
import dab.interfaces.IFichaUbicable;
import dab.personajes.Personaje;
import dab.potenciadores.Potenciador;

public class Tablero{
	private int altoDeTablero;
	private int anchoDeTablero;
	private Celda[][] coleccionCeldas;
	Equipo equipo1, equipo2;
	//Tambien se podria hacer que la lista de personajes en juego se reciba por parametro, hay que ver mas adelante
	
	public Tablero(int altoDeTablero, int anchoDeTablero){
		//constructor que no ubica personajes en el tablero
		
		this.altoDeTablero = altoDeTablero;
		this.anchoDeTablero = anchoDeTablero;
		coleccionCeldas = new Celda[altoDeTablero][anchoDeTablero];
		
		for(int fila = 0; fila < altoDeTablero; fila++){
			for(int columna = 0; columna < anchoDeTablero; columna++){
				coleccionCeldas[fila][columna] = new Celda(fila, columna);
			}
		}
	}
		
	public Tablero(int altoDeTablero, int anchoDeTablero, Equipo equipo1_, Equipo equipo2_){
		this(altoDeTablero, anchoDeTablero);
		equipo1 = equipo1_;
		equipo2 = equipo2_;
		int columnaInicial = anchoDeTablero/2;
		int filaActual = 0;
		this.ubicarPersonajesEnPosicionInicial(equipo1, filaActual, columnaInicial);
		filaActual += altoDeTablero - 1;
		this.ubicarPersonajesEnPosicionInicial(equipo2, filaActual, columnaInicial);
	}
		
		
	
	
	private void ubicarPersonajesEnPosicionInicial(Equipo equipo1, int fila, int columnaInicial){
		//De ubicarlos en el tablero se podria ocupar la clase Juego, asi tenemos un metodo solo
		//de ubicarFichas y lo que recibiria seria una coleccion de fichas y el rango donde ponerlas
		int i = 0;
		for(Personaje personaje : equipo1.obtenerPersonajes()){
			this.colocarFichaMovil(personaje,fila , columnaInicial + i);
			i += 1;
		}
	}
	public void removerFicha(IFichaUbicable ficha){
		Celda celdaConLaFicha = coleccionCeldas[ficha.getPosicion().getFila()][ficha.getPosicion().getColumna()];
		celdaConLaFicha.quitarFichaMovible();
	}
	
	public void colocarFichaMovil(IFichaMovible ficha, int fila,int columna){
		Celda celda = this.obtenerCelda(fila, columna);
		celda.colocarFichaMovil(ficha);
		ficha.setPosicion(celda);
	}
	
	public void colocarPotenciador(Potenciador consumible, int fila, int columna){
		Celda celda = this.obtenerCelda(fila, columna);
		celda.colocarPotenciador(consumible);
		
	}
	
	public void moverFicha(IFichaMovible ficha, int fila, int columna){
		Celda celdaInicio = coleccionCeldas[ficha.getPosicion().getFila()][ficha.getPosicion().getColumna()];
		Celda celdaFin = coleccionCeldas[fila][columna];
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
			this.colocarFichaMovil(ficha, fila, columna);
		}
	
		else{
			throw new MovimientoInvalido();
		}
	}
	
	public Equipo getEquipoEnemigo(Personaje personaje){
		Equipo equipoEnemigo = equipo1;
		if(personaje.getEquipo() == equipo1){
			equipoEnemigo = equipo2;
		}
		return equipoEnemigo;
		
	}
	
	public ArrayList<Personaje> personajesAtacables(Personaje personaje){
		Equipo equipoEnemigo = getEquipoEnemigo(personaje);
		ArrayList<Personaje> atacables = new ArrayList<Personaje>();   // collection no se puede castear a ArrayList asi que lo tengo que hacer asi.
		for(Personaje enemigo : equipoEnemigo.obtenerPersonajes()){
			if(personaje.puedeAtacar(enemigo)){
				atacables.add(enemigo);
			}
		}
		return atacables;
				
		
	}
	
	
	
	/*********************************
	 * 
	 * celdas a las que se puede mover
	 * 
	 **********************************/
	

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
		maxFila = (filaOrigen + rango < (altoDeTablero - 1)) ? filaOrigen + rango : (altoDeTablero - 1);
		maxColumna = (columnaOrigen + rango < (anchoDeTablero - 1)) ? columnaOrigen + rango : (anchoDeTablero - 1);
		minFila = (filaOrigen - rango > 0 ) ? filaOrigen - rango : 0;
		minColumna = (columnaOrigen - rango > 0 ) ? columnaOrigen - rango : 0;
		celdasPermitidasAux(origen, celdasDisponibles, maxColumna, maxFila, minColumna, minFila);
		return celdasDisponibles;			
	}
	
	
	/********************************/
	public Celda obtenerCelda(int fila, int columna) {
		return coleccionCeldas[fila][columna];		
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

	public Celda[][] getCeldas(){
		return coleccionCeldas;
	}
	
	public int getAltura(){
		return altoDeTablero;
	}
	
	public int getAncho(){
		return anchoDeTablero;
	}
}

