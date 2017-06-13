package dab.estados.piccolo;
import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;
import dab.interfaces.IProveedorDeVidaDePersonajes;

public class PiccoloBase extends Estado {
		
	/*Representa al personaje Piccolo*/
 	private IProveedorDeVidaDePersonajes proveedorDeVidaAliados;
	public PiccoloBase(IProveedorDeKi proveedorDeKi, IProveedorDeVidaDePersonajes proveedorDeVidaAliados){
		super(proveedorDeKi);
		vidaMaxima = 500;
		poder = 20;
		alcance = 2;
		velocidad = 2;
		nombre = "Piccolo";
		kiParaTransformar = 20;
		this.proveedorDeVidaAliados = proveedorDeVidaAliados;
	}
	
	@Override
	public Estado transformar() {
		proveedorDeKi.modificarKi(-kiParaTransformar);
		return new PiccoloFortalecido(proveedorDeKi, proveedorDeVidaAliados);
	}
}
