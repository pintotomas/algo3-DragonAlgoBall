package dab.personajes.Freezer;
import java.util.Iterator;

import dab.ataquesEspeciales.RayoMortal;
import dab.estados.freezer.FreezerBase;
import dab.estados.freezer.FreezerDefinitivo;
import dab.estados.freezer.FreezerSegundaForma;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class Freezer extends Personaje{
	
	public Freezer(){
		spec = new RayoMortal(this);
		kiParaEspecial = 20;
		estado = new FreezerBase();
		vida = estado.getVidaMaxima();
		estados.add(new FreezerBase());
		estados.add(new FreezerSegundaForma());
		estados.add(new FreezerDefinitivo());
		Iterator<Estado> iter = estados.iterator();
		setIter(iter);
		
	}

}