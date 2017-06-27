package dab.estados.gohan;

import dab.estados.Estado;

public class GohanSuperSayajinFase2 extends Estado {
	/*tercera transformacion de gohan*/
	
	public static String nombreId = "Gohan Super Sayajin Fase 2";;
	
	public GohanSuperSayajinFase2(){
		vidaMaxima = 300;
		poder = 100;
		alcance = 4;
		velocidad = 3;
		nombre = nombreId;
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
