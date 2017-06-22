package vista.eventos;

import dab.personajes.Personaje;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.VistaCaracteristicasPersonaje;
import vista.vistasCelda.VistaCelda;

public class BotonPersonajeInferiorHandler implements EventHandler<MouseEvent> {

	VistaCaracteristicasPersonaje vista;
	VistaCelda[][] vistaCeldas;
	public BotonPersonajeInferiorHandler(VistaCaracteristicasPersonaje vista, VistaCelda[][] vistaCeldas){
		this.vista = vista;
		this.vistaCeldas = vistaCeldas;
	}
	
	
	
	@Override
	public void handle(MouseEvent event) {
		Personaje personaje = vista.getPersonaje();
		VistaCelda celda = vistaCeldas[personaje.getPosicion().getFila()][personaje.getPosicion().getColumna()];
		celda.getOnMousePressed().handle(event);
	}





}
