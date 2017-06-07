package dab.dragonBallExceptions;

@SuppressWarnings("serial")
public class CeldaNoContienePersonaje extends RuntimeException{
	public CeldaNoContienePersonaje(){
		super("la celda no contiene un personaje");	
	}

}
