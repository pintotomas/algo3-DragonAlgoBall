package dab.ataquesEspeciales;

import dab.personaje.Personaje;

public class ConvierteteEnChocolate extends AtaqueEspecial {

	@Override
	public void lanzar(int poderPelea, Personaje enemigo){
		enemigo.convertirEnChocolate();
	}
}
