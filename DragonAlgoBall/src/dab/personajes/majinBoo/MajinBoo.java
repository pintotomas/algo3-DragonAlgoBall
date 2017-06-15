package dab.personajes.majinBoo;
import dab.ataquesEspeciales.ConvierteteEnChocolate;
import dab.equipo.Equipo;
import dab.estados.majinBoo.MajinBooBase;
import dab.personajes.Personaje;

public class MajinBoo extends Personaje{
	
	public MajinBoo(){ 
		ataqueEspecial = new ConvierteteEnChocolate(this);
		kiParaEspecial = 30;
		estado = new MajinBooBase(this);
		vida = estado.getVidaMaxima();
	}
	
	public MajinBoo(Equipo equipo){
		ataqueEspecial = new ConvierteteEnChocolate(this);
		kiParaEspecial = 30;
		estado = new MajinBooBase(this);
		vida = estado.getVidaMaxima();
		this.equipo = equipo;
	}
}