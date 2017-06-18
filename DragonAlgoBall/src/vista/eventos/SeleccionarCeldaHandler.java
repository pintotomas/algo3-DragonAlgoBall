package vista.eventos;

import java.util.ArrayList;

import dab.juego.Celda;
import dab.juego.Juego;
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
	private Turno turno;
	private final Juego juego;
	
	public SeleccionarCeldaHandler(Juego juego, VistaCelda celda, VistaCelda[][] celdasGUI) {
		this.celda = celda;
		this.celdasGUI = celdasGUI;
		this.tableroJuego = juego.getTablero();
		this.turno = juego.getTurno();
		this.juego = juego;
	}
	
		
	
	
	
	/*****
	 * 
	 * fuciones para achicar el event de click
	 * 
	 * 
	 */
	
	private void funcionParaMover(){
		ArrayList<Celda> celdas = turno.getCeldasPermitidas();

		tableroJuego.moverFicha(turno.getCeldaSeleccionada().getFicha(), celda.getFila(), celda.getColumna());
		celdas.add(turno.getCeldaSeleccionada());
		
		liberarCeldasAnteriores(celdas);
		turno.seleccionarCelda(null);
		turno.seleccionarPersonaje(null);
		turno.movio();
	}
	
	
	
	private void liberarCeldasAnteriores(ArrayList<Celda> celdas){
		if(turno.getCeldaSeleccionada() != null)
			celdas.add(turno.getCeldaSeleccionada());
			if(turno.getPersonajeSeleccionado() != null){
				for(Personaje enemigo : tableroJuego.getEquipoEnemigo(turno.getPersonajeSeleccionado()).obtenerPersonajes()) //permite resetear aunque enemigo ya no este en rango.
					celdas.add((Celda)enemigo.getPosicion());
			}
		for (Celda c: celdas){
			celdasGUI[c.getFila()][c.getColumna()].liberada();
			celdasGUI[c.getFila()][c.getColumna()].actualizarPersonaje();
		}
	}
	
	public void funcionParaAtacar(){
		ArrayList<Celda> celdas = turno.getCeldasPermitidas();
		turno.atacar(celda.getCelda());
		celdas.add(turno.getCeldaSeleccionada());
		celda.recivioAtaque(); //le avisa a la celda, para que verifique si se murio.
		liberarCeldasAnteriores(celdas);
		turno.ataco();
		//lo sig permite que se dibuje al apretar al personaje luego de atacar.
		turno.seleccionarCelda(null);
		turno.seleccionarPersonaje(null);
	}
	
	public void pintarCeldasDondePuedeMoverYAtacar(){
		ArrayList<Celda> celdas = turno.getCeldasPermitidas();
		liberarCeldasAnteriores(celdas);
		
		if (celda.estaOcupada() && celda.getCelda().getFicha().getEquipo() == turno.getEquipo()){
			turno.seleccionarCelda(celda.getCelda());
			turno.seleccionarPersonaje((Personaje)(celda.getCelda().getFicha()));
			if(!turno.yaAtaco()){  //pinta las celdas que puede atacar
				for(Personaje enemigo : tableroJuego.personajesAtacables(turno.getPersonajeSeleccionado())){
					celdasGUI[enemigo.getPosicion().getFila()][enemigo.getPosicion().getColumna()].atacable();
				}
			}
			if(!turno.yaMovio()){
				for (Celda c: turno.getCeldasPermitidas()){
					celdasGUI[c.getFila()][c.getColumna()].disponible();
				}
			}
			//si la celda tiene un personaje la pinta de azul para que quede claro que personaje es.
			celda.seleccionada();
		}else{
			turno.seleccionarPersonaje(null);
		}
		turno.seleccionarCelda(celda.getCelda());
	}
	
	@Override
	public void handle(MouseEvent event) {
		if(celda.estaViva()){
			turno = juego.getTurno();
			boolean accion = false;
			if(!turno.yaMovio()){
				if(celda.estaDisponible()){
					funcionParaMover();
					accion = true;
				}	//si la celda no es la misma que antes.	
			}
			if(!turno.yaAtaco() && !accion){
				if(celda.esAtacable()){
					//aca tenemos que agregar algun boton para que tire el ataque especial si puede
					funcionParaAtacar();
					accion = true;
				}
			}
			if(!accion && celda.getCelda() != turno.getCeldaSeleccionada()){
					pintarCeldasDondePuedeMoverYAtacar();		
			}
		}
				
	}
	
	
	
}