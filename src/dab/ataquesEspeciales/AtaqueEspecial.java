package dab.ataquesEspeciales;
import dab.personajes.Personaje;

public abstract class AtaqueEspecial {
	
	public abstract void lanzar(int poderPelea, Personaje enemigo);
	public abstract boolean disponible(int ki);
}
