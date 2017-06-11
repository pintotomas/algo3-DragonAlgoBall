package dab.personajes.Piccolo;
import java.util.Iterator;

import dab.ataquesEspeciales.Makankosappo;
import dab.estados.piccolo.Piccolo;
import dab.estados.piccolo.PiccoloFortalecido;
import dab.estados.piccolo.PiccoloProtector;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class PersonajePiccolo extends Personaje{
	
	public PersonajePiccolo(){ 
		spec = new Makankosappo (this);
		kiParaEspecial = 10;
		estados.add(Piccolo.class);
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