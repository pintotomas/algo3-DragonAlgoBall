package dab.estados.goku;

import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;

public class GokuKaioKen extends Estado{
	/*Representa a la primer transformacion de Goku*/
	
	
	public GokuKaioKen(IProveedorDeKi proveedorDeKi){
		super(proveedorDeKi);
		vidaMaxima = 500;
		poder = 40;
		alcance = 4;
		velocidad = 3;
		nombre = "Goku Kaio-Ken";
		kiParaTransformar = 50;
	}

	@Override
	public Estado transformar() {
		proveedorDeKi.modificarKi(-kiParaTransformar);
		return new GokuSuperSayajin();
	}

}