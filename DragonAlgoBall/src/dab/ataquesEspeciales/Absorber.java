package dab.ataquesEspeciales;

import dab.personajes.Personaje;

public class Absorber extends AtaqueEspecial{
	
	/*Representa un Absorber*/
	
	private double multiplicador = 1; 

	@Override
	public void lanzar(int poderPelea, Personaje enemigo){
		enemigo.agregarHp((int)(-multiplicador*poderPelea));
	}

}
