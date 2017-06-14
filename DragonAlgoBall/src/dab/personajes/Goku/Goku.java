package dab.personajes.Goku;

import dab.ataquesEspeciales.Kamehameha;
import dab.equipo.Equipo;
import dab.estados.goku.GokuBase;
import dab.personajes.Personaje;
import dab.potenciadores.Furia;

public class Goku extends Personaje{
	
	public Goku(){ 
		spec = new Kamehameha(this);
		kiParaEspecial = 20;
		kiParaTransformar = 20;
		estado = new GokuBase(this);
		vida = estado.getVidaMaxima();
		this.agregarPotenciador(new Furia(this));
	}
	
	public Goku(Equipo equipo){
		spec = new Kamehameha(this);
		kiParaEspecial = 20;
		kiParaTransformar = 20;
		estado = new GokuBase(this);
		vida = estado.getVidaMaxima();
		this.agregarPotenciador(new Furia(this));
		this.equipo = equipo;
	}
}
