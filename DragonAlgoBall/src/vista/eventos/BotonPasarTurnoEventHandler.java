package vista.eventos;

import dab.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import vista.VistaTablero;

public class BotonPasarTurnoEventHandler implements EventHandler<ActionEvent>{
	
	Juego juego;
	private VistaTablero vistaTablero;
	
	public BotonPasarTurnoEventHandler(Juego juego, VistaTablero vistaTablero){
		this.juego = juego;	
		this.vistaTablero = vistaTablero;
	}

	@Override
	public void handle(ActionEvent event) {
		juego.pasarTurno();
		vistaTablero.dibujarTableroSinNingunaSeleccion();
	}
}
