package dab.interfaces;

import java.util.Collection;

import dab.personajes.Personaje;

public interface IProveedorDeVidaDePersonajes {
	
	public Collection<Personaje> obtenerPersonajes();
	public double obtenerVidaDelPersonaje(String nombre);
	//hacer una sola funcion en Equipo que devuelva un arreglo con el porcentaje de vida 
	// de c/ personaje y actualizar esta interfaz y a gohan
}
