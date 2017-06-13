package dab.estados.gohan;

import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;
import dab.interfaces.IProveedorDeVidaDePersonajes;


public class GohanBase extends Estado {
	
	/*Representa al personaje Gohan*/
	private IProveedorDeVidaDePersonajes proveedorVidaCompaneros;
	
	public GohanBase(IProveedorDeVidaDePersonajes proveedorVidaCompaneros, IProveedorDeKi proveedorDeKi){
		super(proveedorDeKi);
		vidaMaxima = 300;
		poder = 15;
		alcance = 2;
		velocidad = 2;
		nombre = "Gohan";
		kiParaTransformar = 10;
		this.proveedorVidaCompaneros = proveedorVidaCompaneros;
	}

	@Override
	public Estado transformar() {
		proveedorDeKi.modificarKi(-kiParaTransformar);
		return new GohanSuperSayajinFase1(proveedorVidaCompaneros, proveedorDeKi);
	}

	@Override
	public boolean transformarDisponible() {
		return proveedorDeKi.getKi() >= kiParaTransformar;
	}
	
	
}
