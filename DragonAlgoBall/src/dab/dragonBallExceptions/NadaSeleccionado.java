package dab.dragonBallExceptions;

@SuppressWarnings("serial")
public class NadaSeleccionado extends RuntimeException{
	public NadaSeleccionado(){
		super("no hay nada seleccionado");
	}

}
