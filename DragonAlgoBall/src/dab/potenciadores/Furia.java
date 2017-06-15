package dab.potenciadores;

import dab.personajes.Personaje;

public class Furia extends Potenciador {

	private Personaje portador;
	private double vidaNecesaria = 0.3;
	private int multiplicadorDefecto = 1;
	
	public Furia(Personaje portador){
		
		nombre = "Furia";
		multiplicadorPoderDePelea = 1.2;
		multiplicadorVelocidad = 1;
		vidaExtra = 0;
		duracionTurnos = (int) Double.POSITIVE_INFINITY;
		duracionAtaques = duracionTurnos;
		multiplicadorAlcance = 1;
		multiplicadorDistanciaAtaque = 1;
		kiExtra = 0;
		this.portador = portador;
	}

	private boolean vidaSuficienteParaAplicarEfectos(){
		return ((portador.getVida() / portador.getVidaMaxima()) <= vidaNecesaria);
	}
	
	@Override
	public double getMultiplicadorPoderDePelea() {
		
		if (this.vidaSuficienteParaAplicarEfectos()){
			return multiplicadorPoderDePelea;
		}
		return multiplicadorDefecto;
	}

	@Override
	public double getMultiplicadorVelocidad() {
		// TODO Auto-generated method stub
		if (this.vidaSuficienteParaAplicarEfectos()){
			return multiplicadorVelocidad;
		}
		return multiplicadorDefecto;
	}

	@Override
	public double getVidaExtra() {
		return vidaExtra;
	}

	@Override
	public int getMultiplicadorAlcance() {
		// TODO Auto-generated method stub
		if (this.vidaSuficienteParaAplicarEfectos()){
			return multiplicadorAlcance;
		}
		return multiplicadorDefecto;
	}

	@Override
	public int getMultiplicadorDistanciaAtaque() {
		// TODO Auto-generated method stub
		if (this.vidaSuficienteParaAplicarEfectos()){
			return multiplicadorDistanciaAtaque;
		}
		return multiplicadorDefecto;
	}

	@Override
	public int getKiExtra() {
		// TODO Auto-generated method stub
		return kiExtra;
	}
	
	@Override
	public boolean estaActivo() {
		return duracionTurnos > 0;
	}
}
