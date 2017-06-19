package dab.ataquesEspeciales;

import dab.personajes.Personaje;

public class Makankosappo extends AtaqueEspecial {
	
	/*Representa un Makankosappo*/
	
	public Makankosappo(Personaje lanzador){
		super(lanzador);
		multiplicador = 1.25; //Si un pj lanza un Makankosappo, daña x1.25
	}
	
}
