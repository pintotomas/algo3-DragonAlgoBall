package dab.estados.freezer;

import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;

public class FreezerSegundaForma extends Estado{
	//segunda transformacion de freezer
	
	private int kiParaTransformar = 50;
	private IProveedorDeKi proveedorDeKi;
	
	public FreezerSegundaForma(IProveedorDeKi proveedorDeKi){
		vidaMaxima = 400;
		poder = 40;
		alcance = 3;
		velocidad = 4;
		nombre = "Freezer Segunda Forma";
	}

	@Override
	public Estado transformar() {
		return new FreezerDefinitivo(proveedorDeKi);
	}

	@Override
	public boolean transformarDisponible() {
		// TODO Auto-generated method stub
		return false;
	}
}
