package dab.personajes.cell;

import dab.ataquesEspeciales.Absorber;
import dab.equipo.Equipo;
import dab.estados.cell.CellBase;
import dab.interfaces.IProveedorDeCantidadAbsorbidos;
import dab.personajes.Personaje;

public class Cell extends Personaje implements IProveedorDeCantidadAbsorbidos{	
	protected int absorbidosParaTransformarCellSemiPerfecto = 4;
	protected int absorbidosParaTransformarCellPerfecto = 8;
	protected int absorbidos;

	public Cell(){
		spec = new Absorber(this);
		kiParaEspecial = 5;
		absorbidos = 0;
		estado = new CellBase(this);
		vida = estado.getVidaMaxima();
	}
	
	public Cell(Equipo equipo){
		spec = new Absorber(this);
		kiParaEspecial = 5;
		absorbidos = 0;
		estado = new CellBase(this);
		vida = estado.getVidaMaxima();
		this.equipo = equipo;
		
	}
	@Override
	public void ataqueEspecial(Personaje enemigo) {
		super.ataqueEspecial(enemigo);
		absorbidos += 1;
		this.agregarVida(this.getPoder());
	}
	
	public int getCantidadAbsorbidos(){
		return absorbidos;
	}

}