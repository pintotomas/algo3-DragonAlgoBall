package dab.interfaces;

import dab.juego.Celda;

public interface IFicha {
	
	String getNombre();
	boolean permiteSuperposicion();
	void interactuarAlContacto(IFicha ficha);
	void setPosicion(IContenedorDeFicha celda);

}
