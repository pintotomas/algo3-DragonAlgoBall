package utils;

import java.util.HashMap;

public class FabricadorDeRepresentacionDeAvatar {

	@SuppressWarnings("serial")
	private final HashMap<String, String> representacionAvatares = new HashMap<String, String>() {{
		
	    put("Goku","/resources/imagenes/personajes/goku1avatar.png");
	    
	    put("Goku Kaio-Ken", "/resources/imagenes/personajes/goku2avatar.png");
	    
	    put("Goku Super Sayajin", "/resources/imagenes/personajes/goku3avatar.png");
	    
	    put("Piccolo","/resources/imagenes/personajes/piccolo1avatar.png");
	    
	    put("Piccolo Fortalecido","/resources/imagenes/personajes/piccolo2avatar.png");
	    
	    put("Piccolo Protector","/resources/imagenes/personajes/piccolo3avatar.png");
	    
	    put("Gohan","/resources/imagenes/personajes/gohan1avatar.png");
	    
	    put("Gohan Super Sayajin Fase 1","/resources/imagenes/personajes/gohan2avatar.png");
	    
	    put("Gohan Super Sayajin Fase 2","/resources/imagenes/personajes/gohan3avatar.png");
	    
	    put("Cell","/resources/imagenes/personajes/cell1avatar.png");
	    
	    put("Cell Semi Perfecto","/resources/imagenes/personajes/cell2avatar.png"
	    		+ "");
	    put("Cell Perfecto","/resources/imagenes/personajes/cell3avatar.png");
	    
	    put("MajinBoo","/resources/imagenes/personajes/buu1avatar.png");
	    
	    put("Boo Malo","/resources/imagenes/personajes/buu2avatar.png");
	    
	    put("Boo Original","/resources/imagenes/personajes/buu3avatar.png");
	    
	    put("Freezer","/resources/imagenes/personajes/freezer1avatar.png");
	    
	    put("Freezer Definitivo","/resources/imagenes/personajes/freezer2avatar.png");
	    
	    put("Freezer Segunda Forma","/resources/imagenes/personajes/freezer3avatar.png");
	    
	    }
	};

	public String fabricarAvatar(String nombrePersonajeAFabricar){
		return representacionAvatares.get(nombrePersonajeAFabricar);
	}
}