package dab.personajes.Goku;
import java.util.Iterator;

import dab.ataquesEspeciales.Kamehameha;
import dab.estados.goku.GokuBase;
import dab.estados.goku.GokuKaioKen;
import dab.estados.goku.GokuSuperSayajin;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class Goku extends Personaje{
	

	public Goku(){ 
		spec = new Kamehameha(this);
		kiParaEspecial = 20;
		estados.add(GokuBase.class);
		estados.add(GokuKaioKen.class);
		estados.add(GokuSuperSayajin.class);
		Iterator<Class<? extends Estado>> iter = estados.iterator();
		setIter(iter);		
	}
}
