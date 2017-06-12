package dab.personajes.Gohan;
import java.util.Iterator;

import dab.ataquesEspeciales.Masenko;
import dab.estados.gohan.GohanBase;
import dab.estados.gohan.GohanSuperSayajinFase1;
import dab.estados.gohan.GohanSuperSayajinFase2;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class Gohan extends Personaje{
	
	public Gohan(){ 
		spec = new Masenko(this);
		kiParaEspecial = 10;
		estado = new GohanBase();
		estados.add(GohanBase.class);
		estados.add(GohanSuperSayajinFase1.class);
		estados.add(GohanSuperSayajinFase2.class);
		Iterator<Class<? extends Estado>> iter = estados.iterator();
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
				if((amigo.getVida() / amigo.getVidaMaxima()) > 0.25){		
					//si alguno no esta bajo de vida
					return false;						
				}
			}	
		}
		//si todos estan bajos de vida
		return true;

	}



}