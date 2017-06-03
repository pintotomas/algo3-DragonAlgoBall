package dab.ataquesEspeciales;

import dab.personajes.Personaje;

public class ConvierteteEnChocolate extends AtaqueEspecial {
	
	private int kiNecesario = 5;  //en realidad esto no sirve porque esta en el trabajo.
	
	
	@Override
	public void lanzar(int poderPelea, Personaje enemigo){
		enemigo.convertirEnChocolate();
	}
	@Override
	public boolean disponible(int ki) {
		return ki >= kiNecesario;
	}

	

}
