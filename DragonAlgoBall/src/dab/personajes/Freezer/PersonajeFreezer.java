package dab.personajes.Freezer;
import java.util.Iterator;

import dab.ataquesEspeciales.RayoMortal;
import dab.estados.freezer.Freezer;
import dab.estados.freezer.FreezerDefinitivo;
import dab.estados.freezer.FreezerSegundaForma;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class PersonajeFreezer extends Personaje{
	
	public PersonajeFreezer(){
		spec = new RayoMortal();
		kiParaEspecial = 20;
		estados.add(Freezer.class);
		estados.add(FreezerSegundaForma.class);
		estados.add(FreezerDefinitivo.class);
		Iterator<Class<? extends Estado>> iter = estados.iterator();
		setIter(iter);
		
	}

}