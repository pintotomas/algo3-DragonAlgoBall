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
		if(!turno.yaMovio()){
			if(celda.estaDisponible()){
				ArrayList<Celda> celdas = turno.getCeldasPermitidas();
				tableroJuego.moverFicha(turno.getCeldaSeleccionada().getFicha(), celda.getFila(), celda.getColumna());
				celdas.add(turno.getCeldaSeleccionada());
				for (Celda c: celdas){
					celdasGUI[c.getFila()][c.getColumna()].liberada();
					celdasGUI[c.getFila()][c.getColumna()].actualizarPersonaje();
				}
				turno.movio();
				
			}	//si la celda no es la misma que antes. 
			else if(celda.getCelda() != turno.getCeldaSeleccionada()){
						ArrayList<Celda> celdas = turno.getCeldasPermitidas();
						//si alguna celda ya estaba seleccionada la agrega a la lista para liberar.
						if(turno.getCeldaSeleccionada() != null)
							celdas.add(turno.getCeldaSeleccionada());
						for (Celda c: celdas){
							celdasGUI[c.getFila()][c.getColumna()].liberada();
						}
							
					if (celda.estaOcupada() && celda.getCelda().getFicha().getEquipo() == turno.getEquipo()){
						turno.seleccionarCelda(celda.getCelda());
						turno.seleccionarPersonaje((Personaje)(celda.getCelda().getFicha()));
						for (Celda c: turno.getCeldasPermitidas()){
							celdasGUI[c.getFila()][c.getColumna()].disponible();
						}
						//si la celda tiene un personaje la pinta de azul para que quede claro que personaje es.
						celda.seleccionada();
					}else{
						turno.seleccionarPersonaje(null);
					}
					turno.seleccionarCelda(celda.getCelda());
				}
			}
	}
}
