package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Ajustes;
import vista.eventos.botonNombresIngresadosEventHandler;

public class ContenedorNombresUsuarios extends VBox {
    Stage stage;

    public ContenedorNombresUsuarios(Stage stage, Ajustes ajustesMusicaDeBatalla, Ajustes ajustesEfectosDePersonajes,
    		Ajustes ajustesMusicaEnding) {
        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        
        
    	Image imagenDeFondo = new Image(this.getClass().getResource("/resources/imagenes/ImagenIngresoNombres.png").toExternalForm());
    	
    	BackgroundSize size = new BackgroundSize(1, 1, false, false, false, true);
    	
        BackgroundImage vistaImagenDeFondo = new BackgroundImage(imagenDeFondo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, null, size);
        this.setBackground(new Background(vistaImagenDeFondo));

        String textoLabelGuerrerosZ = "/resources/imagenes/nombreGuerrerosZ.png";
        String textoLabelEnemigosDeLaTierra = "/resources/imagenes/nombreEnemigosDeLaTierra.png";

        TextField campoNombreUsuarioGuerreros = this.contenedorNombreUsuario(textoLabelGuerrerosZ);
        TextField campoNombreUsuarioEnemigos = this.contenedorNombreUsuario(textoLabelEnemigosDeLaTierra);
      
        Button botonListoNombres = new Button("Comenzar partida!");
        botonListoNombres.setOnMousePressed(new botonNombresIngresadosEventHandler(stage, campoNombreUsuarioGuerreros, campoNombreUsuarioEnemigos,
        		 ajustesMusicaDeBatalla, ajustesEfectosDePersonajes, ajustesMusicaEnding));

        this.getChildren().addAll(botonListoNombres);   
    } 
    
    private TextField contenedorNombreUsuario(String textoLabel){
    	Label labelNombreUsuario = new Label();
    	Image imagen = new Image(this.getClass().getResource(textoLabel).toExternalForm());
    	labelNombreUsuario.setGraphic(new ImageView(imagen));
        TextField campoNombreUsuario = new TextField();
        campoNombreUsuario.setMaxWidth(300);
        campoNombreUsuario.setMinHeight(20);
        this.getChildren().addAll(labelNombreUsuario,campoNombreUsuario);
        return campoNombreUsuario;
    }
}