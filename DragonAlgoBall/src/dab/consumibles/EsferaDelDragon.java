package dab.consumibles;

public class EsferaDelDragon extends Consumible {

	public EsferaDelDragon(){
		
		nombre = "Esfera del Dragon";
		multiplicadorPoderDePelea = 1.25;
		multiplicadorVelocidad = 1;
		vidaExtra = 0;
		duracion = 3; //1 mas para que pueda usarlo 2 turnos
		multiplicadorAlcance = 1;
		multiplicadorDistanciaAtaque = 1;
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