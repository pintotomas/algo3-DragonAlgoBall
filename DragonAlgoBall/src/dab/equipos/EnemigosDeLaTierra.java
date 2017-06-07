package dab.equipos;

import dab.personajes.Personaje;
import dab.personajes.cell.Cell;
import dab.personajes.freezer.Freezer;
import dab.personajes.majinBoo.MajinBoo;

public class EnemigosDeLaTierra extends Equipo {
		
		public EnemigosDeLaTierra(){
			personajes.put("Cell", new Personaje(new Cell()));
			personajes.put("MajinBoo", new Personaje(new MajinBoo()));
			personajes.put("Freezer", new Personaje(new Freezer())); 
			for(Personaje personaje : personajes.values())
				personaje.setEquipo(this);
		}
	

}
