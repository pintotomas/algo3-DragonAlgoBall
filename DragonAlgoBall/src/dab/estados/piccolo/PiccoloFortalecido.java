package dab.estados.piccolo;

import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;
import dab.interfaces.IProveedorDeVidaDePersonajes;
import dab.personajes.Gohan.Gohan;

public class PiccoloFortalecido extends Estado {
	
	private IProveedorDeVidaDePersonajes proveedorDeVidaAliados;
	private double maximoPorcentajeDeVidaDeGohanNecesarioParaTransformar = 30;
	public static String nombreId = "Piccolo Fortalecido";
	public PiccoloFortalecido(IProveedorDeKi proveedorDeKi, IProveedorDeVidaDePersonajes proveedorDeVida){
		super(proveedorDeKi);
		vidaMaxima = 500;
		poder = 40;
		alcance = 4;
		velocidad = 3;
		nombre = nombreId;
		kiParaTransformar = 0;
		this.proveedorDeVidaAliados = proveedorDeVida;
	}
	
	@Override
	public Estado transformar() {
		return new PiccoloProtector();
	}

	@Override
	public boolean transformarDisponible(){
		//gohan con menos de 20% de vida?	
		return (proveedorDeVidaAliados.obtenerPorcentajeDeVidaDelPersonaje(Gohan.identificador)  
				<= maximoPorcentajeDeVidaDeGohanNecesarioParaTransformar);}
}
