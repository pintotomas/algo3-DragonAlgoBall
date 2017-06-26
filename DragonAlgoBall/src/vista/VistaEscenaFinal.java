package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Ajustes;
import vista.eventos.CambiarEscenaAlPresionarEventHandler;

public class VistaEscenaFinal extends VBox {
	
		Stage stage;
	public VistaEscenaFinal(Stage stage, Ajustes ajustesMusicaDeBatalla, Ajustes ajustesEfectosDePersonajes, String equipoGanador){
		this.stage = stage;
	    this.setAlignment(Pos.CENTER);
	    this.setSpacing(20);
	    this.setPadding(new Insets(25));
	    
	    Image imagenDeFondo = new Image("vista/Imagenes/ganadorEnemigos.png");
	    if(equipoGanador == "Guerreros Z"){
	    	imagenDeFondo = new Image("vista/Imagenes/ganadorGuerrerosZ.png");
	    }
	 	BackgroundSize size = new BackgroundSize(10, 10, false, false, false, true);
	 	
	 	BackgroundImage vistaImagenDeFondo = new BackgroundImage(imagenDeFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null, size);
	 	this.setBackground(new Background(vistaImagenDeFondo));
	 	Scene proximaEscena = new Scene(new VistaMenuPrincipal(stage, ajustesMusicaDeBatalla, ajustesEfectosDePersonajes));
	 	
	 	HBox botonJugar = new HBox();
	       botonJugar.setPrefSize(50, 23);
	       Image estiloBoton = new Image("vista/Imagenes/start.png");
	       ImageView vistaBotonJugar = new ImageView(estiloBoton);
	       botonJugar.setAlignment(Pos.BOTTOM_CENTER);
	       botonJugar.getChildren().add(vistaBotonJugar);
	 	CambiarEscenaAlPresionarEventHandler botonJugarHandler = new CambiarEscenaAlPresionarEventHandler(stage, proximaEscena);
	    botonJugar.setOnMouseClicked(botonJugarHandler);
	    this.getChildren().addAll(botonJugar);
	

}
}
