package utils;

import java.util.HashMap;

public class FabricadorDeRepresentacionDeAvatar {

	@SuppressWarnings("serial")
	private final HashMap<String, String> representacionAvatares = new HashMap<String, String>() {{
	    put("Goku","vista/Imagenes/personajes/goku1avatar.png");
	    put("Goku Kaio-Ken", "vista/Imagenes/personajes/goku2avatar.png");
	    put("Goku Super Sayajin", "vista/Imagenes/personajes/goku3avatar.png");
	    put("Piccolo","vista/Imagenes/personajes/piccolo1avatar.png");
	    put("Piccolo Fortalecido","vista/Imagenes/personajes/piccolo2avatar.png");
	    put("Piccolo Protector","vista/Imagenes/personajes/piccolo3avatar.png");
	    put("Gohan","vista/Imagenes/personajes/gohan1avatar.png");
	    put("Gohan Super Sayajin Fase 1","vista/Imagenes/personajes/gohan2avatar.png");
	    put("Gohan Super Sayajin Fase 2","vista/Imagenes/personajes/gohan3avatar.png");
	    put("Cell","vista/Imagenes/personajes/cell1avatar.png");
	    put("Cell Semi Perfecto","vista/Imagenes/personajes/cell2avatar.png");
	    put("Cell Perfecto","vista/Imagenes/personajes/cell3avatar.png");
	    put("MajinBoo","vista/Imagenes/personajes/buu1avatar.png");
	    put("Boo Malo","vista/Imagenes/personajes/buu2avatar.png");
	    put("Boo Original","vista/Imagenes/personajes/buu3avatar.png");
	    put("Freezer","vista/Imagenes/personajes/freezer1avatar.png");
	    put("Freezer Definitivo","vista/Imagenes/personajes/freezer2avatar.png");
	    put("Freezer Segunda Forma","vista/Imagenes/personajes/freezer3avatar.png");
	    }
	};

	public String fabricarAvatar(String nombrePersonajeAFabricar){
		return representacionAvatares.get(nombrePersonajeAFabricar);
	}
}