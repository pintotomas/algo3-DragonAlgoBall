package dab.interfaces;

import dab.potenciadores.Potenciador;

public interface IFichaUbicable extends Ficha{

	IContenedorDeFicha getPosicion();

	void setPosicion(IContenedorDeFicha celda);


}
