package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vista.eventos.BotonComenzarPartidaEventHandler;

public class ContenedorNombresUsuarios extends VBox {
    Stage stage;

    public ContenedorNombresUsuarios(Stage stage) {
        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        
        String textoLabelGuerrerosZ = "Ingrese su nombre. Jugara con Guerreros Z";
        String textoLabelEnemigosDeLaTierra = "Ingrese su nombre. Jugara con Enenemigos De La Tierra";
        

        TextField campoNombreUsuarioGuerreros = this.contenedorNombreUsuario(textoLabelGuerrerosZ);
        TextField campoNombreUsuarioEnemigos = this.contenedorNombreUsuario(textoLabelEnemigosDeLaTierra);
        
        Button botonListoNombres = new Button("Comenzar partida!");
        BotonComenzarPartidaEventHandler listoNombreEventHandler = new BotonComenzarPartidaEventHandler(this.stage,campoNombreUsuarioGuerreros,campoNombreUsuarioEnemigos);
        botonListoNombres.setOnAction(listoNombreEventHandler);
        this.getChildren().addAll(botonListoNombres);
    }
    
    private TextField contenedorNombreUsuario(String textoLabel){
    	Label labelNombreUsuario = new Label(textoLabel);
        TextField campoNombreUsuario = new TextField();
        this.getChildren().addAll(labelNombreUsuario,campoNombreUsuario);
        return campoNombreUsuario;
    }
}