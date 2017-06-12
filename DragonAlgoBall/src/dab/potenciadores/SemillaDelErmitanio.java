package dab.potenciadores;

public class SemillaDelErmitanio extends Potenciador {
	
	public SemillaDelErmitanio(){
		nombre = "Semilla del Ermitanio";
		vidaExtra = 100;
		multiplicadorVelocidad = 1;
		multiplicadorPoderDePelea = 1;
		duracion = 1;
		multiplicadorDistanciaAtaque = 1;
		multiplicadorAlcance = 1;
		kiExtra = 0;
	}

	@Override
	public double getMultiplicadorVelocidad() {
		// TODO Auto-generated method stub
		return multiplicadorVelocidad;
	}

	@Override
	public double getMultiplicadorPoderDePelea() {
		// TODO Auto-generated method stub
		return multiplicadorPoderDePelea;
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