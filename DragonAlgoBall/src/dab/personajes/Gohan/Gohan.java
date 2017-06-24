package dab.personajes.Gohan;

import dab.ataquesEspeciales.Masenko;
import dab.equipo.Equipo;
import dab.estados.gohan.GohanBase;
import dab.personajes.Personaje;

public class Gohan extends Personaje{
	
	public double porcentajeVidaAmigosParaTransformar = 0.3;
	/*PUBLICO PARA TESTING*/
	
	public Gohan(){ 
		ataqueEspecial = new Masenko(this);
		kiParaEspecial = 10;
		estado = new GohanBase(equipo, this);
		vida = estado.getVidaMaxima();
	}
	
	public Gohan(Equipo equipo){
		ataqueEspecial = new Masenko(this);
		kiParaEspecial = 10;
		estado = new GohanBase(equipo, this);
		vida = estado.getVidaMaxima();
		this.equipo = equipo;
	}

	
	@Override
	public void setEquipo(Equipo equipo){
		super.setEquipo(equipo);
		estado = new GohanBase(equipo, this);	
	}
	
	
}