package dab.personajes.cell;

import dab.ataquesEspeciales.Absorber;
import dab.equipo.Equipo;
import dab.estados.cell.CellBase;
import dab.interfaces.IProveedorDeCantidadAbsorbidos;
import dab.personajes.Personaje;


public class Cell extends Personaje implements IProveedorDeCantidadAbsorbidos{	
	

	public static int identificador = 1;
	
	protected int absorbidos;

	public Cell(){
		ataqueEspecial = new Absorber(this);
		kiParaEspecial = 5;
		absorbidos = 0;
		estado = new CellBase(this);
		vida = estado.getVidaMaxima();
	}
	
	public Cell(Equipo equipo){
		this();
		this.equipo = equipo;
		
	}
	@Override
	public void ataqueEspecial(Personaje enemigo) {
		super.ataqueEspecial(enemigo);
		absorbidos += 1;
		this.modificarVida(this.getPoder());
	}
	
	public int getCantidadAbsorbidos(){
		return absorbidos;
	}
	
	@Override
	public Integer getIdentificador(){
		return identificador;
	}


}