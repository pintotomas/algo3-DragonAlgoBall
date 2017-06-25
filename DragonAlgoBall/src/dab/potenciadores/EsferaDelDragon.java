package dab.potenciadores;

public class EsferaDelDragon extends Potenciador {

	public EsferaDelDragon(){
		
		nombre = "Esfera del Dragon";
		multiplicadorPoderDePelea = 1.25;
		multiplicadorVelocidad = 1;
		vidaExtra = 0;
		duracionTurnos = Double.POSITIVE_INFINITY;
		duracionAtaques = 2;
		multiplicadorAlcance = 1;
		multiplicadorDistanciaAtaque = 1;
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

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public boolean meAyudaAGanar() {
		// TODO Auto-generated method stub
		return true;
	}
	
}