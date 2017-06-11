package dab.estados.cell;
import dab.ataquesEspeciales.Absorber;
import dab.personajes.Estado;
import dab.personajes.Personaje;

public class Cell extends Estado{
	
	/*Representa al personaje Cell*/
	
	public Cell(){ 
		vidaMaxima = 500;
		vida = vidaMaxima;
		poder = 20;
		alcance = 3;
		ki = 0;
		velocidad = 2;
		nombre = "Cell";
		kiParaEspecial = 5;
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