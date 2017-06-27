package dab.estados.goku;

import dab.estados.Estado;

public class GokuSuperSayajin extends Estado{
	/*Representa a la segunda transformacion de Goku*/
	
	public static String nombreId = "Goku Super Sayajin";
	public GokuSuperSayajin(){
		vidaMaxima = 500;
		poder = 60;
		alcance = 4;
		velocidad = 5;
		nombre = nombreId;
		kiParaTransformar = 0;
	}

	@Override
	public Estado transformar() {
		return this;
	}

	@Override
	public boolean transformarDisponible() {
		return false;
	}

}
