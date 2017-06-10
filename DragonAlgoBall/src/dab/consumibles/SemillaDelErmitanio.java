package dab.consumibles;

public class SemillaDelErmitanio extends Consumible {
	protected int vida_recuperada;
	public SemillaDelErmitanio(){
		nombre = "Semilla del Ermitanio";
		vidaExtra = 100;
		multiplicadorVelocidad = 1;
		multiplicadorPoderDePelea = 1;
		duracion = 1;
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

}