package dab.estados.cell;
import dab.estados.Estado;
import dab.interfaces.IProveedorDeCantidadAbsorbidos;

public class CellBase extends Estado{
	
	/*Representa al personaje Cell*/
	IProveedorDeCantidadAbsorbidos proveedorCantidadAbsorbidos;
	int cantidadAbsorbidosNecesariosParaTransformar = 4;
	
	public CellBase(IProveedorDeCantidadAbsorbidos proveedorCantidadAbsorbidos){ 
		vidaMaxima = 10;
		poder = 20;
		alcance = 3;
		velocidad = 2;
		nombre = "Cell";
		this.proveedorCantidadAbsorbidos = proveedorCantidadAbsorbidos;
	}
	@Override
	public Estado transformar() {
		return new CellSemiPerfecto(proveedorCantidadAbsorbidos);
	}
	
	@Override
	public boolean transformarDisponible() {
		int cantidadAbsorbidos = proveedorCantidadAbsorbidos.getCantidadAbsorbidos();
		return cantidadAbsorbidos == cantidadAbsorbidosNecesariosParaTransformar;
	}

}