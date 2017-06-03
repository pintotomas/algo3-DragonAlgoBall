package dab.personajes.goku;
import dab.personajes.Personaje;

public class KaioKen extends Personaje {

	public KaioKen(int ki, int vida) {
		/*KiAnterior guarda el ki restante luego de la transformacion*/
		super("Goku kaio-ken", vida, 40, 4, 3, ki);
	}

	@Override
	public boolean transformacionDisponible() {
		return (this.getKi() >= 50);		
	}
	
	public GokuSuperSayajin transformar(){
		GokuSuperSayajin ssj = new GokuSuperSayajin(this.getKi() - 40, this.getVida());	
		return ssj;
	}
}
