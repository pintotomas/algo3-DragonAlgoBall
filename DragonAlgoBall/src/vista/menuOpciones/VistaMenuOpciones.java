package vista.menuOpciones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Ajustes;
import vista.VistaMenuPrincipal;

public class VistaMenuOpciones extends StackPane {
	
	private Stage stage;
	private Ajustes ajustesMusicaDeBatalla;
	private Ajustes ajustesEfectosDePersonajes;
	private Ajustes ajustesMusicaEnding;
	
	public VistaMenuOpciones(Stage stage, Ajustes ajustesMusicaDeBatalla, Ajustes ajustesEfectosDePersonajes, Ajustes ajustesMusicaEnding) {
		
		this.stage = stage;
		this.ajustesMusicaDeBatalla = ajustesMusicaDeBatalla;
		this.ajustesEfectosDePersonajes = ajustesEfectosDePersonajes;
		this.ajustesMusicaEnding = ajustesMusicaEnding;
		this.setFondo();
		this.setOpciones();
		
		
	}

	private void setOpciones() {
		int espaciadoEntreBotones = 40;
		VBox opciones = new VBox(espaciadoEntreBotones);
		String estiloTransparente = "-fx-background-color: transparent;";
		Button botonVolver = creadorDeBoton("/vista/Imagenes/volverAlMenuPrincipal.png", estiloTransparente);
		botonVolver.setOnAction(new EventHandler<ActionEvent>() {
	        
            @Override
            public void handle(ActionEvent arg0) {
                botonVolver.getScene().setRoot(new VistaMenuPrincipal(stage, ajustesMusicaDeBatalla, ajustesEfectosDePersonajes, ajustesMusicaEnding));             
            }
        });
		
		//En el futuro recibira dos parametros: Si esta activada o no
//		VistaOpcion opcionMusicaDeFondo = new VistaOpcion("vista/Imagenes/Musica.png", true);
		
		VistaOpcion opcionMusicaDeBatalla = new VistaOpcion("/vista/Imagenes/MusicaDeBatalla.png", ajustesMusicaDeBatalla.estaActivo(), ajustesMusicaDeBatalla);
		VistaOpcion opcionSonidosDePersonaje = new VistaOpcion("/vista/Imagenes/SonidosPersonajes.png", ajustesEfectosDePersonajes.estaActivo(), ajustesEfectosDePersonajes);
		VistaOpcion opcionMusicaEnding = new VistaOpcion("/vista/Imagenes/musicaEnding.png", ajustesMusicaEnding.estaActivo(), ajustesMusicaEnding);
		opciones.getChildren().addAll(opcionMusicaDeBatalla, opcionSonidosDePersonaje, opcionMusicaEnding, botonVolver);
		this.getChildren().addAll(opciones);
		opciones.setAlignment(Pos.CENTER_RIGHT);
		
		
		}

	

	private void setFondo() {
		
		Image fondoOpciones = new Image(this.getClass().getResource("/vista/Imagenes/fondoOpciones.png").toExternalForm());
	    ImageView vistaFondoOpciones = new ImageView(fondoOpciones);
	 
	    vistaFondoOpciones.fitWidthProperty().bind(stage.widthProperty());
	    vistaFondoOpciones.fitHeightProperty().bind(stage.heightProperty());
		
	    this.getChildren().add(vistaFondoOpciones);
	}
	
//	private void asignarSiguienteEscenaABoton(Button boton, Pane siguienteVista){
//		
//		Scene siguienteEscena = new Scene(siguienteVista);
//		CambiarEscenaAlPresionarEventHandler event= new CambiarEscenaAlPresionarEventHandler(stage, siguienteEscena);
//		boton.setOnMousePressed(event);
//	}
//	

	private Button creadorDeBoton(String direccionImagen, String style){
		Button nuevoBoton = new Button();
		Image imagen = new Image(direccionImagen);
		nuevoBoton.setGraphic(new ImageView(imagen));
		nuevoBoton.setStyle(style);
		return nuevoBoton;
	}
	
}
