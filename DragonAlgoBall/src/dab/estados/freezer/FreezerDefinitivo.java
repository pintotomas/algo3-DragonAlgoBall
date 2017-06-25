package dab.estados.freezer;

import dab.estados.Estado;

public class FreezerDefinitivo extends Estado {
	//ultima transformacion de freezer
	public static String nombreId = "Freezer Definitivo";
	
	public FreezerDefinitivo(){
		vidaMaxima = 400;
		poder = 50;
		alcance = 3;
		velocidad = 6;
		nombre = nombreId;
		kiParaTransformar = 50;
	}
	
	@Override
	public boolean transformarDisponible() {
		return false;
	}

	@Override
	public Estado transformar() {
		return this;
	}
}
