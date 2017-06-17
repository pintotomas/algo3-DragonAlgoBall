package vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("Dragon AlgoBall Z");
        String mensaje = "Creadores: Tomas Pinto, Santiago Alvarez Julia, Joaquin , Agustin";
        alert.setContentText(mensaje);
        alert.show();
    }
}
