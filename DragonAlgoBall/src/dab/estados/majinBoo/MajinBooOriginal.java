package dab.estados.majinBoo;

import dab.estados.Estado;

public class MajinBooOriginal extends Estado {
	public MajinBooOriginal(){
		vidaMaxima = 300;
		poder = 60;
		alcance = 3;
		velocidad = 4;
		nombre = "Boo Original";
		kiParaEspecial = 30;
	}

	@Override
	public Estado transformar() {
		return this;
	}

	@Override
	public boolean transformarDisponible(){
		return false;
	}

}
