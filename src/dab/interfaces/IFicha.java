package dab.interfaces;

public interface IFicha {
	
	String getNombre();
	boolean permiteSuperposicion();
	void interactuarAlContacto(IFicha ficha);
	void setPosicion(IContenedorDeFicha celda);

}
