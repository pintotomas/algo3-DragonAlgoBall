package dab.personajes.Freezer;

import dab.ataquesEspeciales.RayoMortal;
import dab.estados.freezer.FreezerBase;
import dab.personajes.Personaje;

public class Freezer extends Personaje{
	
	public Freezer(){
		spec = new RayoMortal(this);
		kiParaEspecial = 20;
		estado = new FreezerBase(this);
		vida = estado.getVidaMaxima();
	}

}