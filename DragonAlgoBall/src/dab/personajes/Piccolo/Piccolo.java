package dab.personajes.Piccolo;
import dab.ataquesEspeciales.Makankosappo;
import dab.equipo.Equipo;
import dab.estados.piccolo.PiccoloBase;
import dab.personajes.Personaje;

public class Piccolo extends Personaje{
	
	public double porcentajeVidaGohanParaTransformar = 0.20;
	
	public Piccolo(){ 
		ataqueEspecial = new Makankosappo (this);
		kiParaEspecial = 10;
		estado = new PiccoloBase(this,equipo);
		vida = estado.getVidaMaxima();
	}	
	
	public Piccolo(Equipo equipo){
		ataqueEspecial = new Makankosappo (this);
		kiParaEspecial = 10;
		estado = new PiccoloBase(this,equipo);
		vida = estado.getVidaMaxima();
		this.equipo = equipo;
	}

}