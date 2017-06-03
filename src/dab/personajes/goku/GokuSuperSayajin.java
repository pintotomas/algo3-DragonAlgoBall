package dab.personajes.goku;

public class GokuSuperSayajin extends KaioKen{

	
	static int vida = 500;
	static int poder = 60;
	static int alcance = 4;
	static int kiInicial = 0;
	static int velocidad = 5;
	static String nombre = "Goku Super Sayajin";
	
	public GokuSuperSayajin() {
		super();
	}
	
	@Override
	public boolean transformacionDisponible() {
		return false;
	}	
	

}
