package vista.eventos.celdas;

import dab.interfaces.IFichaMovible;
import dab.juego.Celda;
import dab.juego.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.VistaTablero;
import vista.vistasCelda.VistaCelda;

public class SeleccionarCeldaParaMoverseEventHandler implements EventHandler<MouseEvent> {

	private Tablero tableroJuego;
	private IFichaMovible fichaAMover;
	private int filaDestino;
	private int columnaDestino;
	private final VistaTablero vistaTablero;
	
	public SeleccionarCeldaParaMoverseEventHandler(Tablero tableroJuego, VistaCelda origen, Celda destino, VistaTablero vistaTablero){
		this.tableroJuego = tableroJuego;
		this.fichaAMover = origen.getCelda().getFicha();
		this.filaDestino = destino.getFila();
		this.columnaDestino = destino.getColumna();
		this.vistaTablero = vistaTablero;
	}
	
	@Override
	public void handle(MouseEvent event) {
		tableroJuego.moverFicha(fichaAMover, filaDestino, columnaDestino);
		vistaTablero.dibujarTablero();
		
	}

}
