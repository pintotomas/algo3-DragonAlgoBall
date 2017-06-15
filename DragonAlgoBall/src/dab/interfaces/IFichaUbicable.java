package dab.interfaces;

import dab.potenciadores.Potenciador;

public interface IFichaUbicable {

	IContenedorDeFicha getPosicion();

	void setPosicion(IContenedorDeFicha celda);

	void agarrarPotenciador(Potenciador p);

}
