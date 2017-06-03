package dab.personajes;

public class Freezer extends Personaje{
	
	public Freezer(){
		super("Freezer", 400, 20, 2, 4, 0);
	}
	
	public FreezerSegundaForma transformar(){
		FreezerSegundaForma segundaForma = new FreezerSegundaForma(this.getKi() - 20, this.getVida());
		return segundaForma;
	}
	

	@Override
	public boolean transformacionDisponible(){
		return (this.getKi() >= 20);
	}
	
	
	
	
	
	
	
	
	
	
}
