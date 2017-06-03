package dab.ataquesEspeciales;

import dab.personajes.Personaje;

public class RayoMortal extends AtaqueEspecial{
/*Representa un rayo mortal*/
	
	private double multiplicador = 1.5; //Si un pj lanza un Rayo mortal, daña x1.5
	private int kiNecesario = 20;
	
	@Override
	public void lanzar(int poderPelea, Personaje enemigo){
		enemigo.agregarHp((int)(-multiplicador*poderPelea));
	}
	@Override
	public boolean disponible(int ki) {
		return ki >= kiNecesario;
	}

}
