package dab.ataquesEspeciales;

import dab.personajes.Personaje;

public class Makankosappo extends AtaqueEspecial {
	
	/*Representa un Makankosappo*/
	
	private double multiplicador = 1.5; //Si un pj lanza un Makankosappo, daña x1.25

	@Override
	public void lanzar(int poderPelea, Personaje enemigo){
		enemigo.agregarHp((int)(-multiplicador*poderPelea));
	}
}
