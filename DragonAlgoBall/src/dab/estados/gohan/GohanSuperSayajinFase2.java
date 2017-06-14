package dab.estados.gohan;

import dab.estados.Estado;

public class GohanSuperSayajinFase2 extends Estado {
	/*tercera transformacion de gohan*/
	
	public GohanSuperSayajinFase2(){
		vidaMaxima = 300;
		poder = 100;
		alcance = 4;
		velocidad = 3;
		nombre = "Gohan super sayajin fase 2";
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
