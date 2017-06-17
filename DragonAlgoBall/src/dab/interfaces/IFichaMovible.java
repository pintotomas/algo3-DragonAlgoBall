package dab.interfaces;

public interface IFichaMovible extends IFichaUbicable {

	boolean movimientoPosible(IContenedorDeFicha celdaFin);

	int getVelocidad();

	String getNombre();

}
