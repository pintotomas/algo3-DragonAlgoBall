package vista.fabricadorPersonaje;

import java.util.HashMap;

import javafx.scene.image.Image;


public class FabricadorDeRepresentacionDePersonaje {
	

	private final HashMap<String, String> representacionPersonajes = new HashMap<String, String>() {{
	    put("Goku","vista/Imagenes/personajes/goku1.png");
	    put("Piccolo","vista/Imagenes/personajes/piccolo1.png");
	    put("Gohan","vista/Imagenes/personajes/gohan1.png");
	    put("Cell","vista/Imagenes/personajes/cell1.png");
	    put("MajinBoo","vista/Imagenes/personajes/buu1.png");
	    put("Freezer","vista/Imagenes/personajes/freezer1.png");
	}};
	
	

	public String fabricarPersonaje(String nombrePersonajeAFabricar){
		return representacionPersonajes.get(nombrePersonajeAFabricar);
		
	}
}