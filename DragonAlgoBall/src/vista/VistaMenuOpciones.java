package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vista.eventos.CambiarEscenaAlPresionarEventHandler;

public class VistaMenuOpciones extends Pane {
	
	private Stage stage;
	private VistaMenuPrincipal retorno;
	
	public VistaMenuOpciones(Stage stage, VistaMenuPrincipal vistaMenuPrincipal) {
		
		this.stage = stage;
		this.retorno = vistaMenuPrincipal;
		this.setFondo();
		this.setBotones();
		
		
	}

	private void setBotones() {
		String estiloTransparente = "-fx-background-color: transparent;";
		Button botonVolver = creadorDeBoton("vista/Imagenes/volverAlMenuPrincipal.png", estiloTransparente);
		botonVolver.setOnAction(new EventHandler<ActionEvent>() {
	        
            @Override
            public void handle(ActionEvent arg0) {
                botonVolver.getScene().setRoot(retorno);             
            }
        });
		this.getChildren().add(botonVolver);
		}

	private void setFondo() {
		
		Image fondoOpciones = new Image("vista/Imagenes/fondoOpciones.png");
	    ImageView vistaFondoOpciones = new ImageView(fondoOpciones);
	 
	    vistaFondoOpciones.fitWidthProperty().bind(stage.widthProperty());
	    vistaFondoOpciones.fitHeightProperty().bind(stage.heightProperty());
		
	    this.getChildren().add(vistaFondoOpciones);
	}
	
	private void asignarSiguienteEscenaABoton(Button boton, Pane siguienteVista){
		
		Scene siguienteEscena = new Scene(siguienteVista);
		CambiarEscenaAlPresionarEventHandler event= new CambiarEscenaAlPresionarEventHandler(stage, siguienteEscena);
		boton.setOnMousePressed(event);
	}
	

	private Button creadorDeBoton(String direccionImagen, String style){
		Button nuevoBoton = new Button();
		Image imagen = new Image(direccionImagen);
		nuevoBoton.setGraphic(new ImageView(imagen));
		nuevoBoton.setStyle(style);
		return nuevoBoton;
	}
	
}
