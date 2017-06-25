package dab.estados.majinBoo;
import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;

public class MajinBooBase extends Estado{
	
	/*Representa al personaje MajinBoo*/
	public static String nombreId = "MajinBoo";	
	public MajinBooBase(IProveedorDeKi proveedorDeKi){
		super(proveedorDeKi);
		vidaMaxima = 300;
		poder = 30;
		alcance = 2;
		velocidad = 2;
		nombre = nombreId;
		kiParaTransformar = 20;
	}

	@Override
	public Estado transformar() {
		proveedorDeKi.modificarKi(-kiParaTransformar);
		return new MajinBooMalo(proveedorDeKi);
	}


}