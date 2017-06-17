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
			if(turno.getPersonajeSeleccionado() != null){
				ArrayList<Celda> celdasPermitidas = tableroJuego.celdasPermitidas(turno.getCeldaSeleccionada(), turno.getCeldaSeleccionada().getFicha().getVelocidad());
				for (Celda c: celdasPermitidas){
					celdasGUI[c.getFila()][c.getColumna()].liberada();
				}
			}		
			if (celda.estaOcupada()){
				ArrayList<Celda> celdasPermitidas = tableroJuego.celdasPermitidas(celda.getCelda(), celda.getCelda().getFicha().getVelocidad());
				for (Celda c: celdasPermitidas){
					celdasGUI[c.getFila()][c.getColumna()].presionada();
				turno.seleccionarPersonaje((Personaje)(celda.getCelda().getFicha()));
				}
			}else{
				turno.seleccionarPersonaje(null);
			}
			turno.seleccionarCelda(celda.getCelda());
		}
	}
}
