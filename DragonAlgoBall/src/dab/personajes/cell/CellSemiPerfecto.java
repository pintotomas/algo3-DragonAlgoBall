package dab.personajes.cell;


public class CellSemiPerfecto extends Cell {

	public CellSemiPerfecto() {
		vida = 500;
		poder = 40;
		alcance = 4;
		ki = 0;
		velocidad = 3;
		nombre = "Cell semi perfecto";
		kiParaEspecial = 5;
		absorbidosParaTransformar = 8;
		absorbidos = 0;
		
	}


	@Override
	public CellPerfecto transformar() {
		CellPerfecto cellPerfecto = new CellPerfecto();
		return cellPerfecto;
	}

}
