package dab.interfaces;

import dab.potenciadores.Potenciador;

public interface IFichaUbicable {

	ICoordenadasXY getPosicion();

	void setPosicion(ICoordenadasXY celda);

	void agarrarPotenciador(Potenciador p);

}
