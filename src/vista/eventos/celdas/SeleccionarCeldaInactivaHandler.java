package vista.eventos.celdas;

import java.util.ArrayList;

import dab.juego.Celda;
import dab.juego.Juego;
import dab.personajes.Personaje;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import vista.VistaInferiorPersonajes;
import vista.VistaTablero;
import vista.vistasCelda.VistaCelda;
import vista.vistasCelda.VistaCeldaALaCualSePuedeMover;
import vista.vistasCelda.VistaCeldaConPersonajeAtacable;
import vista.vistasCelda.VistaCeldaSeleccionada;

public class SeleccionarCeldaInactivaHandler implements EventHandler<MouseEvent>{

	private final VistaCelda celdaGUIOrigen;
	
	private final VistaCelda[][] celdasGUI;
	private final VistaTablero vistaTablero;
	private Juego juego;
//	private VistaInferiorPersonajes vistaInferiorPersonajes;
	
	public SeleccionarCeldaInactivaHandler(VistaCelda celda, Juego juego, VistaCelda[][] celdasGUI, VistaTablero vistaTablero, VistaInferiorPersonajes vistaInferiorPersonaje) {
		this.celdaGUIOrigen = celda;
		this.celdasGUI = celdasGUI;
		this.vistaTablero = vistaTablero;
		this.juego = juego;
//		this.vistaInferiorPersonajes = vistaInferiorPersonaje;
	}

	@Override
	public void handle(MouseEvent event) {
		//Hace algo si al seleccionar la celda tiene un personaje
		//Lo que hace es, a las celdas a las que tiene permitido mover, pintarlas de rojo.
		//A las celdas a las cuales puede atacar, las pinta de azul
		
		//(Esto hace que se despinten las celdas rojas al seleccionar otro personaje u otra celda vacia)
		vistaTablero.dibujarTableroSinNingunaSeleccion(); 
		vistaTablero.actualizarVistaEnemigo(null);
		
		if (juego.sePuedeSeleccionarUnPersonaje(celdaGUIOrigen.getCelda())){
			
			if (juego.elOcupantePuedeRealizarJugada(celdaGUIOrigen.getCelda())){
				
				celdasGUI[celdaGUIOrigen.getFila()][celdaGUIOrigen.getColumna()] = new VistaCeldaSeleccionada(celdaGUIOrigen.getCelda());
				vistaTablero.refrescar(celdaGUIOrigen.getFila(), celdaGUIOrigen.getColumna(), null);
				
				juego.seleccionarPersonajeDeLaCelda(celdaGUIOrigen.getCelda());
				if (juego.sePuedeEfectuarUnMovimiento()) {this.mostrarCeldasAlcanzables();}
				if (juego.sePuedeSeguirAtacando()) {this.mostrarCeldasConPersonajesAtacables();}
			}
		}
	
	}
	
	private void mostrarCeldasAlcanzables(){
		
//		ArrayList<Celda> celdasPermitidas = tableroJuego.celdasPermitidas(celdaGUIOrigen.getCelda(), celdaGUIOrigen.getCelda().getFicha().getVelocidad());
		ArrayList<Celda> celdasPermitidasPersonajeSeleccionado = juego.celdasPermitidasDelersonajeSeleccionado(); 
		for (Celda posibleDestino: celdasPermitidasPersonajeSeleccionado){
			celdasGUI[posibleDestino.getFila()][posibleDestino.getColumna()] = new VistaCeldaALaCualSePuedeMover(posibleDestino);
			EventHandler<MouseEvent> seleccionarCeldaALaCualPuedeMoverseEventHandler = 
					new SeleccionarCeldaParaMoverseEventHandler(juego, celdaGUIOrigen, posibleDestino, vistaTablero);
			vistaTablero.refrescar(posibleDestino.getFila(), posibleDestino.getColumna(), seleccionarCeldaALaCualPuedeMoverseEventHandler);
		}
	}
	
	private void mostrarCeldasConPersonajesAtacables(){
		//HACERLO DESDE JUEGO

//		ArrayList<Personaje> personajesAtacables = tableroJuego.personajesAtacables((Personaje) celdaGUIOrigen.getCelda().getFicha());
		ArrayList<Personaje> personajesAtacables = juego.obtenerPersonajesAtacablesDelSeleccionado();
		for (Personaje enemigo: personajesAtacables){
			celdasGUI[enemigo.getPosicion().getFila()][enemigo.getPosicion().getColumna()] = 
					new VistaCeldaConPersonajeAtacable((Celda)enemigo.getPosicion());
			EventHandler<MouseEvent> seleccionarCeldaConPersonajeAtacable = new SeleccionarCeldaConPersonajeAtacable( enemigo, vistaTablero);
			vistaTablero.refrescar(enemigo.getPosicion().getFila(), enemigo.getPosicion().getColumna(), seleccionarCeldaConPersonajeAtacable);
		}
	}
}
