package dab.dragonBallExceptions;

@SuppressWarnings("serial")
public class CeldaNoContieneConsumible extends RuntimeException{
	public CeldaNoContieneConsumible(){
		super("la celda no contiene un consumible");	
	}

}