package dab.interfaces;

public interface Ficha {

	boolean permiteSolapamiento();

	void interactuarAlContacto(Ficha fichita);
	String getNombre();
}
