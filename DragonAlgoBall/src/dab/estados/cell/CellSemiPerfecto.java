package dab.estados.cell;

import dab.estados.Estado;
import dab.interfaces.IProveedorDeCantidadAbsorbidos;

public class CellSemiPerfecto extends Estado {
	
	IProveedorDeCantidadAbsorbidos proveedorCantidadAbsorbidos;
	int cantidadAbsorbidosNecesariosParaTransformar = 8;
	public CellSemiPerfecto(IProveedorDeCantidadAbsorbidos proveedorCantidadAbsorbidos) {
		vidaMaxima = 500;
		poder = 40;
		alcance = 4;
		velocidad = 3;
		nombre = "Cell semi perfecto";;
		
	}
	@Override
	public Estado transformar() {
		return new CellPerfecto();
	}
	
	@Override
	public boolean transformarDisponible() {
		int cantidadAbsorbidos = proveedorCantidadAbsorbidos.getCantidadAbsorbidos();
		return cantidadAbsorbidos == cantidadAbsorbidosNecesariosParaTransformar;
	}


}
