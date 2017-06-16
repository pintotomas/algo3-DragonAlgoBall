package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("Dragon AlgoBall Z");

        ContenedorInicial contenedorInicial = new ContenedorInicial(stage/*, escenaJuego*/);
        int pixelesAnchoHD = 840;
        int pixelesAltoHD = 480;
        Scene escenaInicial = new Scene(contenedorInicial, pixelesAnchoHD, pixelesAltoHD);

        stage.setScene(escenaInicial);
        stage.setFullScreen(true);

        stage.show();
    }
}