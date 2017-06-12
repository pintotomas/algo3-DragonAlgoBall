package dab.estados.piccolo;
import dab.personajes.Estado;

public class PiccoloBase extends Estado {

		
	/*Representa al personaje Piccolo*/
		
		public PiccoloBase(){
			vidaMaxima = 500;
			vida = vidaMaxima;
			poder = 20;
			alcance = 2;
			ki = 0;
			velocidad = 2;
			nombre = "Piccolo";
			kiParaTransformar = 20;
		}
}
