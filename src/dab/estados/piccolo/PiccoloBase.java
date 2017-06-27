package dab.estados.piccolo;
import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;
import dab.interfaces.IProveedorDeVidaDePersonajes;

public class PiccoloBase extends Estado {
		
	public static String nombreId = "Piccolo";
	/*Representa al personaje Piccolo*/
 	private IProveedorDeVidaDePersonajes proveedorDeVidaAliados;
	public PiccoloBase(IProveedorDeKi proveedorDeKi, IProveedorDeVidaDePersonajes proveedorDeVidaAliados){
		super(proveedorDeKi);
		vidaMaxima = 500;
		poder = 20;
		alcance = 2;
		velocidad = 2;
		nombre = nombreId;
		kiParaTransformar = 20;
		this.proveedorDeVidaAliados = proveedorDeVidaAliados;
	}
	
	@Override
	public Estado transformar() {
		proveedorDeKi.modificarKi(-kiParaTransformar);
		return new PiccoloFortalecido(proveedorDeKi, proveedorDeVidaAliados);
	}
	
	public void setProveedorVidaCompaneros(IProveedorDeVidaDePersonajes proveedorDeVidaAliados){
		this.proveedorDeVidaAliados = proveedorDeVidaAliados;
	}
}
