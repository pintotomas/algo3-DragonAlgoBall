package dab.personajes.piccolo;
import dab.ataquesEspeciales.Makankosappo ;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class Piccolo extends Estado {

		
	/*Representa al personaje Piccolo*/
		
		protected Makankosappo spec = new Makankosappo ();
		protected int kiParaTransformar;
		
		public Piccolo(){
			vidaMaxima = 500;
			vida = vidaMaxima;
			poder = 20;
			alcance = 2;
			ki = 0;
			velocidad = 2;
			nombre = "Piccolo";
			kiParaEspecial = 10;
			kiParaTransformar = 20;
		}
		
		@Override
		public boolean transformarDisponible() {
			return this.getKi() >= kiParaTransformar;
		}
		
		@Override
		public Estado transformar() {
			this.agregarKi(-kiParaTransformar);
			PiccoloFortalecido fortalecido = new PiccoloFortalecido();
			return fortalecido;
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
