package dab.ataquesEspeciales;
import dab.personajes.Personaje;

public class AtaqueEspecial {
	
	protected double multiplicador = 1; 
	protected Personaje lanzador; //crear una interfaz que solo me permita acceder a .getPoder() del personaje?
	public static String nombre;
	
	public AtaqueEspecial(Personaje lanzador){
		this.lanzador = lanzador;
	}
	public  void lanzar(Personaje enemigo){ //interfaz atacable
		enemigo.modificarVida(-multiplicador*lanzador.getPoder());
	}
}
