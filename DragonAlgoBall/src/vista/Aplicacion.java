package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Ajustes;
import utils.reproductorDeSonidos.ReproductorDeSonidos;

public class Aplicacion extends Application {
	private int pixelesAnchoHD = 1360;
    private int pixelesAltoHD = 768;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Dragon AlgoBall Z");
        
//        ContenedorNombresUsuarios contenedorNombresUsuarios = new ContenedorNombresUsuarios(stage);
//        Scene escenaNombresUsuarios = new Scene(contenedorNombresUsuarios);
//        
//        ReproductorDeSonidos repr = new ReproductorDeSonidos("/vista/sonidos/opening/DBZOpening.wav");
//        Thread thread = new Thread(repr);
//        thread.setDaemon(true);
//        thread.start();
//        
        Ajustes ajustesMusicaDeBatalla = new Ajustes("Musica de batalla", true);
        Ajustes ajustesEfectosDePersonajes = new Ajustes("Efectos de personajes", true);
        VistaMenuPrincipal menuPrincipal = new VistaMenuPrincipal(stage, ajustesMusicaDeBatalla, ajustesEfectosDePersonajes);
        Scene escenaMenuPrincipal = new Scene(menuPrincipal);
        
//       ContenedorInicial contenedorInicial = new ContenedorInicial(stage, escenaNombresUsuarios, pixelesAnchoHD, pixelesAltoHD);
        ContenedorInicial contenedorInicial = new ContenedorInicial(stage, escenaMenuPrincipal);
        Scene escenaInicial = new Scene(contenedorInicial, pixelesAnchoHD, pixelesAltoHD);
		escenaInicial.getStylesheets().add("vista/style.css");
        stage.setScene(escenaInicial);
        stage.setFullScreen(true);
        stage.show();
    }
}