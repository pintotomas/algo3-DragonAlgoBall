package dab.dragonBallExceptions;

@SuppressWarnings("serial")
public class CeldaVacia extends RuntimeException{
	public CeldaVacia(){
		super("la celda esta vacia");	
	}

}
