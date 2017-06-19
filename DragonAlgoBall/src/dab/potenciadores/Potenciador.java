package dab.potenciadores;

public abstract class Potenciador {
	
	protected String nombre;
	protected double duracionTurnos;
	protected double duracionAtaques;
	protected int multiplicadorVelocidad;
	protected double multiplicadorPoderDePelea;
	protected double vidaExtra;
	protected int multiplicadorDistanciaAtaque;
	protected int multiplicadorAlcance;
	protected int kiExtra;
	
	public abstract double getMultiplicadorPoderDePelea();
	public abstract double getMultiplicadorVelocidad();
	public abstract double getVidaExtra();
	public abstract int getMultiplicadorAlcance();
	public abstract int getMultiplicadorDistanciaAtaque();
	public abstract int getKiExtra();
	
	public void pasoUnTurno() {
		duracionTurnos -= 1;
	}
	
	public void pasoUnAtaque(){
		duracionAtaques -= 1;
	}
	
	public boolean estaActivo(){
		return (duracionTurnos > 0 && duracionAtaques > 0);
	}
	
	public double getDuracionTurnos(){
		//usar solo en testing
		return duracionTurnos;
	}
	
	
}
