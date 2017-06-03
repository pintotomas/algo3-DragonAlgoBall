package dab.personajes.goku;
import dab.personajes.Personaje;

public class Goku extends Personaje{
	
	static int vidaGoku = 500;
	static int poderGoku = 20;
	static int alcanceGoku = 2;
	static int kiInicialGoku = 0;
	static int velocidadGoku = 2;
	static String nombreGoku = "Goku";
	int kiNecesarioSpecGoku = 20;
	
	public Goku() {
		super(vidaGoku, poderGoku, alcanceGoku, kiInicialGoku, velocidadGoku, nombreGoku);
		// TODO Auto-generated constructor stub
	}

	public boolean transformacionDisponible() {
		return true;
	}

	public Personaje transformar() {
		KaioKen kaio = new KaioKen();
		return kaio;
	}

	public void ataqueEspecial(Personaje enemigo) {
		// TODO Auto-generated method stub
		enemigo.modificarHp(-2*this.getPp());
	}

	@Override
	public boolean ataqueEspecialDisponible() {
		// TODO Auto-generated method stub
		return (this.getKi() >= kiNecesarioSpecGoku);
	}

}