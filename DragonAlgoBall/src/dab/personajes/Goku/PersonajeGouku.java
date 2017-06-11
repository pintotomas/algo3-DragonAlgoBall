package dab.personajes.Goku;
import java.util.Iterator;

import dab.ataquesEspeciales.Kamehameha;
import dab.estados.goku.Goku;
import dab.estados.goku.GokuKaioKen;
import dab.estados.goku.GokuSuperSayajin;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class PersonajeGouku extends Personaje{
	

	public PersonajeGouku(){ 
		spec = new Kamehameha();
		kiParaEspecial = 20;
		estados.add(Goku.class);
		estados.add(GokuKaioKen.class);
		estados.add(GokuSuperSayajin.class);
		Iterator<Class<? extends Estado>> iter = estados.iterator();
		setIter(iter);		
	}
}
