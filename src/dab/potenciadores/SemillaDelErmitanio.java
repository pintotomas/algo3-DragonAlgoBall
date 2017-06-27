package dab.potenciadores;

public class SemillaDelErmitanio extends Potenciador {
	
	private static String nombre = "Semilla del Ermitanio";
	private static int vidaExtra = 100;
	private static int multiplicadorVelocidad = 1;
	private static double multiplicadorPoderDePelea = 1;
	private static double duracionTurnos = 0;
	private static double duracionAtaques = 0;
	private static int multiplicadorDistanciaAtaque = 1;
	private static int multiplicadorAlcance = 1;
	private static int kiExtra = 0;
	
	public SemillaDelErmitanio(){
		super(nombre, duracionTurnos, duracionAtaques, multiplicadorVelocidad, 
				multiplicadorPoderDePelea, vidaExtra, multiplicadorDistanciaAtaque, multiplicadorAlcance, kiExtra);

	}

	@Override
	public boolean daEfectos() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean meAyudaAGanar() {
		// TODO Auto-generated method stub
		return false;
	}
}