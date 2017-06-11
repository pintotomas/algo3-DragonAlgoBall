package dab.consumibles;

import dab.juego.Celda;

public class Inutilizador extends Consumible {
	
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
		// TODO Auto-generated method stub
		return multiplicadorPoderDePelea;
	}

	@Override
	public double getMultiplicadorVelocidad() {
		// TODO Auto-generated method stub
		return multiplicadorVelocidad;
	}

	@Override
	public double getVidaExtra() {
		// TODO Auto-generated method stub
		return vidaExtra;
	}

	@Override
	public int getMultiplicadorAlcance() {
		// TODO Auto-generated method stub
		return multiplicadorAlcance;
	}

	@Override
	public int getMultiplicadorDistanciaAtaque() {
		// TODO Auto-generated method stub
		return multiplicadorDistanciaAtaque;
	}

	@Override
	public int getKiExtra() {
		// TODO Auto-generated method stub
		return kiExtra;
	}

}
