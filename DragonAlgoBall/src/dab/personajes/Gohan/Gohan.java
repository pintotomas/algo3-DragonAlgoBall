package dab.personajes.Gohan;
import java.util.Iterator;

import dab.ataquesEspeciales.Masenko;
import dab.estados.gohan.GohanBase;
import dab.estados.gohan.GohanSuperSayajinFase1;
import dab.estados.gohan.GohanSuperSayajinFase2;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class Gohan extends Personaje{
	
	public double porcentajeVidaAmigosParaTransformar = 0.3;
	/*PUBLICO PARA TESTING*/
	
	public Gohan(){ 
		
		spec = new Masenko(this);
		kiParaEspecial = 10;
		estado = new GohanBase();
		estados.add(new GohanBase());
		estados.add(new GohanSuperSayajinFase1());
		estados.add(new GohanSuperSayajinFase2());
		Iterator<Estado> iter = estados.iterator();
		setIter(iter);
		
	}
	
	
	@Override
	public boolean transformarDisponible() {
		if(super.transformarDisponible()){
			if(estado.getClass() == GohanSuperSayajinFase1.class){
				return this.segundaTransformacionDisponible();
			}
			return true;
		}
		//si no se cumple los requisitos generales para transformar.
		return false;
	}

	private boolean segundaTransformacionDisponible(){
		for(Personaje amigo : this.getEquipo().obtenerPersonajes()){
			if(amigo != this){
				if((amigo.getVida() / amigo.getVidaMaxima()) >= porcentajeVidaAmigosParaTransformar){		
					//si alguno no esta bajo de vida
					return false;						
				}
			}	
		}
		//si todos estan bajos de vida
		return true;

	}

}