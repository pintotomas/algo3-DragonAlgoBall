package dab.consumibles;

public class NubeVoladora extends Consumible {
	
	public NubeVoladora(){
		nombre = "Nube Voladora";
		duracion = 3;
		multiplicadorVelocidad = 2;
		multiplicadorPoderDePelea = 1;
		vidaExtra = 0;
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