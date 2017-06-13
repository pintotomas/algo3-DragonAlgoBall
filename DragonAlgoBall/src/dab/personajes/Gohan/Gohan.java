package dab.personajes.Gohan;

import dab.ataquesEspeciales.Masenko;
import dab.estados.gohan.GohanBase;
import dab.personajes.Personaje;

public class Gohan extends Personaje{
	
	public double porcentajeVidaAmigosParaTransformar = 0.3;
	/*PUBLICO PARA TESTING*/
	
	public Gohan(){ 
		
		spec = new Masenko(this);
		kiParaEspecial = 10;
		estado = new GohanBase(equipo, this);
		vida = estado.getVidaMaxima();
	}

}