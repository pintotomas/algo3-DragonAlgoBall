package dab.personajes.majinBoo;
import dab.ataquesEspeciales.ConvierteteEnChocolate;
import dab.equipo.Equipo;
import dab.estados.majinBoo.MajinBooBase;
import dab.personajes.Personaje;

public class MajinBoo extends Personaje{
	
	public static int identificador = 5;
	
	public MajinBoo(){ 
		ataqueEspecial = new ConvierteteEnChocolate(this);
		kiParaEspecial = 30;
		estado = new MajinBooBase(this);
		vida = estado.getVidaMaxima();
	}
	
	public MajinBoo(Equipo equipo){
		this();
		this.equipo = equipo;
	}
	
	@Override
	public Integer getIdentificador(){
		return identificador;
	}
}