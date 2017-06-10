package dab.consumibles;

import dab.juego.Celda;

public abstract class Consumible{
	
	protected String nombre;
	protected Celda posicion;
	protected int duracion;
	protected int multiplicadorVelocidad;
	protected double multiplicadorPoderDePelea;
	protected double vidaExtra;
	
	public abstract double getMultiplicadorPoderDePelea();
	public abstract double getMultiplicadorVelocidad();
	public abstract double getVidaExtra();
	
	public void pasoUnTurno() {
		// TODO Auto-generated method stub
		duracion -= 1;
		
	}

	public boolean estaActivo() {
		// TODO Auto-generated method stub
		return duracion > 0;
	}
}
