package vista.eventos;

import dab.juego.Juego;
import dab.personajes.Personaje;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.VistaTablero;

public class BotonAtaqueNormalHandler implements EventHandler<MouseEvent>{
	Juego juego;
	Personaje enemigo;
	VistaTablero vistaTablero;
	
	
	
	
	public BotonAtaqueNormalHandler(Personaje enemigo, Juego juego, VistaTablero vistaTablero){
		this.juego = juego;
		this.enemigo = enemigo;
		this.vistaTablero = vistaTablero;
		
	}
	
	
	
	@Override
	public void handle(MouseEvent event) {
		juego.personajeSeleccionadoAtacaA(enemigo);
		juego.seHaEfectuadoUnAtaque();
		vistaTablero.dibujarTableroSinNingunaSeleccion();
		vistaTablero.actualizarVistaDePersonajes();		
	}

}
