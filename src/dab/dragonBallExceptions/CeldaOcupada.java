package dab.dragonBallExceptions;

@SuppressWarnings("serial")
public class CeldaOcupada extends RuntimeException {
	public CeldaOcupada(){
		super("La celda esta ocupada.");
	}
	
}
