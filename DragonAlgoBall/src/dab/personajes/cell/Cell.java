package dab.personajes.cell;
import dab.ataquesEspeciales.Absorber;
import dab.personajes.Personaje;

public class Cell extends Personaje{
	
	/*Representa al personaje Cell*/
	
	protected Absorber spec = new Absorber();
	protected int absorbidosParaTransformar;
	protected int absorbidos;
	
	
	
	
	public Cell(){ 
		vidaMaxima = 500;
		vida = vidaMaxima;
		poder = 20;
		alcance = 3;
		ki = 0;
		velocidad = 2;
		nombre = "Cell";
		kiParaEspecial = 5;
		absorbidosParaTransformar = 4;
		absorbidos = 0;
	}
	
	@Override
	public boolean transformarDisponible() {
		return absorbidos >= absorbidosParaTransformar;
	}
	
	@Override
	public Personaje transformar() {
		Personaje cellSemiPerfecto = new CellSemiPerfecto();
		return cellSemiPerfecto;
	}

	@Override
	public boolean ataqueEspecialDisponible() {
		return this.getKi() >= kiParaEspecial;
	}

	@Override
	public void ataqueEspecial(Personaje enemigo) {
		spec.lanzar(this.getPoder(), enemigo);
		this.absorbidos += 1;     //si el ataque funciona absorbio a uno. puede fallar si lanzar puede tirar error.
		
	}


}