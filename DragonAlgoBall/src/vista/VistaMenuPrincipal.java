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
import vista.eventos.CambiarEscenaAlPresionarEventHandler;

public class VistaMenuPrincipal extends StackPane{
	
	private Stage stage;
	
	public VistaMenuPrincipal(Stage stage){
		
		this.stage = stage;
		this.setFondo();
		this.setBotones();
		
	}

	private void setBotones() {
		
		int espaciadoEntreBotones = 40;
		
		
		VBox menu = new VBox(espaciadoEntreBotones);
		
		String estiloTransparente = "-fx-background-color: transparent;";
		Button botonJugar = creadorDeBoton("vista/Imagenes/NuevoJuego.png", estiloTransparente);
		Button botonComoJugar = creadorDeBoton("vista/Imagenes/ComoJugar.png", estiloTransparente);
		Button botonOpciones = creadorDeBoton("vista/Imagenes/Opciones.png", estiloTransparente);
		Button botonCreditos = creadorDeBoton("vista/Imagenes/Creditos.png", estiloTransparente);
		
		menu.getChildren().addAll(botonJugar, botonComoJugar, botonOpciones, botonCreditos);
		
		asignarSiguienteEscenaABoton(botonJugar, new ContenedorNombresUsuarios(stage));
		asignarSiguienteEscenaABoton(botonOpciones, new VistaMenuOpciones(stage, this));  
        
        
		this.getChildren().add(menu);
		menu.setAlignment(Pos.CENTER);
	}

	private void setFondo() {
		
		Image fondoMenu = new Image("vista/Imagenes/fondoMenuPrincipal.png");
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
