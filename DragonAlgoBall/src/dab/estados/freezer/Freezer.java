package dab.estados.freezer;

import dab.personajes.Estado;

public class Freezer extends Estado{
	
/*Representa al personaje Freezer*/
	
	
	public Freezer(){
		vidaMaxima = 400;
		vida = vidaMaxima;
		poder = 20;
		alcance = 2;
		ki = 0;
		velocidad = 4;
		nombre = "Freezer";
		kiParaTransformar = 20;
	}
	
	
	
}
