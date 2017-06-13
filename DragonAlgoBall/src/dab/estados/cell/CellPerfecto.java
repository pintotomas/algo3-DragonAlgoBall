package dab.estados.cell;

import dab.estados.Estado;

public class CellPerfecto extends Estado {
	
	public CellPerfecto(){
		vidaMaxima = 500;
		poder = 80;
		alcance = 4;
		velocidad = 4;
		nombre = "Cell Perfecto";
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

