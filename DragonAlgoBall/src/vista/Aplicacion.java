package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
        VistaMenuPrincipal menuPrincipal = new VistaMenuPrincipal(stage);
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