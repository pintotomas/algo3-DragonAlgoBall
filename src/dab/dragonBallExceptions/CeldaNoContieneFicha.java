package dab.dragonBallExceptions;

@SuppressWarnings("serial")
public class CeldaNoContieneFicha extends RuntimeException{
	public CeldaNoContieneFicha(){
		super("La celda no contiene una ficha.");	
	}

}
