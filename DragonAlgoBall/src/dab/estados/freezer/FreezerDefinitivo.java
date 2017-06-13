package dab.estados.freezer;

import dab.estados.Estado;

public class FreezerDefinitivo extends Estado {
	//ultima transformacion de freezer
	
	public FreezerDefinitivo(){
		vidaMaxima = 400;
		poder = 50;
		alcance = 3;
		velocidad = 6;
		nombre = "Freezer Definitivo";
		kiParaTransformar = 50;
	}
		
}
