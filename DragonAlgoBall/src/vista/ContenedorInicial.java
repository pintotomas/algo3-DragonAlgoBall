package vista;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import vista.eventos.BotonJugarEventHandler;

public class ContenedorInicial extends StackPane {
    Stage stage;
    private int pixelesAnchoHD;
    private int pixelesAltoHD;
    public ContenedorInicial(Stage stage, Scene proximaEscena, int pixelesAnchoHD, int pixelesAltoHD) {

        this.stage = stage;
        this.pixelesAltoHD = pixelesAltoHD;
        this.pixelesAnchoHD = pixelesAnchoHD;
        
//        String imagen = "vista/Imagenes/inicioDragonAlgoBall.png";
        ImageView imagen = new ImageView(new Image("vista/Imagenes/inicioDragonAlgoBall.png", stage.getWidth(), stage.getHeight(), true, false));
//        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
//        		 new BackgroundSize(stage.getWidth(), stage.getHeight(), true, true, true, true));
//        
        
//        this.setStyle("-fx-background-image: url('" + imagen + "'); " +
//           "-fx-background-position: center center; " +
//           "-fx-background-repeat: stretch;");
//        
        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        
        BotonJugarEventHandler botonJugarHandler = new BotonJugarEventHandler(stage, proximaEscena);
        botonJugar.setOnAction(botonJugarHandler);
		
        this.getChildren().addAll(imagen, botonJugar);
    }
}