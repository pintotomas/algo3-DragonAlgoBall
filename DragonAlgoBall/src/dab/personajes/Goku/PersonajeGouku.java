package dab.personajes.Goku;
import java.util.Iterator;

import dab.estados.cell.Cell;
import dab.estados.cell.CellPerfecto;
import dab.estados.cell.CellSemiPerfecto;
import dab.estados.goku.Goku;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class PersonajeGouku extends Personaje{
	
	public PersonajeGouku(){ 
		estados.add(Cell.class);
		estados.add(CellPerfecto.class);
		estados.add(CellSemiPerfecto.class);
		Iterator<Class<? extends Estado>> iter = estados.iterator();
		super(iter);
		
	}
	
	
	
	
}
