package dab.estados.goku;
import dab.ataquesEspeciales.Kamehameha;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class Goku extends Estado{
	
	/*Representa al personaje Goku*/
	
	protected Kamehameha spec = new Kamehameha();
	protected int kiParaTransformar;
	
	public Goku(){
		vidaMaxima = 500;
		vida = vidaMaxima;
		poder = 20;
		alcance = 2;
		ki = 0;
		velocidad = 2;
		nombre = "Goku";
		kiParaEspecial = 20;
		kiParaTransformar = 20;
	}
	
	@Override
	public boolean transformarDisponible() {
		return this.getKi() >= kiParaTransformar;
	}
	
	@Override
	public Estado transformar() {
		this.agregarKi(-kiParaTransformar); //esto creo que se podria separar en dos metodos
		GokuKaioKen gokuKaio = new GokuKaioKen();
		return gokuKaio;
	}

	@Override
	public boolean ataqueEspecialDisponible() {
		return this.getKi() >= kiParaEspecial;
	}

	@Override
	public void ataqueEspecial(Personaje enemigo) {
		spec.lanzar(this.getPoder(), enemigo);
		
	}


}