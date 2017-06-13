package dab.estados.freezer;

import dab.estados.Estado;

public class FreezerBase extends Estado{
	
/*Representa al personaje Freezer*/
	
	
	public FreezerBase(){
		vidaMaxima = 400;
		poder = 20;
		alcance = 2;
		velocidad = 4;
		nombre = "Freezer";
		kiParaTransformar = 20;
	}
	
	
	
}
