package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Ajustes;
import utils.reproductorDeSonidos.ReproductorDeSonidos;
import vista.eventos.CambiarEscenaAlPresionarEventHandler;
import vista.eventos.ComenzarPartidaEventHandler;

public class ContenedorNombresUsuarios extends VBox {
    Stage stage;

    public ContenedorNombresUsuarios(Stage stage, Ajustes ajustesMusicaDeBatalla, Ajustes ajustesEfectosDePersonajes) {
        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        
        String textoLabelGuerrerosZ = "Ingrese su nombre. Jugara con Guerreros Z";
        String textoLabelEnemigosDeLaTierra = "Ingrese su nombre. Jugara con Enenemigos De La Tierra";
        

        TextField campoNombreUsuarioGuerreros = this.contenedorNombreUsuario(textoLabelGuerrerosZ);
        TextField campoNombreUsuarioEnemigos = this.contenedorNombreUsuario(textoLabelEnemigosDeLaTierra);
      
        Button botonListoNombres = new Button("Comenzar partida!");
        
        ReproductorDeSonidos reproductorMusicaDeBatalla = new ReproductorDeSonidos("/vista/sonidos/musicaPelea.wav");
        ContenedorPrincipal principal= new ContenedorPrincipal(stage, campoNombreUsuarioGuerreros,
        		campoNombreUsuarioEnemigos, ajustesMusicaDeBatalla, ajustesEfectosDePersonajes, reproductorMusicaDeBatalla);
        Scene escenaPrincipal = new Scene(principal);
        CambiarEscenaAlPresionarEventHandler listoNombreEventHandler = new ComenzarPartidaEventHandler(this.stage, escenaPrincipal, ajustesMusicaDeBatalla,
        		reproductorMusicaDeBatalla);
        botonListoNombres.setOnMousePressed(listoNombreEventHandler);
        this.getChildren().addAll(botonListoNombres);   
    } 
    
    private TextField contenedorNombreUsuario(String textoLabel){
    	Label labelNombreUsuario = new Label(textoLabel);
        TextField campoNombreUsuario = new TextField();
        this.getChildren().addAll(labelNombreUsuario,campoNombreUsuario);
        return campoNombreUsuario;
    }
}