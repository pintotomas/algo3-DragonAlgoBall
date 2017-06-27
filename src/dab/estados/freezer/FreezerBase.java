package dab.estados.freezer;

import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;

public class FreezerBase extends Estado{
	
/*Representa al personaje Freezer*/
	public static String nombreId = "Freezer";
	public FreezerBase(IProveedorDeKi proveedorDeKi){
		super(proveedorDeKi);
		nombre = nombreId ;
		vidaMaxima = 400;
		poder = 20;
		alcance = 2;
		velocidad = 4;
		kiParaTransformar = 20;
	}

	@Override
	public Estado transformar() {
		proveedorDeKi.modificarKi(-kiParaTransformar);
		return new FreezerSegundaForma(proveedorDeKi);
	}

	
}
