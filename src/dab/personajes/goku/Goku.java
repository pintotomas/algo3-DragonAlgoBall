package dab.personajes.goku;
import dab.personajes.Personaje;

public class Goku extends Personaje {

	public Goku() {
		super("Goku", 500, 20, 2, 2, 0);
	}
	
	public KaioKen transformar(){
		KaioKen kaio = new KaioKen(this.getKi() - 40, this.getVida());	
		return kaio;
	}
	

	@Override
	public boolean transformacionDisponible(){
		return (this.getKi() >= 20);
	}
	
}
