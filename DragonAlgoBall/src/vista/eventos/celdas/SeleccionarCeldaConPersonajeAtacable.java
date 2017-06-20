package vista.eventos.celdas;

import dab.juego.Juego;
import dab.personajes.Personaje;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.VistaTablero;

public class SeleccionarCeldaConPersonajeAtacable implements EventHandler<MouseEvent>{

	
	
	private Personaje personajeEnemigo;
	private VistaTablero vistaTablero;
	private final Juego juego;

	public SeleccionarCeldaConPersonajeAtacable(Juego juego, Personaje enemigo, VistaTablero vistaTablero) {
		
		this.personajeEnemigo = enemigo;
		this.vistaTablero = vistaTablero;
		this.juego = juego;
	}

	@Override
	public void handle(MouseEvent event) {
		
		juego.personajeSeleccionadoAtacaA(personajeEnemigo);
		juego.seHaEfectuadoUnAtaque();
		vistaTablero.dibujarTableroSinNingunaSeleccion();
		
	}

}
