package vista.eventos;

import java.util.ArrayList;

import dab.juego.Celda;
import dab.juego.Tablero;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.VistaCelda;

public class SeleccionarCeldaHandler implements EventHandler<MouseEvent>{

	private final VistaCelda celda;
	private final Tablero tableroJuego;
	private final VistaCelda[][] celdasGUI;
	
	public SeleccionarCeldaHandler(VistaCelda celda, Tablero tableroJuego, VistaCelda[][] celdasGUI) {
		this.celda = celda;
		this.celdasGUI = celdasGUI;
		this.tableroJuego = tableroJuego;
	}

	@Override
	public void handle(MouseEvent event) {
		if (celda.estaOcupada()){
			ArrayList<Celda> celdasPermitidas = tableroJuego.celdasPermitidas(celda.getCelda(), celda.getCelda().getFicha().getVelocidad());
			for (Celda c: celdasPermitidas){
				celdasGUI[c.getFila()][c.getColumna()].presionada();
			}
		}
	}
}
