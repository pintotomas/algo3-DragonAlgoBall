package dab.consumibles;

import dab.juego.Celda;

public abstract class Consumible{
	
	protected String nombre;
	protected Celda posicion;
	protected int duracion;
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
		// TODO Auto-generated method stub
		duracion -= 1;
		
	}

	public boolean estaActivo() {
		// TODO Auto-generated method stub
		return duracion > 0;
	}
}
