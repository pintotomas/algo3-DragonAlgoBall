package vista.eventos;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.Ajustes;
import utils.reproductorDeSonidos.ReproductorDeSonidos;
import vista.ContenedorPrincipal;

public class botonNombresIngresadosEventHandler implements EventHandler<MouseEvent> {

	private TextField campoNombreUsuarioEnemigos;
	private TextField campoNombreUsuarioGuerreros;
	private Ajustes ajustesMusicaDeBatalla;
	private Ajustes ajustesEfectosDePersonajes;
	private Ajustes ajustesMusicaEnding;
	private Stage stage;
	
	public botonNombresIngresadosEventHandler(Stage stage, TextField campoNombreUsuarioGuerreros,
			TextField campoNombreUsuarioEnemigos, Ajustes ajustesMusicaDeBatalla, Ajustes ajustesEfectosDePersonajes, Ajustes ajustesMusicaEnding) {
		this.campoNombreUsuarioEnemigos = campoNombreUsuarioEnemigos;
		this.campoNombreUsuarioGuerreros = campoNombreUsuarioGuerreros;
		this.ajustesMusicaDeBatalla = ajustesMusicaDeBatalla;
		this.ajustesEfectosDePersonajes = ajustesEfectosDePersonajes;
		this.ajustesMusicaEnding = ajustesMusicaEnding;
		this.stage = stage;
	}

	@Override
	public void handle(MouseEvent event) {
		
		boolean segundoIngresoCorrecto = false;
		boolean primerIngresoCorrecto = ingresoCompletadoCorrectamente(campoNombreUsuarioGuerreros);
		if (primerIngresoCorrecto){
			segundoIngresoCorrecto = ingresoCompletadoCorrectamente(campoNombreUsuarioEnemigos);
		}
		if (primerIngresoCorrecto && segundoIngresoCorrecto){
			this.comenzarElJuego(campoNombreUsuarioGuerreros, campoNombreUsuarioEnemigos, event);
		}
	}

	private boolean ingresoCompletadoCorrectamente(TextField campo){
		if (campo.getText().isEmpty()){
			Alert alertaCamposIncompletos = new Alert(AlertType.ERROR, "Por favor, complete ambos campos con los nombres");
			alertaCamposIncompletos.showAndWait();
			campo.requestFocus();
			return false;
		}
		return true;
	}
	
	private void comenzarElJuego(TextField campoNombreUsuarioGuerreros, TextField campoNombreUsuarioEnemigos, MouseEvent event) {
		
		Button botonListoNombres = new Button("Boton de mentira");
		ReproductorDeSonidos reproductorMusicaDeBatalla = new ReproductorDeSonidos("/vista/sonidos/musicaPelea.wav");
	    ContenedorPrincipal principal = new ContenedorPrincipal(stage, campoNombreUsuarioGuerreros,
	        		campoNombreUsuarioEnemigos, reproductorMusicaDeBatalla, ajustesMusicaDeBatalla, ajustesEfectosDePersonajes, ajustesMusicaEnding);
	    Scene escenaPrincipal = new Scene(principal);
	    CambiarEscenaAlPresionarEventHandler listoNombreEventHandler = new ComenzarPartidaEventHandler(this.stage, escenaPrincipal, ajustesMusicaDeBatalla,
	        		reproductorMusicaDeBatalla);
	    botonListoNombres.setOnMousePressed(listoNombreEventHandler);
	    botonListoNombres.getOnMousePressed().handle(event);
		
	}
}
