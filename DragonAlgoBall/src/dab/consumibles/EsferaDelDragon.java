package dab.consumibles;

import dab.equipos.Equipo;
import dab.personajes.Personaje;

public class EsferaDelDragon extends Consumible {
	private int numeroDeAtaqueInicial;
	private int numeroDeAtaqueFinal;
	private int duracionConsumible = 2;
	
	public EsferaDelDragon(){
		nombre = "Esfera del Dragon";
	}

	@Override
	public boolean aplicarConsumible(Personaje personaje) {
		personaje.setConsumibleActivo(this);
		Equipo equipo_personaje = personaje.getEquipo();
		equipo_personaje.agregarEsferaDelDragon();
		numeroDeAtaqueInicial = personaje.getNumeroAtaque();
		numeroDeAtaqueFinal = numeroDeAtaqueInicial + duracionConsumible;
		return false;
	}
	
	public boolean estaActivo(Personaje personaje){
		if(numeroDeAtaqueFinal < personaje.getNumeroAtaque()){
			return false;
		}
		return true;
	}
}