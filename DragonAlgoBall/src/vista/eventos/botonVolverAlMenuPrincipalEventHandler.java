package vista.eventos;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import vista.VistaMenuPrincipal;

public class botonVolverAlMenuPrincipalEventHandler implements EventHandler<MouseEvent>{

	private StackPane vuelta;
	private Stage stage;
	private Button botonPresionado;

	public botonVolverAlMenuPrincipalEventHandler(Button botonPresionado, StackPane vuelta, Stage stage){
		
		this.vuelta = vuelta;
		this.stage = stage;
		this.botonPresionado = botonPresionado;
	}
	
	@Override
	public void handle(MouseEvent arg0) {
		try {
			botonPresionado.getScene().setRoot(vuelta.getClass().newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
