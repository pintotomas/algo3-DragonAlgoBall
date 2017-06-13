package dab.personajes.Piccolo;
import dab.ataquesEspeciales.Makankosappo;
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

}