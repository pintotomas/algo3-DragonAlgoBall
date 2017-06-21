package vista.fabricadorPersonaje;

import java.util.HashMap;

import javafx.scene.image.Image;


public class FabricadorDeRepresentacionDePersonaje {
	

	private final HashMap<String, String> representacionPersonajes = new HashMap<String, String>() {{
	    put("Goku","vista/Imagenes/personajes/GokuNormalEnEspera.png");
	    put("Piccolo","vista/Imagenes/personajes/PiccoloNormalEnEspera.png");
	    put("Gohan","vista/Imagenes/personajes/GohanNormalEnEspera.png");
	    put("Cell","vista/Imagenes/personajes/CellImperfectoEnEspera.png");
	    put("MajinBoo","vista/Imagenes/personajes/BuuNormalEnEspera.png");
	    put("Freezer","vista/Imagenes/personajes/FriezaNormalEnEspera.png");
	}};
	
	

	public String fabricarPersonaje(String nombrePersonajeAFabricar){
		return representacionPersonajes.get(nombrePersonajeAFabricar);
		
	}
}