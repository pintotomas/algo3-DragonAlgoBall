package Freezer;

public class FreezerDefinitivo extends Freezer {
	
	
	public FreezerDefinitivo(){
		vida = 400;
		poder = 50;
		alcance = 3;
		ki = 0;
		velocidad = 6;
		nombre = "Freezer Definitivo";
		kiParaTransformar = 50;
	}
		


	
	@Override
	public boolean transformarDisponible(){
		return false;
	}
}
