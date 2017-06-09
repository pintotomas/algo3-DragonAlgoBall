package dab.estados.gohan;

import dab.ataquesEspeciales.Masenko;
import dab.estados.Estado;
import dab.personaje.Personaje;

public class Gohan extends Estado {
	
	/*Representa al personaje Gohan*/
		
	protected Masenko spec = new Masenko();
	protected int kiParaTransformar;
		
	public Gohan(){
		vidaMaxima = 300;
		vida = vidaMaxima;
		poder = 15;
		alcance = 2;
		ki = 0;
		velocidad = 2;
		nombre = "Gohan";
		kiParaEspecial = 10;
		kiParaTransformar = 10;
	}
	
	@Override
	public boolean transformarDisponible() {
		return this.getKi() >= kiParaTransformar;
	}
		
	@Override
	public Estado transformar() {
		this.agregarKi(-kiParaTransformar);
		GohanSuperSayajinFase1 superSay1 = new GohanSuperSayajinFase1();
		return superSay1;
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
