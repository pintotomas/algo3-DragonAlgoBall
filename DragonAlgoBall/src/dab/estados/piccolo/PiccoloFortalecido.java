package dab.estados.piccolo;

import dab.estados.Estado;

public class PiccoloFortalecido extends Estado {
	public PiccoloFortalecido(){
		vidaMaxima = 500;
		poder = 40;
		alcance = 4;
		velocidad = 3;
		nombre = "Piccolo fortalecido";
		kiParaTransformar = 0;
	}
}
