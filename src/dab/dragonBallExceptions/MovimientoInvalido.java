package dab.dragonBallExceptions;

@SuppressWarnings("serial")
public class MovimientoInvalido extends RuntimeException {
	public MovimientoInvalido(){
		super("movimiento invalido");	
	}
}
