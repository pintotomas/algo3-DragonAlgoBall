package dab.ataquesEspeciales;
import dab.personajes.Personaje;

public class Masenko extends AtaqueEspecial {
	
	private double multiplicador = 1.25; //Si un pj lanza un Masenko, daña x1.25
	private int kiNecesario = 10;
	
	
	@Override
	public void lanzar(int poderPelea, Personaje enemigo){
		enemigo.agregarHp((int)(-multiplicador*poderPelea));
	}

	@Override
	public boolean disponible(int ki) {
		return ki >= kiNecesario;
	}
	
	

}
