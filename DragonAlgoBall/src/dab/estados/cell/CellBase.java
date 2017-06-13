package dab.estados.cell;
import dab.estados.Estado;

public class CellBase extends Estado{
	
	/*Representa al personaje Cell*/
	
	public CellBase(){ 
		vidaMaxima = 500;
		poder = 20;
		alcance = 3;
		velocidad = 2;
		nombre = "Cell";
	}

}