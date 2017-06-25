package vista.eventos;

import dab.personajes.Personaje;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import utils.Ajustes;
import utils.reproductorDeSonidos.ReproductorSonidosEspeciales;
import vista.VistaCaracteristicasPersonaje;

public class BotonTransformarHandler implements EventHandler<MouseEvent>{
	
	private Personaje personaje;
	private VistaCaracteristicasPersonaje vista;
	private Ajustes ajustesSonidosEspeciales;
	public BotonTransformarHandler(Personaje personaje, VistaCaracteristicasPersonaje vista, Ajustes ajustesSonidosEspeciales){
		this.personaje = personaje;
		this.vista = vista;
		this.ajustesSonidosEspeciales = ajustesSonidosEspeciales;
	}
	
	
	@Override
	public void handle(MouseEvent event) {
		
		personaje.transformar();
		vista.dibujar(null);
		vista.dibujar(personaje);
		if (ajustesSonidosEspeciales.estaActivo()){
			ReproductorSonidosEspeciales.reproducir("transformar");
		}
		
	}

}
