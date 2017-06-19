package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacion extends Application {
	private int pixelesAnchoHD = 1920;
    private int pixelesAltoHD = 1080;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Dragon AlgoBall Z");
        
        ContenedorNombresUsuarios contenedorNombresUsuarios = new ContenedorNombresUsuarios(stage);
        Scene escenaNombresUsuarios = new Scene(contenedorNombresUsuarios);
        
        ContenedorInicial contenedorInicial = new ContenedorInicial(stage, escenaNombresUsuarios);
        Scene escenaInicial = new Scene(contenedorInicial, pixelesAnchoHD, pixelesAltoHD);

        stage.setScene(escenaInicial);
        stage.setFullScreen(true);
        stage.show();
    }
}