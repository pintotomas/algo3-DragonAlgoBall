package dab.estados.goku;

import dab.estados.Estado;

public class GokuSuperSayajin extends Estado{
	/*Representa a la segunda transformacion de Goku*/
	
	
	public GokuSuperSayajin(){
		
		vidaMaxima = 500;
		poder = 60;
		alcance = 4;
		velocidad = 5;
		nombre = "Goku Super Sayajin";
		kiParaTransformar = 0;
	}

	@Override
	public Estado transformar() {
		// TODO Auto-generated method stub
		return null; // crear excepcion
	}

	@Override
	public boolean transformarDisponible() {
		// TODO Auto-generated method stub
		return false;
	}

}
