package dab.potenciadores;

public class EsferaDelDragon extends Potenciador {

	private static String nombre = "Esfera del Dragon";
	private static double multiplicadorPoderDePelea = 1.25;
	private static int multiplicadorVelocidad = 1;
	private static int vidaExtra = 0;
	private static double duracionTurnos = Double.POSITIVE_INFINITY;
	private static int duracionAtaques = 2;
	private static int multiplicadorAlcance = 1;
	private static int multiplicadorDistanciaAtaque = 1;
	private static int kiExtra = 0;
	
	public EsferaDelDragon(){
		super(nombre, duracionTurnos, duracionAtaques, multiplicadorVelocidad, 
				multiplicadorPoderDePelea, vidaExtra, multiplicadorDistanciaAtaque, multiplicadorAlcance, kiExtra);
	}
	
	
	@Override
	public boolean estaActivo(){
		return true;
	}

	@Override
	public boolean daEfectos() {
		// TODO Auto-generated method stub
		return super.estaActivo();
	}

	@Override
	public boolean meAyudaAGanar() {
		// TODO Auto-generated method stub
		return true;
	}
	
}