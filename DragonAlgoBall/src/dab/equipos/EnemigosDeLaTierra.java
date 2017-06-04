package dab.equipos;

import dab.personajes.Personaje;
import dab.personajes.cell.Cell;
import dab.personajes.freezer.Freezer;
import dab.personajes.majinBoo.MajinBoo;

public class EnemigosDeLaTierra extends Equipo {
		
		public EnemigosDeLaTierra(){
			personajes.put("goku", new Cell());
			personajes.put("gohan", new MajinBoo());
			personajes.put("piccolo", new Freezer()); 
			for(Personaje personaje : personajes.values())
				personaje.setEquipo(this);
		}
	

}
