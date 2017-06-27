package vista;

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
import vista.eventos.CambiarEscenaAlPresionarEventHandler;
import vista.eventos.OpcionSalirEventHandler;
import vista.menuOpciones.VistaMenuOpciones;

public class VistaMenuPrincipal extends StackPane{
	
	private Stage stage;
	private Ajustes ajustesMusicaDeBatalla;
	private Ajustes ajustesEfectosDePersonajes;
	private Ajustes ajustesMusicaEnding;
	
	public VistaMenuPrincipal(Stage stage, Ajustes ajustesMusicaDeBatalla, Ajustes ajustesEfectosDePersonajes,
			Ajustes ajustesMusicaEnding){
		
		this.ajustesMusicaDeBatalla = ajustesMusicaDeBatalla;
		this.ajustesEfectosDePersonajes = ajustesEfectosDePersonajes;
		this.ajustesMusicaEnding = ajustesMusicaEnding;
		this.stage = stage;
		this.setFondo();
		this.setBotones();
		
	}

	private void setBotones() {
		
		int espaciadoEntreBotones = 40;
		
		
		VBox menu = new VBox(espaciadoEntreBotones);
		
		String estiloTransparente = "-fx-background-color: transparent;";
		Button botonJugar = creadorDeBoton("/resources/imagenes/NuevoJuego.png", estiloTransparente);
		Button botonComoJugar = creadorDeBoton("/resources/imagenes/ComoJugar.png", estiloTransparente);
		Button botonOpciones = creadorDeBoton("/resources/imagenes/Opciones.png", estiloTransparente);
		Button botonSalirDelJuego = creadorDeBoton("/resources/imagenes/salirDelJuego.png", estiloTransparente);
		botonSalirDelJuego.setOnMousePressed(new OpcionSalirEventHandler());
		menu.getChildren().addAll(botonJugar, botonComoJugar, botonOpciones, botonSalirDelJuego);
		
		asignarSiguienteEscenaABoton(botonJugar, new ContenedorNombresUsuarios(stage, ajustesMusicaDeBatalla, ajustesEfectosDePersonajes,
				ajustesMusicaEnding));
		asignarSiguienteEscenaABoton(botonOpciones, new VistaMenuOpciones(stage, ajustesMusicaDeBatalla, ajustesEfectosDePersonajes, ajustesMusicaEnding));  
		asignarSiguienteEscenaABoton(botonComoJugar, new VistaComoJugar(stage, ajustesMusicaDeBatalla, ajustesEfectosDePersonajes, ajustesMusicaEnding));  
	       
        
		this.getChildren().add(menu);
		menu.setAlignment(Pos.CENTER);
	}

	private void setFondo() {
		
		Image fondoMenu = new Image(this.getClass().getResource("/resources/imagenes/fondoMenuPrincipal.png").toExternalForm());
	    ImageView vistaFondoMenu = new ImageView(fondoMenu);
	 
	    vistaFondoMenu.fitWidthProperty().bind(stage.widthProperty());
	    vistaFondoMenu.fitHeightProperty().bind(stage.heightProperty());
		
	    this.getChildren().add(vistaFondoMenu);
	}
	
	private Button creadorDeBoton(String direccionImagen, String style){
		Button nuevoBoton = new Button();
		Image imagen = new Image(direccionImagen);
		nuevoBoton.setGraphic(new ImageView(imagen));
		nuevoBoton.setStyle(style);
		return nuevoBoton;
	}
	
	private void asignarSiguienteEscenaABoton(Button boton, Pane siguienteVista){
		Scene siguienteEscena = new Scene(siguienteVista);
		CambiarEscenaAlPresionarEventHandler event= new CambiarEscenaAlPresionarEventHandler(stage, siguienteEscena);
		boton.setOnMousePressed(event);
	}
}
