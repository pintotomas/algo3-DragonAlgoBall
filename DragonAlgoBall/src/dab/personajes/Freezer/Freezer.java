package dab.personajes.Freezer;

import dab.ataquesEspeciales.RayoMortal;
import dab.equipo.Equipo;
import dab.estados.freezer.FreezerBase;
import dab.personajes.Personaje;

public class Freezer extends Personaje{
	
	public Freezer(){
		spec = new RayoMortal(this);
		kiParaEspecial = 20;
		estado = new FreezerBase(this);
		vida = estado.getVidaMaxima();
	}
	
	public Freezer(Equipo equipo){
		spec = new RayoMortal(this);
		kiParaEspecial = 20;
		estado = new FreezerBase(this);
		vida = estado.getVidaMaxima();
		this.equipo = equipo;
	}

}