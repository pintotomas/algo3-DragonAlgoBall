package dab.interfaces;

import dab.equipo.Equipo;

public interface IFichaMovible extends IFichaUbicable {

	boolean movimientoPosible(IContenedorDeFicha celdaFin);

	int getVelocidad();
	
	Equipo getEquipo();
	
	
	
	double getVida();

}
