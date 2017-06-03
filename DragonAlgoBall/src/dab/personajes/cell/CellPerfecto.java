package dab.personajes.cell;

import dab.personajes.Personaje;

public class CellPerfecto extends CellSemiPerfecto {
	public CellPerfecto(){
		vida = 500;
		poder = 80;
		alcance = 4;
		ki = 0;
		velocidad = 4;
		nombre = "Cell Perfecto";
		kiParaEspecial = 5;
		absorbidosParaTransformar = 0;
		absorbidos = 0;
	}
	@Override
	public boolean transformarDisponible() {
		return false;
	}
}

