package dab.estados.freezer;

import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;

public class FreezerSegundaForma extends Estado{
	//segunda transformacion de freezer
	public static String nombreId = "Freezer Segunda Forma";
	
	public FreezerSegundaForma(IProveedorDeKi proveedorDeKi){
		super(proveedorDeKi);
		vidaMaxima = 400;
		poder = 40;
		alcance = 3;
		velocidad = 4;
		nombre = nombreId;
		kiParaTransformar = 50;
	}

	@Override
	public Estado transformar() {
		proveedorDeKi.modificarKi(-kiParaTransformar);
		return new FreezerDefinitivo();
	}

}
