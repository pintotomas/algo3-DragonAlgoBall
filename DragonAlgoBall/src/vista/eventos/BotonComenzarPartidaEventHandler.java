package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vista.ContenedorPrincipal;

public class BotonComenzarPartidaEventHandler implements EventHandler<ActionEvent>{
	Stage stage;
	Scene proximaEscena;
	private TextField campoNombreUsuarioGuerreros;
	private TextField campoNombreUsuarioEnemigos;
	private final int pixelesAnchoHD = 1920;
    private final int pixelesAltoHD = 1080;
	
	public BotonComenzarPartidaEventHandler(Stage stage, TextField campoNombreUsuarioGuerreros, TextField campoNombreUsuarioEnemigos){
		this.stage = stage;		
		this.campoNombreUsuarioGuerreros = campoNombreUsuarioGuerreros;
		this.campoNombreUsuarioEnemigos = campoNombreUsuarioEnemigos;
	}
	
	@Override
	public void handle(ActionEvent event) {
		
		ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, campoNombreUsuarioGuerreros.getText(), campoNombreUsuarioEnemigos.getText() );
        Scene escenaPrincipal = new Scene(contenedorPrincipal,pixelesAnchoHD,pixelesAltoHD);
        
        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaPrincipal.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
        
        stage.setScene(escenaPrincipal);
		stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
	}
}