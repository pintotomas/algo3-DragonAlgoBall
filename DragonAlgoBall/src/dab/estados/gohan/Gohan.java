package dab.estados.gohan;

import dab.personajes.Estado;

public class Gohan extends Estado {
	
	/*Representa al personaje Gohan*/
		
	public Gohan(){
		vidaMaxima = 300;
		vida = vidaMaxima;
		poder = 15;
		alcance = 2;
		ki = 0;
		velocidad = 2;
		nombre = "Gohan";
		kiParaTransformar = 10;
	}
	
	
}
