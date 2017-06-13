package dab.personajes.majinBoo;
import dab.ataquesEspeciales.ConvierteteEnChocolate;
import dab.estados.majinBoo.MajinBooBase;
import dab.personajes.Personaje;

public class MajinBoo extends Personaje{
	
	public MajinBoo(){ 
		spec = new ConvierteteEnChocolate(this);
		kiParaEspecial = 30;
		estado = new MajinBooBase(this);
		vida = estado.getVidaMaxima();
	}
}