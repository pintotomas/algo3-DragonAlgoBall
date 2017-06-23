package vista.eventos;

import dab.personajes.Personaje;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.VistaCaracteristicasPersonaje;

public class BotonTransformarHandler implements EventHandler<MouseEvent>{
	
	Personaje personaje;
	VistaCaracteristicasPersonaje vista;
	
	public BotonTransformarHandler(Personaje personaje, VistaCaracteristicasPersonaje vista){
		this.personaje = personaje;
		this.vista = vista;
	}
	
	
	@Override
	public void handle(MouseEvent event) {
		personaje.transformar();
		vista.dibujar(null);
		vista.dibujar(personaje);
		
	}

}
