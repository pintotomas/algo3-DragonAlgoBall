package vista.eventos.celdas;

import java.util.ArrayList;

import dab.juego.Celda;
import dab.juego.Tablero;
import dab.personajes.Personaje;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.VistaTablero;
import vista.vistasCelda.VistaCelda;
import vista.vistasCelda.VistaCeldaALaCualSePuedeMover;
import vista.vistasCelda.VistaCeldaConPersonajeAtacable;

public class SeleccionarCeldaInactivaHandler implements EventHandler<MouseEvent>{

	private final VistaCelda celdaGUIOrigen;
	private final Tablero tableroJuego;
	private final VistaCelda[][] celdasGUI;
	private final VistaTablero vistaTablero;
	
	public SeleccionarCeldaInactivaHandler(VistaCelda celda, Tablero tableroJuego, VistaCelda[][] celdasGUI, VistaTablero vistaTablero) {
		this.celdaGUIOrigen = celda;
		this.celdasGUI = celdasGUI;
		this.tableroJuego = tableroJuego;
		this.vistaTablero = vistaTablero;
	}

	@Override
	public void handle(MouseEvent event) {
		//Hace algo si al seleccionar la celda tiene un personaje
		//Lo que hace es, a las celdas a las que tiene permitido mover, pintarlas de rojo.
		//A las celdas a las cuales puede atacar, las pinta de azul
		
		//(Esto hace que se despinten las celdas rojas al seleccionar otro personaje u otra celda vacia)
		vistaTablero.dibujarTablero(); 
		
		if (celdaGUIOrigen.estaOcupada()){
			
			this.mostrarCeldasAlcanzables();
			this.mostrarCeldasConPersonajesAtacables();
		}
	}
	
	private void mostrarCeldasAlcanzables(){
		
		ArrayList<Celda> celdasPermitidas = tableroJuego.celdasPermitidas(celdaGUIOrigen.getCelda(), celdaGUIOrigen.getCelda().getFicha().getVelocidad());
		for (Celda posibleDestino: celdasPermitidas){
			celdasGUI[posibleDestino.getFila()][posibleDestino.getColumna()] = new VistaCeldaALaCualSePuedeMover(posibleDestino);
			EventHandler<MouseEvent> seleccionarCeldaALaCualPuedeMoverseEventHandler = 
					new SeleccionarCeldaParaMoverseEventHandler(tableroJuego, celdaGUIOrigen, posibleDestino, vistaTablero);
			vistaTablero.refrescar(posibleDestino.getFila(), posibleDestino.getColumna(), seleccionarCeldaALaCualPuedeMoverseEventHandler);
		}
	}
	
	private void mostrarCeldasConPersonajesAtacables(){
		//HACERLO DESDE JUEGO
		Personaje personajeAtacante = (Personaje)celdaGUIOrigen.getCelda().getFicha();
		
		ArrayList<Personaje> personajesAtacables = tableroJuego.personajesAtacables((Personaje) celdaGUIOrigen.getCelda().getFicha());
		for (Personaje enemigo: personajesAtacables){
			celdasGUI[enemigo.getPosicion().getFila()][enemigo.getPosicion().getColumna()] = 
					new VistaCeldaConPersonajeAtacable((Celda)enemigo.getPosicion());
			EventHandler<MouseEvent> seleccionarCeldaConPersonajeAtacable = new SeleccionarCeldaConPersonajeAtacable(personajeAtacante, enemigo, vistaTablero);
			vistaTablero.refrescar(enemigo.getPosicion().getFila(), enemigo.getPosicion().getColumna(), seleccionarCeldaConPersonajeAtacable);
		}
	}
}
