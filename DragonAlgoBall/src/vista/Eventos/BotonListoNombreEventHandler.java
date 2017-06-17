package vista.Eventos;

import dab.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonListoNombreEventHandler implements EventHandler<ActionEvent>{
	Stage stage;
	Scene proximaEscena;
	private Juego juego;
	private TextField campoTextoGuerreros;
	private TextField campoTextoEnemigos;
	
	public BotonListoNombreEventHandler(Stage stage, Scene proximaEscena, Juego juegoDAB, TextField campoNombreUsuarioGuerreros, TextField campoNombreUsuarioEnemigos){
		this.stage = stage;
		this.proximaEscena = proximaEscena;
		this.juego = juegoDAB;
		this.campoTextoGuerreros = campoNombreUsuarioGuerreros;
		this.campoTextoEnemigos = campoNombreUsuarioEnemigos;
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.juego.setNombreUsuarioEnemigosDeLaTierra(this.campoTextoEnemigos.getText());
		this.juego.setNombreUsuarioGuerrerosZ(this.campoTextoGuerreros.getText());
		this.stage.setScene(proximaEscena);
		stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
	}
}