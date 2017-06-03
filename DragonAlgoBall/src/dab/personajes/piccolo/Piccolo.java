package dab.personajes.piccolo;
import dab.ataquesEspeciales.Makankosappo ;
import dab.personajes.Personaje;

public class Piccolo extends Personaje {

		
	/*Representa al personaje Piccolo*/
		
		protected Masenko spec = new Makankosappo ();
		private int kiParaTransformar; //La condicion para transformar a Piccolo Fortalecido es distinta
		
		public Piccolo(){
			vida = 500;
			poder = 40;
			alcance = 4;
			ki = 0;
			velocidad = 3;
			nombre = "Piccolo";
			kiParaEspecial = 10;
			kiParaTransformar = 20;
		}
		
		@Override
		public boolean transformarDisponible() {
			return this.getKi() >= kiParaTransformar;
		}
		
		@Override
		public Personaje transformar() {
			this.agregarKi(-kiParaTransformar);
			Personaje fortalecido = new PiccoloFortalecido();
			return fortalecido;
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
