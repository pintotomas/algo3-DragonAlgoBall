package dab.tablero;
import dab.dragonBallExceptions.*;
import dab.personajes.Personaje;

public class Celda {
	boolean ocupada;
	Personaje ocupante;
	boolean esferaDelDragon, semillaDelHermitanio, nubeVoladora;

	public Celda(){
		ocupada = false;
		esferaDelDragon = false;
		semillaDelHermitanio = false;
		nubeVoladora = false;
	}
	
	
	
	
	public boolean estaOcupada(){
		return ocupada;
	}
	
	public Personaje darOcupante(){
		if(!ocupada) throw new CeldaVacia();
		return ocupante;
	}
	
	public void colocarPersonaje(Personaje personaje){
		if(ocupada) throw new CeldaOcupada();
		ocupante = personaje;
	}
	
	
	public void quitarPersonaje(){
		ocupante = null;		
	}
	
	
	public void setesferaDelDragon(boolean estado){
		esferaDelDragon = estado;
	}
	
	public void setNubeVoladora(boolean estado){
		nubeVoladora = estado;		
	}
	
	public void setSemilla(boolean estado){
		semillaDelHermitanio = estado;
	}
	
	
	
	
	
}
