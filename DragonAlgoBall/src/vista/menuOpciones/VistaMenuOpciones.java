package vista.menuOpciones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Ajustes;
import vista.VistaMenuPrincipal;
import vista.eventos.CambiarEscenaAlPresionarEventHandler;

public class VistaMenuOpciones extends StackPane {
	
	private Stage stage;
	private Ajustes ajustesMusicaDeBatalla;
	private Ajustes ajustesEfectosDePersonajes;
	
	public VistaMenuOpciones(Stage stage, Ajustes ajustesMusicaDeBatalla, Ajustes ajustesEfectosDePersonajes) {
		
		this.stage = stage;
		this.ajustesMusicaDeBatalla = ajustesMusicaDeBatalla;
		this.ajustesEfectosDePersonajes = ajustesEfectosDePersonajes;
		this.setFondo();
		this.setOpciones();
		
		
	}

	private void setOpciones() {
		int espaciadoEntreBotones = 40;
		VBox opciones = new VBox(espaciadoEntreBotones);
		String estiloTransparente = "-fx-background-color: transparent;";
		Button botonVolver = creadorDeBoton("vista/Imagenes/volverAlMenuPrincipal.png", estiloTransparente);
		botonVolver.setOnAction(new EventHandler<ActionEvent>() {
	        
            @Override
            public void handle(ActionEvent arg0) {
                botonVolver.getScene().setRoot(new VistaMenuPrincipal(stage, ajustesMusicaDeBatalla, ajustesEfectosDePersonajes));             
            }
        });
		
		//En el futuro recibira dos parametros: Si esta activada o no
//		VistaOpcion opcionMusicaDeFondo = new VistaOpcion("vista/Imagenes/Musica.png", true);
		
		VistaOpcion opcionMusicaDeBatalla = new VistaOpcion("vista/Imagenes/MusicaDeBatalla.png", ajustesMusicaDeBatalla.estaActivo(), ajustesMusicaDeBatalla);
		VistaOpcion opcionSonidosDePersonaje = new VistaOpcion("vista/Imagenes/SonidosPersonajes.png", ajustesEfectosDePersonajes.estaActivo(), ajustesEfectosDePersonajes);
//		opciones.getChildren().addAll(opcionMusicaDeFondo, opcionMusicaDeBatalla, opcionSonidosDePersonaje, botonVolver);
		opciones.getChildren().addAll(opcionMusicaDeBatalla, opcionSonidosDePersonaje, botonVolver);
		this.getChildren().addAll(opciones);
		opciones.setAlignment(Pos.CENTER_RIGHT);
		
		
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
