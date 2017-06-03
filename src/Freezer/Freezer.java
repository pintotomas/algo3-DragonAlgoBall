package Freezer;

import dab.ataquesEspeciales.RayoMortal;
import dab.personajes.Personaje;

public class Freezer extends Personaje{
	
/*Representa al personaje Goku*/
	
	protected RayoMortal spec = new RayoMortal();
	protected int kiParaTransformar;
	
	public Freezer(){
		vida = 500;
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
	public Personaje transformar() {
		this.agregarKi(-kiParaTransformar);
		Personaje freezerSegunda = new FreezerSegundaForma();
		return freezerSegunda;
	}

	@Override
	public boolean ataqueEspecialDisponible() {
		return this.getKi() >= kiParaEspecial;
	}

	@Override
	public void ataqueEspecial(Personaje enemigo) {
		spec.lanzar(this.getPp(), enemigo);
		
	}
	
	
	
	
	
	
	
	
	
}
