package dab.personajes.gohan;

import dab.personajes.Personaje;


public class GohanSuperSayajinFase1 extends Gohan{
	/*segunda transformacion de gohan*/
		public GohanSuperSayajinFase1(){
		vida = 300;
		poder = 30;
		alcance = 2;
		ki = 0;
		velocidad = 2;
		nombre = "gohan super sayajin fase 2";
		kiParaTransformar = 30;
	}
	
	
	@Override
	public boolean transformarDisponible(){
		boolean kiSuficiente,vidaDeLosAmigos = false;  //falta funcion para checkear la vida de los amigos
		kiSuficiente = ki >= kiParaTransformar;
		return kiSuficiente && vidaDeLosAmigos;			
	}
	
	
	
	@Override
	public Personaje transformar() {
		this.agregarKi(-kiParaTransformar);
		Personaje gohanSuperSai2 = new GohanSuperSayajinFase2();
		return gohanSuperSai2;
	}
}
