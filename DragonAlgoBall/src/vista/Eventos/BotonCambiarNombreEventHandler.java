package vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BotonCambiarNombreEventHandler implements EventHandler<ActionEvent>{
	private TextField textField;
	private Button botonListoNombre;
	
    public BotonCambiarNombreEventHandler(TextField textField,Button listoNombre) {
        this.textField = textField;
        this.botonListoNombre = listoNombre;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.textField.requestFocus();
        if(this.botonListoNombre.isDisable()){
        	this.botonListoNombre.setDisable(false);
        }
    }
}


