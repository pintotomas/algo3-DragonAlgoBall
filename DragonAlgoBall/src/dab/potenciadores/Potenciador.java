package dab.potenciadores;

import dab.juego.Celda;

public abstract class Potenciador{
	
	protected String nombre;
	protected Celda posicion;
	protected double duracion;
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
		duracion -= 1;
	}

	public boolean estaActivo() {
		return duracion > 0;
	}
}
