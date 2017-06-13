package dab.estados.gohan;

import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;
import dab.interfaces.IProveedorDeVidaDePersonajes;


public class GohanBase extends Estado {
	
	/*Representa al personaje Gohan*/
	private int kiParaTransformar = 10;
	private IProveedorDeVidaDePersonajes proveedorVidaCompaneros;
	private IProveedorDeKi proveedorDeKi;
	
	public GohanBase(IProveedorDeVidaDePersonajes proveedorVidaCompaneros, IProveedorDeKi proveedorDeKi){
		vidaMaxima = 300;
		poder = 15;
		alcance = 2;
		velocidad = 2;
		nombre = "Gohan";
		kiParaTransformar = 10;
		this.proveedorVidaCompaneros = proveedorVidaCompaneros;
		this.proveedorDeKi = proveedorDeKi;
	}

	@Override
	public Estado transformar() {
		// TODO Auto-generated method stub
		return new GohanSuperSayajinFase1(proveedorVidaCompaneros, proveedorDeKi);
	}

	@Override
	public boolean transformarDisponible() {
		// TODO Auto-generated method stub
		return proveedorDeKi.getKi() >= kiParaTransformar;
	}
	
	
}
