package dab.ataquesEspeciales;

import dab.personajes.Personaje;

public class Masenko extends AtaqueEspecial {
	
	public static String nombre = "Masenko";
	
	public Masenko(Personaje lanzador){
		super(lanzador);
		multiplicador = 1.25; //Si un pj lanza un Masenko, daña x1.25
	}

}
