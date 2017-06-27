package dab.estados.goku;
import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;

public class GokuBase extends Estado{	
	/*Representa al personaje Goku*/
	
	public static String nombreId = "Goku";
	
	public GokuBase(IProveedorDeKi proveedorDeKi){
		super(proveedorDeKi);
		vidaMaxima = 500;
		poder = 20;
		alcance = 2;
		velocidad = 2;
		nombre = nombreId;
		kiParaTransformar = 20;
	}
	
	@Override	
	public Estado transformar() {
		return new GokuKaioKen(proveedorDeKi);
	}


}