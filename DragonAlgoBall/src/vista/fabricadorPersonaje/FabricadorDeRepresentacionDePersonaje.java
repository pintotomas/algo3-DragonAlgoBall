package vista.fabricadorPersonaje;

import java.util.HashMap;

import javafx.scene.image.Image;


public class FabricadorDeRepresentacionDePersonaje {
	

	private final HashMap<String, String> representacionPersonajes = new HashMap<String, String>() {{
	    put("Goku","vista/Imagenes/personajes/GokuNormalQuieto.png");
	    put("Piccolo","vista/Imagenes/personajes/PiccoloNormalQuieto.png");
	    put("Gohan","vista/Imagenes/personajes/GohanNormalQuieto.png");
	    put("Cell","vista/Imagenes/personajes/CellImperfectoQuieto.png");
	    put("MajinBoo","vista/Imagenes/personajes/BuuNormalQuieto.png");
	    put("Freezer","vista/Imagenes/personajes/FriezaNormalQuieto.png");
	}};
	
	

	public String fabricarPersonaje(String nombrePersonajeAFabricar){
		return representacionPersonajes.get(nombrePersonajeAFabricar);
		
	}
}