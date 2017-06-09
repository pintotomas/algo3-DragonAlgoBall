package dab.estados.majinBoo;
import dab.ataquesEspeciales.ConvierteteEnChocolate;
import dab.estados.Estado;
import dab.personaje.Personaje;

public class MajinBoo extends Estado{
	
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
	public Estado transformar() {
		BooMalo booMalo = new BooMalo();
		return booMalo;
	}

	@Override
	public boolean ataqueEspecialDisponible() {
		return this.getKi() >= kiParaEspecial;
	}

	@Override
	public void ataqueEspecial(Personaje enemigo) {
		spec.lanzar(this.getPoder(), enemigo);
		
	}


}