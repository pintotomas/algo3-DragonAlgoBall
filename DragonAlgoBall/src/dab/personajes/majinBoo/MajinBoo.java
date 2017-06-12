package dab.personajes.majinBoo;
import java.util.Iterator;

import dab.ataquesEspeciales.ConvierteteEnChocolate;
import dab.estados.majinBoo.MajinBooMalo;
import dab.estados.majinBoo.MajinBooOriginal;
import dab.estados.majinBoo.MajinBooBase;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class MajinBoo extends Personaje{
	
	public MajinBoo(){ 
		spec = new ConvierteteEnChocolate(this);
		kiParaEspecial = 30;
		estado = new MajinBooBase();
		vida = estado.getVidaMaxima();
		estados.add(new MajinBooBase());
		estados.add(new MajinBooMalo());
		estados.add(new MajinBooOriginal());
		Iterator<Estado> iter = estados.iterator();
		setIter(iter);
		
	}
}