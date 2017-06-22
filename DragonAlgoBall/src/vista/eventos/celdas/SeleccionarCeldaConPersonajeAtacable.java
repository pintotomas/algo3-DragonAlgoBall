package vista.eventos.celdas;

import dab.juego.Juego;
import dab.personajes.Personaje;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.VistaTablero;

public class SeleccionarCeldaConPersonajeAtacable implements EventHandler<MouseEvent>{

	
	
	private Personaje personajeEnemigo;
	private VistaTablero vistaTablero;

	public SeleccionarCeldaConPersonajeAtacable(Personaje enemigo, VistaTablero vistaTablero) {
		
		this.personajeEnemigo = enemigo;
		this.vistaTablero = vistaTablero;
	}

	@Override
	public void handle(MouseEvent event) {
		vistaTablero.actualizarVistaEnemigo(personajeEnemigo);
	}

}
