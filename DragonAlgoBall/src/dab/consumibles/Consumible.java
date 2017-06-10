package dab.consumibles;

import dab.juego.Celda;
import dab.personajes.Personaje;

public abstract class Consumible{
	protected String nombre;
	protected Celda posicion;

	public abstract boolean aplicarConsumible(Personaje personaje);
}
