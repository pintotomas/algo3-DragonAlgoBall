package dab.juego;
import dab.dragonBallExceptions.CeldaNoContieneFicha;
import dab.dragonBallExceptions.CeldaOcupada;

import dab.interfaces.IFichaMovible;
import dab.interfaces.IFichaUbicable;
import dab.interfaces.IContenedorDeFicha;
import dab.interfaces.IFicha;


public class Celda implements IContenedorDeFicha{
	
	int fila, columna;
//	IFichaMovible ficha;
//	protected List <Potenciador> potenciadores = new LinkedList<Potenciador>(); 
	boolean ocupada;
	IFicha ficha;
	
	public Celda(int fila, int columna){
		this.fila = fila;
		this.columna = columna;
		ocupada = false;
	}
	
	public boolean estaOcupada(){
		return ocupada;
	}
	
	public IFicha getFicha(){
		if(!ocupada) throw new CeldaNoContieneFicha();
		return ficha;
	}
	
	public void colocarFicha(IFicha ficha){
		
		if (ocupada){
			//Si estaba ocupada, puede haber un consumidor
			if(!this.ficha.permiteSuperposicion()) throw new CeldaOcupada();
			//Si lo habia, la ficha interactua con el
			ficha.interactuarAlContacto(this.ficha);
		}
		this.ficha = ficha;
		ocupada = true;
//		if (!potenciadores.isEmpty()){
//			for(Potenciador p: potenciadores){
//				ficha.agarrarPotenciador(p);
//				potenciadores.remove(p);
//			}
		}
		
	
	public void quitarFichaMovible(){
		ficha = null;
		ocupada = false;
	}
	
	public int getFila(){
		return fila;		
	}
	
	public int getColumna(){
		return columna;
	}

	public boolean permitePosicionarUnaFicha() {
		if (ocupada){
			return ficha.permiteSuperposicion();
		}
		
		return true;
	}

}
