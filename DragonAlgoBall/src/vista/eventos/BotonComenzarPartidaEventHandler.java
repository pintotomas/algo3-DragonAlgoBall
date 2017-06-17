package vista.eventos;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BotonComenzarPartidaEventHandler implements EventHandler<MouseEvent> {

	
	Stage stage;
	Scene proximaEscena;

    public BotonComenzarPartidaEventHandler(Stage stage, Scene proximaEscena) {
    	this.stage = stage;
	    this.proximaEscena = proximaEscena;
    }

	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
		stage.setScene(proximaEscena);
	    stage.setFullScreenExitHint("");
	    stage.setFullScreen(true);
	}
	
}
	

