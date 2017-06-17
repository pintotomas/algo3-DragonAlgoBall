package dab.dragonBallExceptions;

@SuppressWarnings("serial")
public class SoloDosEquiposError extends RuntimeException {
	public SoloDosEquiposError(){
		super("Solo se puede jugar con dos equipos!");
	}
}
