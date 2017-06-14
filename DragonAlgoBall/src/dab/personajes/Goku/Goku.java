package dab.personajes.Goku;

import dab.ataquesEspeciales.Kamehameha;
import dab.equipo.Equipo;
import dab.estados.goku.GokuBase;
import dab.personajes.Personaje;
import dab.potenciadores.Furia;

public class Goku extends Personaje{
	
	public Goku(){ 
		ataqueEspecial = new Kamehameha(this);
		kiParaEspecial = 20;
		kiParaTransformar = 20;
		estado = new GokuBase(this);
		vida = estado.getVidaMaxima();
		this.agarrarPotenciador(new Furia(this));
	}
	
	public Goku(Equipo equipo){
		ataqueEspecial = new Kamehameha(this);
		kiParaEspecial = 20;
		kiParaTransformar = 20;
		estado = new GokuBase(this);
		vida = estado.getVidaMaxima();
		this.agarrarPotenciador(new Furia(this));
		this.equipo = equipo;
	}
}
