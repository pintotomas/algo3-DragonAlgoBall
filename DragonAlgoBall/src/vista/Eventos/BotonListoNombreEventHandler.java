package vista.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BotonListoNombreEventHandler implements EventHandler<ActionEvent>{
	private TextField campoNombre;
	private Button botonListoNombre;
	
	public BotonListoNombreEventHandler(Button boton,TextField textField){
		this.botonListoNombre = boton;
		this.campoNombre = textField;
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.botonListoNombre.setDisable(true);
		this.botonListoNombre.setText("Esperando al enemigo..");
	}
}
