package vista.eventos;

import dab.juego.Juego;
import dab.personajes.Personaje;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.VistaTablero;

public class BotonAtaqueEspecialHandler implements EventHandler<MouseEvent> {
	
	Personaje enemigo;
	Juego juego;
	VistaTablero vistaTablero;	
	
	public BotonAtaqueEspecialHandler(Personaje enemigo, Juego juego, VistaTablero vistaTablero){
		this.enemigo = enemigo;
		this.juego = juego;
		this.vistaTablero = vistaTablero;
	}
	
	@Override
	public void handle(MouseEvent event) {
		if(juego.personajeSeleccionadoTieneAtaqueEspecialDisponible()){
			juego.personajeSeleccionadoAtaqueEspecialA(enemigo);
			juego.seHaEfectuadoUnAtaque();
			vistaTablero.dibujarTableroSinNingunaSeleccion();
			vistaTablero.actualizarVistaDePersonajes();
		}
		
	}

}
