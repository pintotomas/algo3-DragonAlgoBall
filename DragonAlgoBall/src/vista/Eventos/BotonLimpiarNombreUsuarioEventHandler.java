package vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BotonLimpiarNombreUsuarioEventHandler implements EventHandler<ActionEvent> {
    Stage stage;

    public BotonLimpiarNombreUsuarioEventHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // borrar texto del textField
    }
}