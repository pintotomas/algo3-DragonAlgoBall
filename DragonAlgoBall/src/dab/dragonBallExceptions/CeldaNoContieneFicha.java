package dab.dragonBallExceptions;

@SuppressWarnings("serial")
public class CeldaNoContieneFicha extends RuntimeException{
	public CeldaNoContieneFicha(){
		super("la celda no contiene un personaje");	
	}

}
