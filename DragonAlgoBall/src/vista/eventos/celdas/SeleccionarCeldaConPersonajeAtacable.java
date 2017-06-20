package vista.eventos.celdas;

import dab.personajes.Personaje;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.VistaTablero;

public class SeleccionarCeldaConPersonajeAtacable implements EventHandler<MouseEvent>{

	
	
	private Personaje personajeAtacante;
	private Personaje personajeEnemigo;
	private VistaTablero vistaTablero;

	public SeleccionarCeldaConPersonajeAtacable(Personaje personajeAtacante, Personaje enemigo,
			VistaTablero vistaTablero) {
		this.personajeAtacante = personajeAtacante;
		this.personajeEnemigo = enemigo;
		this.vistaTablero = vistaTablero;
	}

	@Override
	public void handle(MouseEvent event) {
		personajeAtacante.atacarA(personajeEnemigo);
		vistaTablero.dibujarTablero();
	}

}
