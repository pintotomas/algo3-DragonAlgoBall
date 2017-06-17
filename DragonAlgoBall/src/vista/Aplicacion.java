package vista;

import dab.juego.Juego;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacion extends Application {
	private final int pixelesAnchoSD = 640;
    private final int pixelesAltoSD = 480;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Dragon AlgoBall Z");
        
        Juego juegoDAB = new Juego();
        
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage,juegoDAB);
        Scene escenaPrincipal = new Scene(contenedorPrincipal);
        
        ContenedorNombresUsuarios contenedorNombresUsuarios = new ContenedorNombresUsuarios(stage,juegoDAB,escenaPrincipal);
        Scene escenaNombresUsuarios = new Scene(contenedorNombresUsuarios);
        
        ContenedorInicial contenedorInicial = new ContenedorInicial(stage, escenaNombresUsuarios);
        Scene escenaInicial = new Scene(contenedorInicial, pixelesAnchoSD, pixelesAltoSD);

        stage.setScene(escenaInicial);
        stage.setFullScreen(true);
        stage.show();
    }
}