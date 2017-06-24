package vista.eventos;

import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import utils.Ajustes;
import utils.reproductorDeSonidos.ReproductorDeSonidos;

public class ComenzarPartidaEventHandler extends CambiarEscenaAlPresionarEventHandler {
	private Ajustes ajustesMusicaDeBatalla;
	private ReproductorDeSonidos reproductorMusicaDeBatalla;
	public ComenzarPartidaEventHandler(Stage stage, Scene proximaEscena, Ajustes ajustesMusicaDeBatalla) {
		super(stage, proximaEscena);
		this.ajustesMusicaDeBatalla = ajustesMusicaDeBatalla;
		// TODO Auto-generated constructor stub
	}

	@Override
    public void handle(MouseEvent actionEvent) {
		super.handle(actionEvent);
		if (ajustesMusicaDeBatalla.estaActivo()){
	        reproductorMusicaDeBatalla = new ReproductorDeSonidos("/vista/sonidos/musicaPelea.wav");
	        Thread thread = new Thread(reproductorMusicaDeBatalla);
	        thread.setDaemon(true);
	        thread.start();
		}
	}
}
