package dab.ataquesEspeciales;

import dab.personajes.Personaje;

public class ConvierteteEnChocolate extends AtaqueEspecial {

	@Override
	public void lanzar(int poderPelea, Personaje enemigo){
		enemigo.convertirEnChocolate();
	}
}
