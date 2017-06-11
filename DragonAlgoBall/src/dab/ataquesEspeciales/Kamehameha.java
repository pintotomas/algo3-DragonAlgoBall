package dab.ataquesEspeciales;

import dab.personajes.Personaje;

public class Kamehameha extends AtaqueEspecial {
	
	/*Representa un Kamehameha*/
	
	public Kamehameha(Personaje lanzador){
		super(lanzador);
		multiplicador = 1.5; //Si un pj lanza un kamehameha, daña x1.5
	}
	
}
