package dab.personajes;

public class FreezerSegundaForma extends Personaje{
	
	
	
	public FreezerSegundaForma(int vidaNueva, int kiNuevo){
		super("Freezer segunda forma", vidaNueva, 40, 3, 4, kiNuevo);
	}
	
	public FreezerDefinitivo transformarDefinitivo(){
			FreezerDefinitivo definitivo = new FreezerDefinitivo(this.getKi() - 50, this.getVida());
			return definitivo;
	}

	
	@Override
	public boolean transformacionDisponible(){
		return (this.getKi() >= 50);
	}
}
