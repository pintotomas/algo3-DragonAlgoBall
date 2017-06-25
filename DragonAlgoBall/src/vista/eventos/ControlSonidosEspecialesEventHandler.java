package vista.eventos;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import utils.Ajustes;

public class ControlSonidosEspecialesEventHandler implements EventHandler<MouseEvent> {

	Ajustes ajusteSonidosEspeciales;
	
	public ControlSonidosEspecialesEventHandler(Ajustes ajusteSonidosEspeciales) {
		this.ajusteSonidosEspeciales = ajusteSonidosEspeciales;
	}

	@Override
	public void handle(MouseEvent arg0) {
		ajusteSonidosEspeciales.cambiar();
		System.out.println(ajusteSonidosEspeciales.estaActivo());
	}

}
