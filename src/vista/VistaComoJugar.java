package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.Ajustes;

public class VistaComoJugar extends StackPane {
	
	private Stage stage;
	private Ajustes ajustesMusicaDeBatalla;
	private Ajustes ajustesEfectosDePersonajes;
	private Ajustes ajustesMusicaEnding;
	
	public VistaComoJugar(Stage stage, Ajustes ajustesMusicaDeBatalla, Ajustes ajustesEfectosDePersonajes, Ajustes ajustesMusicaEnding) {
		
		this.stage = stage;
		this.ajustesMusicaDeBatalla = ajustesMusicaDeBatalla;
		this.ajustesEfectosDePersonajes = ajustesEfectosDePersonajes;
		this.ajustesMusicaEnding = ajustesMusicaEnding;
		this.setFondo();
		this.setOpciones();

	}

	private void setOpciones() {
		
		String estiloTransparente = "-fx-background-color: transparent;";
		Button botonVolver = creadorDeBoton("/resources/imagenes/volverAlMenuPrincipal.png", estiloTransparente);
		botonVolver.setOnAction(new EventHandler<ActionEvent>() {
	        
            @Override
            public void handle(ActionEvent arg0) {
                botonVolver.getScene().setRoot(new VistaMenuPrincipal(stage, ajustesMusicaDeBatalla, ajustesEfectosDePersonajes, ajustesMusicaEnding));             
            }
        });
		
		this.getChildren().add(botonVolver);
		StackPane.setAlignment(botonVolver, Pos.BOTTOM_LEFT);
		
		}

	private void setFondo() {
		
		Image fondoOpciones = new Image(this.getClass().getResource("/resources/imagenes/instruccionesComoJugar.jpg").toExternalForm());
	    ImageView vistaFondoOpciones = new ImageView(fondoOpciones);
	 
	    vistaFondoOpciones.fitWidthProperty().bind(stage.widthProperty());
	    vistaFondoOpciones.fitHeightProperty().bind(stage.heightProperty());
		
	    this.getChildren().add(vistaFondoOpciones);
	}

	private Button creadorDeBoton(String direccionImagen, String style){
		Button nuevoBoton = new Button();
		Image imagen = new Image(direccionImagen);
		nuevoBoton.setGraphic(new ImageView(imagen));
		nuevoBoton.setStyle(style);
		return nuevoBoton;
	}
	
}
