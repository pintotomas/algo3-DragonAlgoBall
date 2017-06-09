package dab.equipos;

import dab.estados.cell.Cell;
import dab.estados.freezer.Freezer;
import dab.estados.majinBoo.MajinBoo;
import dab.personajes.Personaje;

public class EnemigosDeLaTierra extends Equipo {
		
		public EnemigosDeLaTierra(){
			personajes.put("Cell", new Personaje(new Cell()));
			personajes.put("MajinBoo", new Personaje(new MajinBoo()));
			personajes.put("Freezer", new Personaje(new Freezer())); 
			for(Personaje personaje : personajes.values())
				personaje.setEquipo(this);
		}
	

}
