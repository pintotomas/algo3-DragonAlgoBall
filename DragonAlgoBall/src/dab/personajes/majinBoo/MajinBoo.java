package dab.personajes.majinBoo;
import dab.ataquesEspeciales.ConvierteteEnChocolate;
import dab.personajes.Personaje;

public class MajinBoo extends Personaje{
	
	/*Representa al personaje MajinBoo*/
	
	protected ConvierteteEnChocolate spec = new ConvierteteEnChocolate();
	protected int kiParaTransformar;
	
	
	
	public MajinBoo(){
		vida = 300;
		poder = 30;
		alcance = 2;
		ki = 0;
		velocidad = 3;
		nombre = "MajinBoo";
		kiParaEspecial = 30;
		kiParaTransformar = 20;
	}
	
	@Override
	public boolean transformarDisponible() {
		return this.getKi() >= kiParaTransformar;
	}
	
	@Override
	public Personaje transformar() {
		Personaje booMalo = new BooMalo();
		return booMalo;
	}

	@Override
	public boolean ataqueEspecialDisponible() {
		return this.getKi() >= kiParaEspecial;
	}

	@Override
	public void ataqueEspecial(Personaje enemigo) {
		spec.lanzar(this.getPp(), enemigo);
		
	}


}