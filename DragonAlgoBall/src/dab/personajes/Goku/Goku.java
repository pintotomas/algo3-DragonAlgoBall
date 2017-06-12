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
		estado = new GokuBase();
		estados.add(new GokuBase());
		estados.add(new GokuKaioKen());
		estados.add(new GokuSuperSayajin());
		Iterator<Estado> iter = estados.iterator();
		setIter(iter);
	}
}
