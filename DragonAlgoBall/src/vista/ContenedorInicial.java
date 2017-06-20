package vista;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
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

    public ContenedorInicial(Stage stage, Scene proximaEscena) {

        this.stage = stage;

        Image imagen = new Image("vista/Imagenes/inicioDragonAlgoBall.png", 1400, 800, false, true);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
        
        
        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        
        BotonJugarEventHandler botonJugarHandler = new BotonJugarEventHandler(stage, proximaEscena);
        botonJugar.setOnAction(botonJugarHandler);
		
        this.getChildren().add(botonJugar);
    }
}