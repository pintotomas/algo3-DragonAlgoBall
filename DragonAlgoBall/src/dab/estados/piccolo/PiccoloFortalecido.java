package dab.estados.piccolo;

import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;
import dab.interfaces.IProveedorDeVidaDePersonajes;

public class PiccoloFortalecido extends Estado {
	
	private IProveedorDeVidaDePersonajes proveedorDeVidaAliados;
	private double maximoPorcentajeDeVidaDeGohanNecesarioParaTransformar = 30;
	
	public PiccoloFortalecido(IProveedorDeKi proveedorDeKi, IProveedorDeVidaDePersonajes proveedorDeVida){
		super(proveedorDeKi);
		vidaMaxima = 500;
		poder = 40;
		alcance = 4;
		velocidad = 3;
		nombre = "Piccolo fortalecido";
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
		return (proveedorDeVidaAliados.obtenerPorcentajeDeVidaDelPersonaje("Gohan")  
				<= maximoPorcentajeDeVidaDeGohanNecesarioParaTransformar);}
}
