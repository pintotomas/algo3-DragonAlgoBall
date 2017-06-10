package dab.estados.piccolo;


public class PiccoloFortalecido extends Piccolo {
	public PiccoloFortalecido(){
		vida = 500;
		poder = 40;
		alcance = 4;
		ki = 0;
		velocidad = 3;
		nombre = "Piccolo fortalecido";
		kiParaEspecial = 10;
		kiParaTransformar = 0;
	}
	@Override
	public PiccoloProtector transformar() {
		this.agregarKi(-kiParaTransformar);
		PiccoloProtector protector = new PiccoloProtector();
		return protector;
		}

	@Override
	public boolean transformarDisponible() {
		boolean gohanEnPeligro = false;  //pseudocodigo basicamente
		return gohanEnPeligro;
	}




}
