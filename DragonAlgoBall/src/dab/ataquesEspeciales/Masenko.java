package dab.ataquesEspeciales;
import dab.personaje.Personaje;

public class Masenko extends AtaqueEspecial {
	
	private double multiplicador = 1.25; //Si un pj lanza un Masenko, daña x1.25
	
	@Override
	public void lanzar(int poderPelea, Personaje enemigo){
		enemigo.agregarHp((int)(-multiplicador*poderPelea));
	}

}
