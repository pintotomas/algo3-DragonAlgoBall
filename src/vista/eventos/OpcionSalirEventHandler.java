package vista.eventos;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class OpcionSalirEventHandler implements EventHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent event) {
		// TODO Auto-generated method stub
		System.exit(1);
	}
}