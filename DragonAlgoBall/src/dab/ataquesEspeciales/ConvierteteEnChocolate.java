package dab.ataquesEspeciales;

import dab.personajes.Personaje;
import dab.potenciadores.Inutilizador;

public class ConvierteteEnChocolate extends AtaqueEspecial {

	public ConvierteteEnChocolate(Personaje lanzador) {
		super(lanzador);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void lanzar(Personaje enemigo){
		enemigo.agarrarPotenciador(new Inutilizador());
	}
}
