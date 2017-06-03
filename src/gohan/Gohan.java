package gohan;

import dab.ataquesEspeciales.Masenko;
import dab.personajes.Personaje;

public class Gohan extends Personaje {

		
	/*Representa al personaje Gohan*/
		
		protected Masenko spec = new Masenko();
		protected int kiParaTransformar;
		
		public Gohan(){
			vida = 300;
			poder = 20;
			alcance = 2;
			ki = 0;
			velocidad = 4;
			nombre = "Gohan";
			kiParaEspecial = 20;
			kiParaTransformar = 10;
		}
		
		@Override
		public boolean transformarDisponible() {
			return this.getKi() >= kiParaTransformar;
		}
		
		@Override
		public Personaje transformar() {
			this.agregarKi(-kiParaTransformar);
			Personaje superSay1 = new GohanSuperSayajinFase1();
			return superSay1;
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
