package dab.ataquesEspeciales;

import dab.personajes.Personaje;

public class Absorber extends AtaqueEspecial{
	
	/*Representa un Absorber*/
	
	private double multiplicador = 1; //Si un pj lanza un Makankosappo, daña x1
	private int kiNecesario = 5;  //en realidad esto no sirve porque esta en el trabajo. 
	
	@Override
	public void lanzar(int poderPelea, Personaje enemigo){
		enemigo.agregarHp((int)(-multiplicador*poderPelea));
	}
	@Override
	public boolean disponible(int ki) {
		return ki >= kiNecesario;
	}

}
