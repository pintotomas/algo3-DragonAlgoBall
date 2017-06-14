package dab.potenciadores;

public class SemillaDelErmitanio extends Potenciador {
	
	public SemillaDelErmitanio(){
		nombre = "Semilla del Ermitanio";
		vidaExtra = 100;
		multiplicadorVelocidad = 1;
		multiplicadorPoderDePelea = 1;
		duracion = 0; //es aplicado en el momento que lo agrega Personaje
		multiplicadorDistanciaAtaque = 1;
		multiplicadorAlcance = 1;
		kiExtra = 0;
	}

	@Override
	public double getMultiplicadorVelocidad() {
		return multiplicadorVelocidad;
	}

	@Override
	public double getMultiplicadorPoderDePelea() {
		return multiplicadorPoderDePelea;
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