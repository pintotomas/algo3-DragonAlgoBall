package dab.estados.piccolo;

import dab.estados.Estado;

public class PiccoloProtector extends Estado {
	
	public PiccoloProtector(){
		vidaMaxima = 500;
		poder = 60;
		alcance = 6;
		velocidad = 4;
		nombre = "Piccolo Protector";
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
