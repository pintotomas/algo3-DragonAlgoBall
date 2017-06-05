package dab.personajes.goku;
import dab.personajes.Estado;

public class GokuKaioKen extends Goku{
	/*Representa a la primer transformacion de Goku*/

	public GokuKaioKen(){
		vida = 500;
		poder = 40;
		alcance = 4;
		ki = 0;
		velocidad = 3;
		nombre = "Goku Kaio-Ken";
		kiParaTransformar = 50;
	}
	
	@Override
	public Estado transformar() {
		// TODO Auto-generated method stub
		this.agregarKi(-kiParaTransformar);
		Estado gokuSsj = new GokuSuperSayajin();
		return gokuSsj;
	}
}