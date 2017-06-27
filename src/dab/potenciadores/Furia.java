package dab.potenciadores;

import dab.personajes.Personaje;

public class Furia extends Potenciador {

	
	private static String nombre = "Furia";
	private static double multiplicadorPoderDePelea = 1.2;
	private static int multiplicadorVelocidad = 1;
	private static int vidaExtra = 0;
	private static double duracionTurnos = Double.POSITIVE_INFINITY;
	private static double duracionAtaques = Double.POSITIVE_INFINITY;
	private static int multiplicadorAlcance = 1;
	private static int multiplicadorDistanciaAtaque = 1;
	private static int kiExtra = 0;
	
	private Personaje portador;
	public static double porcentajeVidaNecesaria = 0.3;
	
	
	public Furia(Personaje portador){
		super(nombre, duracionTurnos, duracionAtaques, multiplicadorVelocidad, 
				multiplicadorPoderDePelea, vidaExtra, multiplicadorDistanciaAtaque, multiplicadorAlcance, kiExtra);
		
		this.portador = portador;
	}


	@Override
	public boolean daEfectos() {
		// TODO Auto-generated method stub
		return ((portador.getVida() / portador.getVidaMaxima()) <= porcentajeVidaNecesaria);
	}

	@Override
	public boolean meAyudaAGanar() {
		// TODO Auto-generated method stub
		return false;
	}
}
