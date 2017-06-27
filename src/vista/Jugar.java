package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Ajustes;

public class Jugar extends Application {
	private int pixelesAnchoHD = 1360;
    private int pixelesAltoHD = 768;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Dragon AlgoBall Z");
        

        Ajustes ajustesMusicaDeBatalla = new Ajustes("Musica de batalla", true);
        Ajustes ajustesEfectosDePersonajes = new Ajustes("Efectos de personajes", true);
        Ajustes ajustesMusicaEnding = new Ajustes("Musica ending", true);
        VistaMenuPrincipal menuPrincipal = new VistaMenuPrincipal(stage, ajustesMusicaDeBatalla, ajustesEfectosDePersonajes, ajustesMusicaEnding);
        Scene escenaMenuPrincipal = new Scene(menuPrincipal);
        
        ContenedorInicial contenedorInicial = new ContenedorInicial(stage, escenaMenuPrincipal);
        Scene escenaInicial = new Scene(contenedorInicial, pixelesAnchoHD, pixelesAltoHD);
		escenaInicial.getStylesheets().add("/vista/style.css");
        stage.setScene(escenaInicial);
        stage.setFullScreen(true);
        stage.show();
    }
}