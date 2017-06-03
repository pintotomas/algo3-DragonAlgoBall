package dab.personajes.goku;
import dab.personajes.Personaje;

public class GokuSuperSayajin extends Personaje{

	public GokuSuperSayajin(int kiAnterior, int vida) {
		super("Goku Super Sayajin", vida, 60, 4, 5, kiAnterior);
		
	}

	@Override
	public boolean transformacionDisponible() {
		return false;
	}

}
