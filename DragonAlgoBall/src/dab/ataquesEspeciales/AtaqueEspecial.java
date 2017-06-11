package dab.ataquesEspeciales;
import dab.personajes.Personaje;

public class AtaqueEspecial {
	
	protected double multiplicador = 1; 
	protected Personaje lanzador; //crear una interfaz que solo me permita acceder a .getPoder() del personaje?
	
	public AtaqueEspecial(Personaje lanzador){
		this.lanzador = lanzador;
	}
	public  void lanzar(Personaje enemigo){ //interfaz atacable
		enemigo.agregarHp(-multiplicador*lanzador.getPoder());
	}
}
