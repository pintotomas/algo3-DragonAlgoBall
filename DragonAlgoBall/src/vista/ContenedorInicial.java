package vista;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ContenedorInicial extends StackPane {
    Stage stage;

    public ContenedorInicial(Stage stage/*, Scene proximaEscena*/) {

        this.stage = stage;

        Image imagen = new Image("file:src/vista/Imagenes/inicioDragonAlgoBall.png");
        BackgroundImage backgroundFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT, null, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        this.setBackground(new Background(backgroundFondo));

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        /*
        BotonJugarEventHandler botonJugarHandler = new BotonJugarEventHandler(stage, proximaEscena);
        botonJugar.setOnAction(botonJugarHandler);
		*/
        this.getChildren().add(botonJugar);
    }
}