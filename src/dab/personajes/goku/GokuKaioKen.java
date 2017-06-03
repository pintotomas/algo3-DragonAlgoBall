package dab.personajes.goku;
import dab.personajes.Personaje;

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
	public Personaje transformar() {
		// TODO Auto-generated method stub
		this.agregarKi(-kiParaTransformar);
		Personaje gokuSsj = new GokuSuperSayajin();
		return gokuSsj;
	}
}