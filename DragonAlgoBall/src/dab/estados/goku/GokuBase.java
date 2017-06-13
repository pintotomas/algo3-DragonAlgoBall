package dab.estados.goku;
import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;

public class GokuBase extends Estado{	
	/*Representa al personaje Goku*/
	
	private int kiParaTransformar = 20;
	private IProveedorDeKi proveedorDeKi;
	
	public GokuBase(IProveedorDeKi proveedorDeKi){
		vidaMaxima = 500;
		poder = 20;
		alcance = 2;
		velocidad = 2;
		nombre = "Goku";
		this.proveedorDeKi = proveedorDeKi;
	}
	
	@Override	
	public Estado transformar() {
		// TODO Auto-generated method stub
		return new GokuKaioKen(proveedorDeKi);
	}

	@Override
	public boolean transformarDisponible() {
		// TODO Auto-generated method stub
		return proveedorDeKi.getKi() >= kiParaTransformar;
	}

}