package dab.equipos;
import dab.personajes.*;

import java.util.HashMap;
import java.util.Map;

public abstract class Equipo {
	/*contiene a los personajes, y a su vez,  podria ser que los personajes contengan al equipo.
	 * asi por ejemplo para la habilidad de picollo y gohan podemos acceder a los personajes del equipo de
	 * forma rapida
	 */
	
	
	Map<String, Personaje> personajes = new HashMap<String, Personaje>();
	int esferasDelDragon, personajesVivos;
	
	public boolean esGanador(){
		if (esferasDelDragon >= 7)
			return true;
		return false;
	}
	
	public boolean esPerdedor(){
		if(personajesVivos == 0)
			return true;
		return false;
	}
	
}
