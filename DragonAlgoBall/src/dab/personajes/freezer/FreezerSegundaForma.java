package dab.personajes.freezer;

import dab.personajes.Personaje;

public class FreezerSegundaForma extends Freezer{
	//segunda transformacion de freezer
	
	
	public FreezerSegundaForma(){
		vida = 400;
		poder = 40;
		alcance = 3;
		ki = 0;
		velocidad = 4;
		nombre = "Freezer segunda forma";
		kiParaTransformar = 50;
	}
	
	
	@Override
	public Personaje transformar() {
		this.agregarKi(-kiParaTransformar);
		Personaje definitivo = new FreezerDefinitivo();
		return definitivo;
	}


	
	@Override
	public boolean transformarDisponible(){
		return (this.getKi() >= 50);
	}
}
