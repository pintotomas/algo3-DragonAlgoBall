package dab.juego;
import dab.dragonBallExceptions.CeldaNoContieneFicha;
import dab.dragonBallExceptions.CeldaOcupada;
import dab.interfaces.Ficha;
import dab.interfaces.IContenedorDeFicha;


public class Celda implements IContenedorDeFicha{
	
	int fila, columna;
//	IFichaMovible ficha;
//	protected List <Potenciador> potenciadores = new LinkedList<Potenciador>(); 
	boolean ocupada;
	Ficha ficha;
	
	public Celda(int fila, int columna){
		this.fila = fila;
		this.columna = columna;
		ocupada = false;
	}
	
	public boolean estaOcupada(){
		return ocupada;
	}
	
	public Ficha getFicha(){
		if(!ocupada) throw new CeldaNoContieneFicha();
		return ficha;
	}
	
	public void colocarFicha(Ficha ficha){
		
		if (ocupada){
			//Si estaba ocupada, puede haber un consumidor
			if(!this.ficha.permiteSolapamiento()) throw new CeldaOcupada();
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
			return ficha.permiteSolapamiento();
		}
		
		return true;
	}

}
