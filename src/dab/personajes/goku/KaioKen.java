package dab.personajes.goku;

import dab.personajes.Personaje;

public class KaioKen extends Goku{

	//No estoy seguro de si esto reemplaza las especificaciones de Goku
	static int vida = 500;
	static int poder = 40;
	static int alcance = 4;
	static int kiInicial = 0;
	static int velocidad = 3;
	static String nombre = "Goku Kaio-Ken";
	
	public KaioKen(){
		
		//para que al transformar guarda la vida y el ki anterior
		super();
		
	}
	
	public Personaje transformar() {
		GokuSuperSayajin gokuSSJ = new GokuSuperSayajin();
		return gokuSSJ;
	}	
	
}