package vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonEnviarNombreUsuarioEventHandler implements EventHandler<ActionEvent> {
    Stage stage;

    public BotonEnviarNombreUsuarioEventHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // le dice al controlador que haga setNombreUsuario
    }
}