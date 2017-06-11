package dab.ataquesEspeciales;

import dab.consumibles.Inutilizador;
import dab.personajes.Personaje;

public class ConvierteteEnChocolate extends AtaqueEspecial {

	public ConvierteteEnChocolate(Personaje lanzador) {
		super(lanzador);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void lanzar(Personaje enemigo){
		enemigo.agregarConsumible(new Inutilizador());
	}
}
