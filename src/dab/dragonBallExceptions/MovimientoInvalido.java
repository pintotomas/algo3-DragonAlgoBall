package dab.dragonBallExceptions;

@SuppressWarnings("serial")
public class MovimientoInvalido extends RuntimeException {
	public MovimientoInvalido(){
		super("Movimiento invalido");	
	}
}
