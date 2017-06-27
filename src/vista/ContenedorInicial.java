package vista;



import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;
import vista.eventos.CambiarEscenaAlPresionarEventHandler;

public class ContenedorInicial extends StackPane {
    Stage stage;

    public ContenedorInicial(Stage stage, Scene proximaEscena) {
        this.stage = stage;

	
     	Image fondoPrincipal = new Image(this.getClass().getResource("/resources/imagenes/inicioDragonAlgoBall.png").toExternalForm());

        ImageView vistaFondoPrincipal = new ImageView(fondoPrincipal);
        vistaFondoPrincipal.fitWidthProperty().bind(stage.widthProperty());
        vistaFondoPrincipal.fitHeightProperty().bind(stage.heightProperty());
      
        HBox botonJugar = new HBox();
        botonJugar.setPrefSize(50, 23);
        Image estiloBoton = new Image(this.getClass().getResource("/resources/imagenes/start.png").toExternalForm());
        ImageView vistaBotonJugar = new ImageView(estiloBoton);
        botonJugar.setAlignment(Pos.BOTTOM_CENTER);
        botonJugar.getChildren().add(vistaBotonJugar);

        CambiarEscenaAlPresionarEventHandler botonJugarHandler = new CambiarEscenaAlPresionarEventHandler(stage, proximaEscena);
        botonJugar.setOnMouseClicked(botonJugarHandler);
        
        
        this.getChildren().addAll(vistaFondoPrincipal, botonJugar);
        
    }
}