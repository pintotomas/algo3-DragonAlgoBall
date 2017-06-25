package vista.eventos;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import utils.reproductorDeSonidos.ReproductorDeSonidos;

public class ControlMusicaDeBatallaEventHandler implements EventHandler<MouseEvent> {

	private ReproductorDeSonidos reproductorMusica;
	
	public ControlMusicaDeBatallaEventHandler(ReproductorDeSonidos reproductorMusicaDeBatalla) {
		reproductorMusica = reproductorMusicaDeBatalla;
	}

	@Override
	public void handle(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (reproductorMusica.isMuted()){
			reproductorMusica.unMute();
		}
		else{
			reproductorMusica.mute();
		}
	}
	
}
