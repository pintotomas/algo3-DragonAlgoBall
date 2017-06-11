package dab.estados.piccolo;
import dab.personajes.Estado;

public class Piccolo extends Estado {

		
	/*Representa al personaje Piccolo*/
		
		public Piccolo(){
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
