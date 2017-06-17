package vista.eventos;

import java.util.ArrayList;

import dab.juego.Celda;
import dab.juego.Tablero;
import dab.juego.Turno;
import dab.personajes.Personaje;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.VistaCelda;

public class SeleccionarCeldaHandler implements EventHandler<MouseEvent>{

	private final VistaCelda celda;
	private final Tablero tableroJuego;
	private final VistaCelda[][] celdasGUI;
	private final Turno turno;
	
	public SeleccionarCeldaHandler(VistaCelda celda, Tablero tableroJuego, VistaCelda[][] celdasGUI, Turno turno) {
		this.celda = celda;
		this.celdasGUI = celdasGUI;
		this.tableroJuego = tableroJuego;
		this.turno = turno;
	}
	
		
	
	@Override
	public void handle(MouseEvent event) {
		if(celda.getCelda() != turno.getCeldaSeleccionada()){
				for (Celda c: turno.getCeldasPermitidas()){
					celdasGUI[c.getFila()][c.getColumna()].liberada();
				}
					
			if (celda.estaOcupada()){
				turno.seleccionarCelda(celda.getCelda());
				turno.seleccionarPersonaje((Personaje)(celda.getCelda().getFicha()));
				for (Celda c: turno.getCeldasPermitidas()){
					celdasGUI[c.getFila()][c.getColumna()].presionada();
				}
			}else{
				turno.seleccionarPersonaje(null);
			}
			turno.seleccionarCelda(celda.getCelda());
		}
	}
}
