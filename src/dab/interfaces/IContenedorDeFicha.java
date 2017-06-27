package dab.interfaces;

import dab.dragonBallExceptions.CeldaNoContieneFicha;

public interface IContenedorDeFicha {
	
	public int getFila();
	public int getColumna();
	public IFicha getFicha() throws CeldaNoContieneFicha;
}
