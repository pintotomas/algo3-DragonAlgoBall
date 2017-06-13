package dab.estados.goku;

import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;

public class GokuKaioKen extends Estado{
	/*Representa a la primer transformacion de Goku*/
	
	private IProveedorDeKi proveedorDeKi;
	private int kiParaTransformar;
	
	public GokuKaioKen(IProveedorDeKi proveedorDeKi){
		
		vidaMaxima = 500;
		poder = 40;
		alcance = 4;
		velocidad = 3;
		nombre = "Goku Kaio-Ken";
		this.proveedorDeKi = proveedorDeKi;
		
	}

	@Override
	public Estado transformar() {
		// TODO Auto-generated method stub
		return new GokuSuperSayajin();
	}

	@Override
	public boolean transformarDisponible() {
		// TODO Auto-generated method stub
		return proveedorDeKi.getKi() >= kiParaTransformar;
	}
}