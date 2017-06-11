package dab.personajes.cell;
import java.util.Iterator;
import java.util.ListIterator;

import dab.ataquesEspeciales.Absorber;
import dab.estados.cell.Cell;
import dab.estados.cell.CellPerfecto;
import dab.estados.cell.CellSemiPerfecto;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class PersonajeCell extends Personaje{
	
	protected int absorbidosParaTransformar;
	protected int absorbidos;
	protected Absorber spec = new Absorber();
	
	public PersonajeCell(){
		estados.add(Cell.class);
		estados.add(CellPerfecto.class);
		estados.add(CellSemiPerfecto.class);
		Iterator<Class<? extends Estado>> iter = estados.iterator();
	}

	@Override
	public boolean transformarDisponible() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void ataqueEspecial(Personaje enemigo) {
		spec.lanzar(this.getPoder(), enemigo);
		this.absorbidos += 1;     //si el ataque funciona absorbio a uno. puede fallar si lanzar puede tirar error.
	}



}