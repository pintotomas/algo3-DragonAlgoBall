package dab.estados.goku;

import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;

public class GokuKaioKen extends Estado{
	/*Representa a la primer transformacion de Goku*/
	
	public static String nombreId = "Goku Kaio-Ken";
	
	public GokuKaioKen(IProveedorDeKi proveedorDeKi){
		super(proveedorDeKi);
		vidaMaxima = 500;
		poder = 40;
		alcance = 4;
		velocidad = 3;
		nombre = nombreId;
		kiParaTransformar = 50;
	}

	@Override
	public Estado transformar() {
		proveedorDeKi.modificarKi(-kiParaTransformar);
		return new GokuSuperSayajin();
	}

}