package vista.eventos.celdas;

import dab.juego.Celda;
import dab.juego.Juego;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.VistaTablero;
import vista.vistasCelda.VistaCelda;

public class SeleccionarCeldaParaMoverseEventHandler implements EventHandler<MouseEvent> {

	private int filaDestino;
	private int columnaDestino;
	private final VistaTablero vistaTablero;
	private final Juego juego;
	
	public SeleccionarCeldaParaMoverseEventHandler(Juego juego, VistaCelda origen, Celda destino, VistaTablero vistaTablero){
		
		
		this.filaDestino = destino.getFila();
		this.columnaDestino = destino.getColumna();
		this.vistaTablero = vistaTablero;
		this.juego = juego;
	}
	
	@Override
	public void handle(MouseEvent event) {
		
		juego.moverPersonajeSeleccionadoHacia(filaDestino, columnaDestino);
		juego.seHaEfectuadoUnMovimiento();
		vistaTablero.dibujarTableroSinNingunaSeleccion();
		
	}

}
