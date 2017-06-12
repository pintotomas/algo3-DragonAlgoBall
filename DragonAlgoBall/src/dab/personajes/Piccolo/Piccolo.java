package dab.personajes.Piccolo;
import java.util.Iterator;

import dab.ataquesEspeciales.Makankosappo;
import dab.estados.piccolo.PiccoloBase;
import dab.estados.piccolo.PiccoloFortalecido;
import dab.estados.piccolo.PiccoloProtector;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class Piccolo extends Personaje{
	
	public Piccolo(){ 
		spec = new Makankosappo (this);
		kiParaEspecial = 10;
		estado = new PiccoloBase();
		estados.add(PiccoloBase.class);
		estados.add(PiccoloFortalecido.class);
		estados.add(PiccoloProtector.class);
		Iterator<Class<? extends Estado>> iter = estados.iterator();
		setIter(iter);
	}


	public boolean transformarDisponible() {
		if(super.transformarDisponible()){
			if(estado.getClass() == PiccoloFortalecido.class){
				Personaje gohan = equipo.obtenerPersonaje("Gohan");
				if(gohan.getVida() / gohan.getVidaMaxima() > 0.25){
					return false;
				}
			}
			return true;
		}
		return false;  //revisar la logica, son las 3 am
	}

}