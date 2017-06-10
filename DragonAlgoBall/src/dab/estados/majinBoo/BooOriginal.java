package dab.estados.majinBoo;

public class BooOriginal extends BooMalo {
	public BooOriginal(){
		vida = 300;
		poder = 60;
		alcance = 3;
		ki = 0;
		velocidad = 4;
		nombre = "Boo Original";
		kiParaEspecial = 30;
		kiParaTransformar = 0;
	}


	@Override
	public boolean transformarDisponible() {
		return false;
	}


}
