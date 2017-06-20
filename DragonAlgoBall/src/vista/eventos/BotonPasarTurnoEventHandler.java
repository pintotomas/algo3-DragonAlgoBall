package vista.eventos;

import dab.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonPasarTurnoEventHandler implements EventHandler<ActionEvent>{
	
	Juego juego;
	
	public BotonPasarTurnoEventHandler(Juego juego){
		this.juego = juego;	
	}

	@Override
	public void handle(ActionEvent event) {
		juego.pasarTurno();
	}
}
