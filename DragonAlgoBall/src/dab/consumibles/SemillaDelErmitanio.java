package dab.consumibles;

import dab.personajes.Personaje;

public class SemillaDelErmitanio extends Consumible {
	protected int vida_recuperada;
	public SemillaDelErmitanio(){
		nombre = "Semilla del Ermitanio";
		vida_recuperada = 100;
	}

	@Override
	public boolean aplicarConsumible(Personaje personaje) {
		personaje.agregarHp(vida_recuperada);
		return false;
	}
}