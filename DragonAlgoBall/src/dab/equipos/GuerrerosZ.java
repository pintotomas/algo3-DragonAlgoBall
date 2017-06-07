package dab.equipos;

import dab.personajes.Personaje;
import dab.personajes.gohan.Gohan;
import dab.personajes.goku.Goku;
import dab.personajes.piccolo.Piccolo;

public class GuerrerosZ extends Equipo{
	
	public GuerrerosZ(){
		personajes.put("Goku", new Personaje(new Goku()));
		personajes.put("Gohan", new Personaje(new Gohan()));
		personajes.put("Piccolo", new Personaje(new Piccolo()));  //se podria remplazar por algun tipo de lista que los contenga, aunque no creo que sea util.
		for(Personaje personaje : personajes.values())
			personaje.setEquipo(this);
	}
	
	
	
	
}