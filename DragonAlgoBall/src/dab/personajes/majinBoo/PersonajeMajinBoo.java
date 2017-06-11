package dab.personajes.majinBoo;
import java.util.Iterator;

import dab.ataquesEspeciales.ConvierteteEnChocolate;
import dab.estados.majinBoo.BooMalo;
import dab.estados.majinBoo.BooOriginal;
import dab.estados.majinBoo.MajinBoo;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class PersonajeMajinBoo extends Personaje{
	
	public PersonajeMajinBoo(){ 
		spec = new ConvierteteEnChocolate(this);
		kiParaEspecial = 30;
		estados.add(MajinBoo.class);
		estados.add(BooMalo.class);
		estados.add(BooOriginal.class);
		Iterator<Class<? extends Estado>> iter = estados.iterator();
		setIter(iter);
		
	}
}