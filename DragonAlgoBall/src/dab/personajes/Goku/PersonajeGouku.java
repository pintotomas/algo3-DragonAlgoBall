package dab.personajes.Goku;
import dab.estados.goku.Goku;
import dab.personajes.Personaje;

public class PersonajeGouku extends Personaje{
	
	public PersonajeGouku(){ 
		super(new Goku());
		
	}
	
	@Override
	public boolean transformarDisponible() {
		return this.getKi() >= estado.kiParaTransformar;
	}


}
