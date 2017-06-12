package dab.personajes.majinBoo;
import java.util.Iterator;

import dab.ataquesEspeciales.ConvierteteEnChocolate;
import dab.estados.majinBoo.BooMalo;
import dab.estados.majinBoo.BooOriginal;
import dab.estados.majinBoo.MajinBooBase;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class MajinBoo extends Personaje{
	
	public MajinBoo(){ 
		spec = new ConvierteteEnChocolate(this);
		kiParaEspecial = 30;
		estado = new MajinBooBase();
		estados.add(new MajinBooBase());
		estados.add(new BooMalo());
		estados.add(new BooOriginal());
		Iterator<Estado> iter = estados.iterator();
		setIter(iter);
		
	}
}