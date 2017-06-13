package dab.estados.freezer;

import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;

public class FreezerBase extends Estado{
	
/*Representa al personaje Freezer*/
	
	private int kiParaTransformar = 20;
	public FreezerBase(IProveedorDeKi proveedorDeKi){
		super(proovedorDeKi);
		vidaMaxima = 400;
		poder = 20;
		alcance = 2;
		velocidad = 4;
	}

	@Override
	public Estado transformar() {
		return new FreezerSegundaForma(proveedorDeKi);
	}

	
}
