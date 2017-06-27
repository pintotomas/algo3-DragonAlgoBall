package dab.ataquesEspeciales;

import dab.personajes.Personaje;

public class RayoMortal extends AtaqueEspecial{
/*Representa un rayo mortal*/
	
	public static String nombre = "RayoMortal";
	
	public RayoMortal(Personaje lanzador){
		super(lanzador);
		multiplicador = 1.5; //Si un pj lanza un Rayo mortal, daña x1.5
	}
}
