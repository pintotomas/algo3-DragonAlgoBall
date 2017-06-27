package dab.dragonBallExceptions;

@SuppressWarnings("serial")
public class AunNoHayGanador extends RuntimeException {
	public AunNoHayGanador(){
		super("Aun no hay ganador");	
	}

}
