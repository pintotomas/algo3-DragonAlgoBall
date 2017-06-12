package dab.estados.goku;
import dab.personajes.Estado;

public class GokuBase extends Estado{	
	/*Representa al personaje Goku*/
	
	public GokuBase(){
		
		vidaMaxima = 500;
		poder = 20;
		alcance = 2;
		velocidad = 2;
		nombre = "Goku";
		kiParaTransformar = 20;
	}

}