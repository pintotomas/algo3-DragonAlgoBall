package dab.juego;
import java.util.LinkedList;
import java.util.List;

import dab.dragonBallExceptions.CeldaNoContieneFicha;
import dab.dragonBallExceptions.CeldaOcupada;
import dab.interfaces.IContenedorDeFicha;
import dab.interfaces.IFichaMovible;
import dab.potenciadores.Potenciador;


public class Celda implements IContenedorDeFicha{
	int x, y;
	IFichaMovible ficha;
	protected List <Potenciador> potenciadores = new LinkedList<Potenciador>(); 
	boolean ocupada;
	
	public Celda(int fila, int columna){
		this.x = fila;
		this.y = columna;
		ocupada = false;
	}
	
	public boolean estaOcupada(){
		return ocupada;
	}
	
	public IFichaMovible getFicha(){
		if(!ocupada) throw new CeldaNoContieneFicha();
		return ficha;
	}
	
	public void colocarFichaMovil(IFichaMovible ficha){
		if(ocupada) throw new CeldaOcupada();
		this.ficha = ficha;
		ocupada = true;
		for(Potenciador p: potenciadores){
			ficha.agarrarPotenciador(p);
			potenciadores.remove(p);
		}
	}
	
	//hay que agregar un metodo para colocar los consumibles que reciba un IFichaUbicable

	public void quitarFichaMovible(){
		ficha = null;
		ocupada = false;
	}
	
	public int getX(){
		return x;		
	}
	
	public int getY(){
		return y;
	}

}
