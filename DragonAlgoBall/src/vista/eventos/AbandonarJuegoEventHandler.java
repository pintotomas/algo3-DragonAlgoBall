package vista.eventos;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class AbandonarJuegoEventHandler implements EventHandler<MouseEvent> {

	@Override
	public void handle(MouseEvent arg0) {
		
		Alert alertaSalirDelJuego = new Alert(AlertType.CONFIRMATION, "Desea salir del juego? Se perdera el progreso de la partida!",
				ButtonType.YES, ButtonType.NO);
		alertaSalirDelJuego.showAndWait();	
		
		if (alertaSalirDelJuego.getResult().equals(ButtonType.YES)){
			System.exit(1);
		}
		
	}

}
