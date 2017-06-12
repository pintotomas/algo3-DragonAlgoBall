package dab.personajes.cell;
import java.util.Iterator;

import dab.ataquesEspeciales.Absorber;
import dab.estados.cell.CellBase;
import dab.estados.cell.CellPerfecto;
import dab.estados.cell.CellSemiPerfecto;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class Cell extends Personaje{
	
	protected int absorbidosParaTransformarCellSemiPerfecto;
	protected int absorbidosParaTransformarCellPerfecto;
	protected int absorbidos;

	public Cell(){
		spec = new Absorber(this);
		kiParaEspecial = 5;
		kiParaEspecial = 20;
		estado = new CellBase();
		estados.add(new CellBase());
		estados.add(new CellSemiPerfecto());
		estados.add(new CellPerfecto());
		Iterator<Estado> iter = estados.iterator();
		setIter(iter);	
	}

	
	@Override
	public void ataqueEspecial(Personaje enemigo) {
		super.ataqueEspecial(enemigo);
		absorbidos += 1;
		this.agregarVida(this.getPoder());
		
	}
	
	
	public boolean transformarDisponible() {
		if(estado.getClass() == CellSemiPerfecto.class){			
			return(absorbidos >= absorbidosParaTransformarCellPerfecto);
		}
		if(estado.getClass() == CellBase.class){			
			return(absorbidos >= absorbidosParaTransformarCellSemiPerfecto);
		}
		return false;		
	}
	

	
	

}