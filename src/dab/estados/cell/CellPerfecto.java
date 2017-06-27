package dab.estados.cell;

import dab.estados.Estado;

public class CellPerfecto extends Estado {
	
	public static String nombreId = "Cell Perfecto";
	
	public CellPerfecto(){
		vidaMaxima = 500;
		poder = 80;
		alcance = 4;
		velocidad = 4;
		nombre = nombreId;
	}
	
	@Override
	public boolean transformarDisponible() {
		return false;
	}

	@Override
	public Estado transformar() {
		return this;
	}
}

