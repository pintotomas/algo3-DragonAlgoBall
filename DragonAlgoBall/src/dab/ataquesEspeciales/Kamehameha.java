package dab.ataquesEspeciales;
import dab.personajes.Personaje;

public class Kamehameha extends AtaqueEspecial {
	
	/*Representa un Kamehameha*/
	
	private double multiplicador = 1.5; //Si un pj lanza un kamehameha, daña x1.5

	@Override
	public void lanzar(int poderPelea, Personaje enemigo){
		enemigo.agregarHp((int)(-multiplicador*poderPelea));
	}
}
