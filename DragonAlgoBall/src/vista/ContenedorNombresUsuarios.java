package vista;

import dab.juego.Juego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vista.Eventos.BotonListoNombreEventHandler;

public class ContenedorNombresUsuarios extends VBox {
    Stage stage;
    Scene escenaPrincipal;
    private Juego juego;

    public ContenedorNombresUsuarios(Stage stage,Juego juegoDAB, Scene escenaPrincipal) {
        this.stage = stage;
        this.juego = juegoDAB;
        this.escenaPrincipal = escenaPrincipal;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        
        String textoLabelGuerrerosZ = "Ingrese su nombre. Jugara con Guerreros Z";
        String textoLabelEnemigosDeLaTierra = "Ingrese su nombre. Jugara con Enenemigos De La Tierra";
        
        TextField campoNombreUsuarioGuerreros = this.contenedorNombreUsuario(textoLabelGuerrerosZ);
        TextField campoNombreUsuarioEnemigos = this.contenedorNombreUsuario(textoLabelEnemigosDeLaTierra);
        Button botonListoNombre = new Button("Listo!");
        HBox contenedorHorizontal = new HBox(botonListoNombre);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        BotonListoNombreEventHandler listoNombreEventHandler = new BotonListoNombreEventHandler(this.stage,this.escenaPrincipal,this.juego,campoNombreUsuarioGuerreros,campoNombreUsuarioEnemigos);
        botonListoNombre.setOnAction(listoNombreEventHandler);
        this.getChildren().add(contenedorHorizontal);
    }
    
    private TextField contenedorNombreUsuario(String textoLabel){
    	Label labelNombreUsuario = new Label(textoLabel);
        TextField campoNombreUsuario = new TextField();
        this.getChildren().addAll(labelNombreUsuario,campoNombreUsuario);
        return campoNombreUsuario;
    }
}