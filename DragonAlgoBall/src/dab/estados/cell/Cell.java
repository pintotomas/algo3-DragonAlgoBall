package dab.estados.cell;
import dab.personajes.Estado;

public class Cell extends Estado{
	
	/*Representa al personaje Cell*/
	
	public Cell(){ 
		vidaMaxima = 500;
		vida = vidaMaxima;
		poder = 20;
		alcance = 3;
		ki = 0;
		velocidad = 2;
		nombre = "Cell";
	}

}