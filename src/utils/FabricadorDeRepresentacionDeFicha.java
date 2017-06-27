package utils;

import java.util.HashMap;

public class FabricadorDeRepresentacionDeFicha {

	@SuppressWarnings("serial")
	private final HashMap<String, String> representacionPersonajes = new HashMap<String, String>() {{
		
	    put("Goku","/resources/imagenes/personajes/goku1.png");
	    
	    put("Goku Kaio-Ken", "/resources/imagenes/personajes/goku2.png");
	    
	    put("Goku Super Sayajin", "/resources/imagenes/personajes/goku3.png");
	    
	    put("Piccolo","/resources/imagenes/personajes/piccolo1.png");
	    
	    put("Piccolo Fortalecido","/resources/imagenes/personajes/piccolo2.png");
	    
	    put("Piccolo Protector","/resources/imagenes/personajes/piccolo3.png");
	    
	    put("Gohan","/resources/imagenes/personajes/gohan1.png");
	    
	    put("Gohan Super Sayajin Fase 1","/resources/imagenes/personajes/gohan2.png");
	    
	    put("Gohan Super Sayajin Fase 2","/resources/imagenes/personajes/gohan3.png");
	    
	    put("Cell","/resources/imagenes/personajes/cell1.png");
	    
	    put("Cell Semi Perfecto","/resources/imagenes/personajes/cell2.png");
	    
	    put("Cell Perfecto","/resources/imagenes/personajes/cell3.png");
	    
	    put("MajinBoo","/resources/imagenes/personajes/buu1.png");
	    
	    put("Boo Malo","/resources/imagenes/personajes/buu2.png");
	    
	    put("Boo Original","/resources/imagenes/personajes/buu3.png");
	    
	    put("Freezer","/resources/imagenes/personajes/freezer1.png");
	    
	    put("Freezer Definitivo","/resources/imagenes/personajes/freezer2.png");
	    
	    put("Freezer Segunda Forma","/resources/imagenes/personajes/freezer3.png");
	    
	    put("Semilla del Ermitanio","/resources/imagenes/consumibles/semilla.png");
	    
	    put("Esfera del Dragon","/resources/imagenes/consumibles/esfera.png");
	    
	    put("Nube Voladora","/resources/imagenes/consumibles/nube.png");
	    }
	};

	public String fabricarPersonaje(String nombrePersonajeAFabricar){
		return representacionPersonajes.get(nombrePersonajeAFabricar);
	}
}