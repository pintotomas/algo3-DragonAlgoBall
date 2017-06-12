package dab.estados.freezer;

import dab.personajes.Estado;

public class FreezerBase extends Estado{
	
/*Representa al personaje Freezer*/
	
	
	public FreezerBase(){
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
