package dab.personajes.cell;
import java.util.Iterator;

import dab.ataquesEspeciales.Absorber;
import dab.estados.cell.Cell;
import dab.estados.cell.CellPerfecto;
import dab.estados.cell.CellSemiPerfecto;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class PersonajeCell extends Personaje{
	
	protected int absorbidosParaTransformarCellSemiPerfecto;
	protected int absorbidosParaTransformarCellPerfecto;
	protected int absorbidos;
	protected Absorber spec = new Absorber();
	
	public PersonajeCell(){
		spec = new Absorber();
		kiParaEspecial = 5;
		kiParaEspecial = 20;
		estados.add(Cell.class);
		estados.add(CellSemiPerfecto.class);
		estados.add(CellPerfecto.class);
		Iterator<Class<? extends Estado>> iter = estados.iterator();
		setIter(iter);	
	}

	
	@Override
	public void ataqueEspecial(Personaje enemigo) {
		super.ataqueEspecial(enemigo);
		absorbidos += 1;
		this.agregarHp(this.getPoder());
		
	}
	
	
	public boolean transformarDisponible() {
		if(estado.getClass() == CellSemiPerfecto.class){			
			return(absorbidos >= absorbidosParaTransformarCellPerfecto);
		}
		if(estado.getClass() == Cell.class){			
			return(absorbidos >= absorbidosParaTransformarCellSemiPerfecto);
		}
		return false;		
	}
	

	
	

}