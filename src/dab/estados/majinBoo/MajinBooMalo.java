package dab.estados.majinBoo;

import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;

public class MajinBooMalo extends Estado {
	public static String nombreId = "Boo Malo";
			
	public MajinBooMalo(IProveedorDeKi proveedorDeKi){
		super(proveedorDeKi);
		vidaMaxima = 300;
		poder = 50;
		alcance = 2;
		velocidad = 3;
		nombre = nombreId;
		kiParaTransformar = 50;
	}

	@Override
	public Estado transformar() {
		proveedorDeKi.modificarKi(-kiParaTransformar);
		return new MajinBooOriginal();
	}
	
}
