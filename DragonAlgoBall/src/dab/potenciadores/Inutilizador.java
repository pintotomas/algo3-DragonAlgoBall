package dab.potenciadores;

public class Inutilizador extends Potenciador {
	
	private static String nombre = "Inutilizador";
	private static double duracionTurnos = 3;
	private static double duracionAtaques = Double.POSITIVE_INFINITY;
	private static int multiplicadorVelocidad = 0;
	private static double multiplicadorPoderDePelea = 1;
	private static double vidaExtra = 0;
	private static int multiplicadorDistanciaAtaque = 0;
	private static int multiplicadorAlcance = 0;
	private static int kiExtra = -5;
	
	public Inutilizador(){
		super(nombre, duracionTurnos, duracionAtaques, multiplicadorVelocidad, 
				multiplicadorPoderDePelea, vidaExtra, multiplicadorDistanciaAtaque, multiplicadorAlcance, kiExtra);
	
	}

	@Override
	public boolean daEfectos() {
		// TODO Auto-generated method stub
		return true;
	}

}
