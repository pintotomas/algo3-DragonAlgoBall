package dab.estados.gohan;

import java.util.Collection;

import dab.estados.Estado;
import dab.interfaces.IProveedorDeKi;
import dab.interfaces.IProveedorDeVidaDePersonajes;
import dab.personajes.Personaje;



public class GohanSuperSayajinFase1 extends Estado{
	/*segunda transformacion de gohan*/
	
		private int kiParaTransformar = 30;
		private IProveedorDeVidaDePersonajes proveedorVidaCompaneros;
		private IProveedorDeKi proveedorDeKi;
		private double porcentajeVidaCompanerosNecesarioParaTransformar = 30;
		
		public GohanSuperSayajinFase1(IProveedorDeVidaDePersonajes proveedorVidaCompaneros,
				IProveedorDeKi proveedorDeKi) {
			vidaMaxima = 300;
			poder = 30;
			alcance = 2;
			velocidad = 2;
			nombre = "Gohan Super Sayajin Fase 1";
			kiParaTransformar = 30;
			this.proveedorVidaCompaneros = proveedorVidaCompaneros;
			this.proveedorDeKi = proveedorDeKi;
			// TODO Auto-generated constructor stub
		}

		@Override
		public Estado transformar() {
			// TODO Auto-generated method stub
			return new GohanSuperSayajinFase2();
		}

		@Override
		public boolean transformarDisponible() {
			// TODO Auto-generated method stub
			if (proveedorDeKi.getKi() < kiParaTransformar){
				return false;
			}
			Collection<Personaje> coleccionPjs = proveedorVidaCompaneros.obtenerPersonajes();
			//Estaria bueno recibir directamente un arreglo con el porcentaje de vida de c/companero
			for(Personaje p: coleccionPjs){
				if (p.getVidaMaxima()/p.getVida() >= porcentajeVidaCompanerosNecesarioParaTransformar){
					return false;
				}
			}
			return true;
		}
}
