package vista.eventos;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CambiarEscenaAlPresionarEventHandler implements EventHandler<MouseEvent> {
    Stage stage;
    Scene proximaEscena;

    public CambiarEscenaAlPresionarEventHandler(Stage stage, Scene proximaEscena) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(MouseEvent actionEvent) {
    
    	
        stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
    }
}