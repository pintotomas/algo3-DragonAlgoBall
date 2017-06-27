package utils;

import java.util.HashMap;

public class FabricadorDeRepresentacionDeFicha {

	@SuppressWarnings("serial")
	private final HashMap<String, String> representacionPersonajes = new HashMap<String, String>() {{
	    put("Goku","/vista/Imagenes/personajes/goku1.png");
	    put("Goku Kaio-Ken", "/vista/Imagenes/personajes/goku2.png");
	    put("Goku Super Sayajin", "/vista/Imagenes/personajes/goku3.png");
	    put("Piccolo","/vista/Imagenes/personajes/piccolo1.png");
	    put("Piccolo Fortalecido","/vista/Imagenes/personajes/piccolo2.png");
	    put("Piccolo Protector","/vista/Imagenes/personajes/piccolo3.png");
	    put("Gohan","/vista/Imagenes/personajes/gohan1.png");
	    put("Gohan Super Sayajin Fase 1","/vista/Imagenes/personajes/gohan2.png");
	    put("Gohan Super Sayajin Fase 2","/vista/Imagenes/personajes/gohan3.png");
	    put("Cell","/vista/Imagenes/personajes/cell1.png");
	    put("Cell Semi Perfecto","/vista/Imagenes/personajes/cell2.png");
	    put("Cell Perfecto","/vista/Imagenes/personajes/cell3.png");
	    put("MajinBoo","/vista/Imagenes/personajes/buu1.png");
	    put("Boo Malo","/vista/Imagenes/personajes/buu2.png");
	    put("Boo Original","/vista/Imagenes/personajes/buu3.png");
	    put("Freezer","/vista/Imagenes/personajes/freezer1.png");
	    put("Freezer Definitivo","/vista/Imagenes/personajes/freezer2.png");
	    put("Freezer Segunda Forma","/vista/Imagenes/personajes/freezer3.png");
	    put("Semilla del Ermitanio","/vista/Imagenes/consumibles/semilla.png");
	    put("Esfera del Dragon","/vista/Imagenes/consumibles/esfera.png");
	    put("Nube Voladora","/vista/Imagenes/consumibles/nube.png");
	    }
	};

	public String fabricarPersonaje(String nombrePersonajeAFabricar){
		return representacionPersonajes.get(nombrePersonajeAFabricar);
	}
}