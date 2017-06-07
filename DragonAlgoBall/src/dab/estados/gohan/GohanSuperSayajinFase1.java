package dab.estados.gohan;

public class GohanSuperSayajinFase1 extends Gohan{
	/*segunda transformacion de gohan*/
		public GohanSuperSayajinFase1(){
		vida = 300;
		poder = 30;
		alcance = 2;
		ki = 0;
		velocidad = 2;
		nombre = "Gohan Super Sayajin Fase 2";
		kiParaTransformar = 30;
	}
	
	
	@Override
	public boolean transformarDisponible(){
		boolean kiSuficiente,vidaDeLosAmigos = false;  //falta funcion para checkear la vida de los amigos
		kiSuficiente = ki >= kiParaTransformar;
		return kiSuficiente && vidaDeLosAmigos;			
	}
	
	
	
	@Override
	public GohanSuperSayajinFase2 transformar() {
		this.agregarKi(-kiParaTransformar);
		GohanSuperSayajinFase2 gohanSuperSai2 = new GohanSuperSayajinFase2();
		return gohanSuperSai2;
	}
}
