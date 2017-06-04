package dab.equipos;

import dab.personajes.Personaje;
import dab.personajes.cell.Cell;
import dab.personajes.freezer.Freezer;
import dab.personajes.majinBoo.MajinBoo;

public class EnemigosDeLaTierra extends Equipo {
		
		public EnemigosDeLaTierra(){
			personajes.put("cell", new Cell());
			personajes.put("majinboo", new MajinBoo());
			personajes.put("freezer", new Freezer()); 
			for(Personaje personaje : personajes.values())
				personaje.setEquipo(this);
		}
	

}
