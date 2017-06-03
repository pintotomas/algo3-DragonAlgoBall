package dab.ataquesEspeciales;
import dab.personajes.Personaje;

public class Kamehameha extends AtaqueEspecial {
	
	/*Representa un Kamehameha*/
	
	private int multiplicador = 2; //Si un pj lanza un kamehameha, daña x2
	private int kiNecesario = 20;
	
	@Override
	public void lanzar(int poderPelea, Personaje enemigo){
		enemigo.agregarHp(-multiplicador*poderPelea);
	}
	@Override
	public boolean disponible(int ki) {
		// TODO Auto-generated method stub
		return ki >= kiNecesario;
	}
	
	
}
