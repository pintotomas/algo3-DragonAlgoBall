package dab.personajes;

public class FreezerDefinitivo extends Personaje {
	
	
	public FreezerDefinitivo(int vidaNueva, int kiNuevo){
		super("Freezer Definitivo",vidaNueva, 40, 3, 4, kiNuevo);		
	}
		


	@Override
	public boolean transformacionDisponible(){
		return false;
	}
}
