package dab.potenciadores;

public class NubeVoladora extends Potenciador {
	
	private static String nombre = "Nube Voladora";
	private static double duracionTurnos = 3;
	private static double duracionAtaques = Double.POSITIVE_INFINITY;
	private static int multiplicadorVelocidad = 2;
	private static double multiplicadorPoderDePelea = 1;
	private static double vidaExtra = 0;
	private static int multiplicadorDistanciaAtaque = 1;
	private static int multiplicadorAlcance = 1;
	private static int kiExtra = 0;
	
	public NubeVoladora(){
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