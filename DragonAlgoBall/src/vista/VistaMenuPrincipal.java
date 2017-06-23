package vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vista.eventos.ComenzarJuegoEventHandler;

public class VistaMenuPrincipal extends StackPane{
	
	private Stage stage;
	
	public VistaMenuPrincipal(Stage stage){
		
		this.stage = stage;
		this.setFondo();
		this.setBotones();
		
	}

	private void setBotones() {
		
		int espaciadoEntreBotones = 40;
		String estiloTransparente = "-fx-background-color: transparent;";
		
		Button botonJugar = creadorDeBoton("vista/Imagenes/NuevoJuego.png", estiloTransparente);
		Button botonComoJugar = creadorDeBoton("vista/Imagenes/ComoJugar.png", estiloTransparente);
		Button botonOpciones = creadorDeBoton("vista/Imagenes/Opciones.png", estiloTransparente);
		Button botonCreditos = creadorDeBoton("vista/Imagenes/Creditos.png", estiloTransparente);
		
		
		VBox menu = new VBox(espaciadoEntreBotones);
		menu.getChildren().addAll(botonJugar, botonComoJugar, botonOpciones, botonCreditos);
		ContenedorNombresUsuarios vistaPedirNombres = new ContenedorNombresUsuarios(stage);
		Scene escenaPedirNombres = new Scene(vistaPedirNombres);
		ComenzarJuegoEventHandler botonJugarHandler = new ComenzarJuegoEventHandler(stage, escenaPedirNombres);
        botonJugar.setOnMouseClicked(botonJugarHandler);
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
		nuevoBoton.setStyle("-fx-background-color: transparent;");
		return nuevoBoton;
	}
}
