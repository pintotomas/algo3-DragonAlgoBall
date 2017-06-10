package dab.estados.gohan;

public class GohanSuperSayajinFase2 extends GohanSuperSayajinFase1 {
	/*tercera transformacion de gohan*/
	public GohanSuperSayajinFase2(){
	vida = 300;
	poder = 100;
	alcance = 4;
	ki = 0;
	velocidad = 3;
	nombre = "Gohan super sayajin fase 2";
}

	
	@Override
	public boolean transformarDisponible(){
		return false;
	}


}
