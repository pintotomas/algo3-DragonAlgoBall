package dab.estados.piccolo;
import dab.estados.Estado;

public class PiccoloBase extends Estado {

		
	/*Representa al personaje Piccolo*/
		
		public PiccoloBase(){
			vidaMaxima = 500;
			poder = 20;
			alcance = 2;
			velocidad = 2;
			nombre = "Piccolo";
			kiParaTransformar = 20;
		}
}
