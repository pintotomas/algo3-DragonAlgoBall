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
import vista.eventos.BotonComenzarPartidaEventHandler;
import vista.eventos.BotonListoNombreEventHandler;

public class ContenedorNombresUsuarios extends VBox {
    Stage stage;
    private Juego juego;

    public ContenedorNombresUsuarios(Stage stage,Juego juegoDAB) {
        this.stage = stage;
        this.juego = juegoDAB;
        
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        
        VistaTablero tablero = new VistaTablero(stage);
        Scene siguienteEscena = new Scene(tablero);
        
        String textoLabelGuerrerosZ = "Ingrese su nombre. Jugara con Guerreros Z";
        String textoLabelEnemigosDeLaTierra = "Ingrese su nombre. Jugara con Enenemigos De La Tierra";
        
        this.contenedorNombreUsuario(textoLabelGuerrerosZ);
        this.contenedorNombreUsuario(textoLabelEnemigosDeLaTierra);
        
        BotonComenzarPartidaEventHandler comenzarPartida= new BotonComenzarPartidaEventHandler(stage, siguienteEscena);
        Button botonComenzarPartida = new Button("Comenzar partida");
        botonComenzarPartida.setOnMouseClicked(comenzarPartida);
        this.getChildren().addAll(botonComenzarPartida);
        
        
    }
    
    private void contenedorNombreUsuario(String textoLabel){
    	Label labelNombreUsuario = new Label(textoLabel);
        TextField campoNombreUsuario = new TextField();
        Button botonListoNombre = new Button("Listo!");
        HBox contenedorHorizontal = new HBox(botonListoNombre);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        BotonListoNombreEventHandler listoNombreEventHandler = new BotonListoNombreEventHandler(botonListoNombre,this.juego,campoNombreUsuario,textoLabel);
        botonListoNombre.setOnAction(listoNombreEventHandler);
        this.getChildren().addAll(labelNombreUsuario,campoNombreUsuario,contenedorHorizontal);
    }
}