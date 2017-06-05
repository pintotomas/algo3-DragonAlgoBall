package dab.personajes.freezer;


public class FreezerSegundaForma extends Freezer{
	//segunda transformacion de freezer
	
	
	public FreezerSegundaForma(){
		vida = 400;
		poder = 40;
		alcance = 3;
		ki = 0;
		velocidad = 4;
		nombre = "Freezer Segunda Forma";
		kiParaTransformar = 50;
	}
	
	
	@Override
	public FreezerDefinitivo transformar() {
		this.agregarKi(-kiParaTransformar);
		FreezerDefinitivo definitivo = new FreezerDefinitivo();
		return definitivo;
	}


	
	@Override
	public boolean transformarDisponible(){
		return (this.getKi() >= 50);
	}
}
