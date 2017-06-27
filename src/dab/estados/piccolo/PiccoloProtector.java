package dab.estados.piccolo;

import dab.estados.Estado;

public class PiccoloProtector extends Estado {
	public static String nombreId = "Piccolo Protector";
	public PiccoloProtector(){
		vidaMaxima = 500;
		poder = 60;
		alcance = 6;
		velocidad = 4;
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
