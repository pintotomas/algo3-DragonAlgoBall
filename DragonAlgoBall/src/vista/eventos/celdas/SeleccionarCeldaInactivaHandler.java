package vista.eventos.celdas;

import java.util.ArrayList;

import dab.juego.Celda;
import dab.juego.Juego;
import dab.juego.Tablero;
import dab.personajes.Personaje;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.VistaCaracteristicasPersonaje;
import vista.VistaTablero;
import vista.vistasCelda.VistaCelda;
import vista.vistasCelda.VistaCeldaALaCualSePuedeMover;
import vista.vistasCelda.VistaCeldaConPersonajeAtacable;
import vista.vistasCelda.VistaCeldaSeleccionada;

public class SeleccionarCeldaInactivaHandler implements EventHandler<MouseEvent>{

	private final VistaCelda celdaGUIOrigen;
	private final Tablero tableroJuego;
	private final VistaCelda[][] celdasGUI;
	private final VistaTablero vistaTablero;
	private Juego juego;
	private VistaCaracteristicasPersonaje vistaCaracteristicasPersonajes;
	public SeleccionarCeldaInactivaHandler(VistaCelda celda, Juego juego, VistaCelda[][] celdasGUI, VistaTablero vistaTablero, VistaCaracteristicasPersonaje vistaCaracteristicasPersonaje) {
		this.celdaGUIOrigen = celda;
		this.celdasGUI = celdasGUI;
		this.tableroJuego = juego.getTablero();
		this.vistaTablero = vistaTablero;
		this.juego = juego;
		this.vistaCaracteristicasPersonajes = vistaCaracteristicasPersonaje;
	}

	@Override
	public void handle(MouseEvent event) {
		//Hace algo si al seleccionar la celda tiene un personaje
		//Lo que hace es, a las celdas a las que tiene permitido mover, pintarlas de rojo.
		//A las celdas a las cuales puede atacar, las pinta de azul
		
		//(Esto hace que se despinten las celdas rojas al seleccionar otro personaje u otra celda vacia)
		vistaTablero.dibujarTableroSinNingunaSeleccion(); 
		
		
		if (juego.sePuedeSeleccionarUnPersonaje(celdaGUIOrigen.getCelda())){
			
			if (juego.elOcupantePuedeRealizarJugada(celdaGUIOrigen.getCelda())){
				
				celdasGUI[celdaGUIOrigen.getFila()][celdaGUIOrigen.getColumna()] = new VistaCeldaSeleccionada(celdaGUIOrigen.getCelda());
				vistaTablero.refrescar(celdaGUIOrigen.getFila(), celdaGUIOrigen.getColumna(), null);
				
				juego.seleccionarPersonajeDeLaCelda(celdaGUIOrigen.getCelda());
				vistaCaracteristicasPersonajes.update(juego.personajeSeleccionado());
				if (juego.sePuedeEfectuarUnMovimiento()) {this.mostrarCeldasAlcanzables();}
				if (juego.sePuedeSeguirAtacando()) {this.mostrarCeldasConPersonajesAtacables();}
			}
		}
	
	}
	
	private void mostrarCeldasAlcanzables(){
		
		ArrayList<Celda> celdasPermitidas = tableroJuego.celdasPermitidas(celdaGUIOrigen.getCelda(), celdaGUIOrigen.getCelda().getFicha().getVelocidad());
		for (Celda posibleDestino: celdasPermitidas){
			celdasGUI[posibleDestino.getFila()][posibleDestino.getColumna()] = new VistaCeldaALaCualSePuedeMover(posibleDestino);
			EventHandler<MouseEvent> seleccionarCeldaALaCualPuedeMoverseEventHandler = 
					new SeleccionarCeldaParaMoverseEventHandler(juego, celdaGUIOrigen, posibleDestino, vistaTablero);
			vistaTablero.refrescar(posibleDestino.getFila(), posibleDestino.getColumna(), seleccionarCeldaALaCualPuedeMoverseEventHandler);
		}
	}
	
	private void mostrarCeldasConPersonajesAtacables(){
		//HACERLO DESDE JUEGO

		ArrayList<Personaje> personajesAtacables = tableroJuego.personajesAtacables((Personaje) celdaGUIOrigen.getCelda().getFicha());
		for (Personaje enemigo: personajesAtacables){
			celdasGUI[enemigo.getPosicion().getFila()][enemigo.getPosicion().getColumna()] = 
					new VistaCeldaConPersonajeAtacable((Celda)enemigo.getPosicion());
			EventHandler<MouseEvent> seleccionarCeldaConPersonajeAtacable = new SeleccionarCeldaConPersonajeAtacable(juego, enemigo, vistaTablero);
			vistaTablero.refrescar(enemigo.getPosicion().getFila(), enemigo.getPosicion().getColumna(), seleccionarCeldaConPersonajeAtacable);
		}
	}
}
