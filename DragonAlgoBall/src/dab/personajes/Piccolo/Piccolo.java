package dab.personajes.Piccolo;
import dab.ataquesEspeciales.Makankosappo;
import dab.equipo.Equipo;
import dab.estados.piccolo.PiccoloBase;
import dab.personajes.Personaje;

public class Piccolo extends Personaje{
	
	public double porcetanejVidaGohanParaTransformar = 0.20;
	
	public Piccolo(){ 
		spec = new Makankosappo (this);
		kiParaEspecial = 10;
		estado = new PiccoloBase(this,equipo);
		vida = estado.getVidaMaxima();
	}	
	
	public Piccolo(Equipo equipo){
		spec = new Makankosappo (this);
		kiParaEspecial = 10;
		estado = new PiccoloBase(this,equipo);
		vida = estado.getVidaMaxima();
		this.equipo = equipo;
	}

}