package dab.personajes.piccolo;

public class PiccoloProtector extends PiccoloFortalecido {
	
	public PiccoloProtector(){
		vida = 500;
		poder = 60;
		alcance = 6;
		ki = 0;
		velocidad = 4;
		nombre = "Piccolo Protector";
		kiParaEspecial = 10;
		kiParaTransformar = 0;
	}
	
	@Override
	public boolean transformarDisponible() {
		return false;
	}

}
