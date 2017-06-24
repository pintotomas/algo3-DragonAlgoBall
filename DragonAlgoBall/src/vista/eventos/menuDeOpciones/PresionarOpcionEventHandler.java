package vista.eventos.menuDeOpciones;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.menuOpciones.VistaOpcion;

public class PresionarOpcionEventHandler implements EventHandler<MouseEvent> {
	
	private VistaOpcion vistaOpcion;
	
	public PresionarOpcionEventHandler(VistaOpcion vistaOpcion) {
		this.vistaOpcion = vistaOpcion;
	}


	@Override
	public void handle(MouseEvent arg0) {
		vistaOpcion.press();
	}

}
