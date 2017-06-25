package dab.estados.gohan;

import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;
import dab.interfaces.IProveedorDeVidaDePersonajes;

public class GohanSuperSayajinFase1 extends Estado{
	/*segunda transformacion de gohan*/
	
		public static String nombreId = "Gohan Super Sayajin Fase 1";
	
		private IProveedorDeVidaDePersonajes proveedorVidaAliados;
		private double porcentajeVidaAliadosMinimoParaTransformar = 30;
		
		public GohanSuperSayajinFase1(IProveedorDeVidaDePersonajes proveedorVidaAliados, IProveedorDeKi proveedorDeKi){
			super(proveedorDeKi);
			vidaMaxima = 300;
			poder = 30;
			alcance = 2;
			velocidad = 2;
			nombre = nombreId;
			kiParaTransformar = 30;
			this.proveedorVidaAliados = proveedorVidaAliados;
		}

		@Override
		public Estado transformar() {
			proveedorDeKi.modificarKi(-kiParaTransformar);
			return new GohanSuperSayajinFase2();
		}

		@Override
		public boolean transformarDisponible() {
	
			double porcentajeVidaGoku = proveedorVidaAliados.obtenerPorcentajeDeVidaDelPersonaje("Goku");
			double porcentajeVidaPiccolo = proveedorVidaAliados.obtenerPorcentajeDeVidaDelPersonaje("Piccolo");
			
			return ((porcentajeVidaGoku < porcentajeVidaAliadosMinimoParaTransformar) &&
					(porcentajeVidaPiccolo < porcentajeVidaAliadosMinimoParaTransformar) &&
					(proveedorDeKi.getKi() >= kiParaTransformar));
		}
}
