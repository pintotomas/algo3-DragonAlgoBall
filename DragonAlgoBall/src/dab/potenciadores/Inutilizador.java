package dab.potenciadores;

import dab.juego.Celda;

public class Inutilizador extends Potenciador {
	
	public Inutilizador(){
		//Problema?: No usa celda
		duracion = 3;
		multiplicadorVelocidad = 0;
		multiplicadorPoderDePelea = 1;
		vidaExtra = 0;
		multiplicadorDistanciaAtaque = 0;
		multiplicadorAlcance = 0;
		kiExtra = -5;
	}
	
	@Override
	public double getMultiplicadorPoderDePelea() {
		return multiplicadorPoderDePelea;
	}

	@Override
	public double getMultiplicadorVelocidad() {
		return multiplicadorVelocidad;
	}

	@Override
	public double getVidaExtra() {
		return vidaExtra;
	}

	@Override
	public int getMultiplicadorAlcance() {
		return multiplicadorAlcance;
	}

	@Override
	public int getMultiplicadorDistanciaAtaque() {
		return multiplicadorDistanciaAtaque;
	}

	@Override
	public int getKiExtra() {
		return kiExtra;
	}

}
