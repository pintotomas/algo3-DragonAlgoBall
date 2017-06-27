package vista.menuOpciones;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import utils.Ajustes;
import vista.eventos.menuDeOpciones.PresionarOpcionEventHandler;

public class VistaOpcion extends HBox{
	
	private Label labelDeLaOpcion;
	private boolean activada;
	private Button botonDeActivado;
	private Ajustes ajusteAModificar;
	public VistaOpcion(String rutaImagenDeLaOpcion, boolean activada, Ajustes ajusteAModificar) {
		
		String estiloTransparente = "-fx-background-color: transparent;";
		Label nombreDeLaOpcion = new Label();
		Image imagen = new Image(this.getClass().getResourceAsStream(rutaImagenDeLaOpcion));
		nombreDeLaOpcion.setGraphic(new ImageView(imagen));
		nombreDeLaOpcion.setStyle(estiloTransparente);
		this.labelDeLaOpcion = nombreDeLaOpcion;
		this.activada = activada;
		botonDeActivado = new Button();
		configurarBotonDeActivado(botonDeActivado);
		botonDeActivado.setStyle(estiloTransparente);
		botonDeActivado.setOnMousePressed(new PresionarOpcionEventHandler(this));
		this.getChildren().addAll(nombreDeLaOpcion, botonDeActivado);
		this.ajusteAModificar = ajusteAModificar;
		
	}
	
	public Label getLabel(){
		return labelDeLaOpcion;
	}
	
	private void configurarBotonDeActivado(Button eleccion){
		String ruta;
		if (activada){
			ruta = "/resources/imagenes/OpcionActivada.png";
		}
		else{
			ruta = "/resources/imagenes/OpcionDesactivada.png";
		}
		Image opcionEscogida = new Image(this.getClass().getResource(ruta).toExternalForm());
		eleccion.setGraphic(new ImageView(opcionEscogida));
	}
	
	public void press(){
		activada = !activada;
		this.configurarBotonDeActivado(botonDeActivado);
		ajusteAModificar.cambiar();
	}
}
