package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vista.Eventos.BotonCambiarNombreEventHandler;
import vista.Eventos.BotonListoNombreEventHandler;

public class ContenedorNombresUsuarios extends VBox {
    Stage stage;

    public ContenedorNombresUsuarios(Stage stage/*, Scene proximaEscena*/) {
        this.stage = stage;
        
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        
        String textoLabelGuerrerosZ = "Ingrese su nombre. Jugara con Guerreros Z";
        String textoLabelEnemigosDeLaTierra = "Ingrese su nombre. Jugara con Enenemigos De La Tierra";
        
        this.contenedorNombreUsuario(textoLabelGuerrerosZ);
        this.contenedorNombreUsuario(textoLabelEnemigosDeLaTierra);
    }
    
    private void contenedorNombreUsuario(String textoLabel){
    	Label labelNombreUsuario = new Label(textoLabel);
        TextField campoNombreUsuario = new TextField();
        Button botonListoNombre = new Button("Listo!");
        Button botonReiniciarNombre = new Button("Cambiar Nombre");
        HBox contenedorHorizontal = new HBox(botonListoNombre,botonReiniciarNombre);
        contenedorHorizontal.setSpacing(10);
        BotonCambiarNombreEventHandler reiniciarNombreEventHandler = new BotonCambiarNombreEventHandler(campoNombreUsuario,botonListoNombre);
        botonReiniciarNombre.setOnAction(reiniciarNombreEventHandler);
        BotonListoNombreEventHandler listoNombreEventHandler = new BotonListoNombreEventHandler(botonListoNombre,campoNombreUsuario);
        botonListoNombre.setOnAction(listoNombreEventHandler);
        this.getChildren().addAll(labelNombreUsuario,campoNombreUsuario,contenedorHorizontal);
    }
}