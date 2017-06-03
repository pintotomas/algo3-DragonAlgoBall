package dab.personajes.goku;
import dab.personajes.Personaje;

public class Goku extends Personaje{
	
	private static int vida = 500;
	private static int poder = 20;
	private static int alcance = 2;
	private static int kiInicial = 0;
	private static int velocidad = 2;
	private static String nombre = "Goku";
	protected int kiNecesarioSpec = 20;
	
	public Goku() {
		super(vida, poder, alcance, kiInicial, velocidad, nombre);
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
		return (this.getKi() >= kiNecesarioSpec);
	}

}