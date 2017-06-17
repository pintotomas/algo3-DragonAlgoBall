package dab.juego;

import java.util.ArrayList;

import dab.dragonBallExceptions.AtaqueNoValido;
import dab.dragonBallExceptions.CeldaNoContieneFicha;
import dab.dragonBallExceptions.MovimientoInvalido;
import dab.dragonBallExceptions.NadaSeleccionado;
import dab.equipo.Equipo;
import dab.personajes.Personaje;

public class Turno {
	Equipo equipo;
	Personaje personajeSeleccionado;
	Celda celdaSeleccionada;
	Tablero tablero;
	boolean movio, ataco, cedioTurno;
	
	public Turno(Equipo equipo,Tablero tablero){
		this.equipo = equipo;
		this.tablero = tablero;
		otorgarKi();
		this.movio = false;
		this.ataco = false;
		this.personajeSeleccionado = null;
		ArrayList<Celda> celdasPermitidasAlPersonaje;
	}
	
	private void otorgarKi(){
		/*Collection<Personaje> miembros = equipo.obtenerPersonajes();
		miembros.forEach(personaje -> personaje.agregarKi(5));*/
	}
	public void terminar(){
		/*Collection<Personaje> miembros = equipo.obtenerPersonajes();
		miembros.forEach(personaje -> personaje.pasarTurno());
		*/
	}
	
	public void seleccionarPersonaje(Personaje personaje){
		// verificar que personaje sea de equipo o poner como precondicion
		personajeSeleccionado = personaje;
	}
	
	public Personaje getPersonajeSeleccionado(){
		
		return personajeSeleccionado;
		
	}
	
	public void seleccionarCelda(Celda celda){
		celdaSeleccionada = celda;
	}
	
	public Celda getCeldaSeleccionada(){
		return celdaSeleccionada;
	}
	
	public ArrayList<Celda> getCeldasPermitidas(){
		if(personajeSeleccionado == null){
			return new ArrayList<Celda>();
		}
		
		return tablero.celdasPermitidas(celdaSeleccionada, personajeSeleccionado.getVelocidad());
	}
	
//	public void Mover(Celda celda){
//		// a la hora de crear la interfaz grafica, asumo que los lugares de alcanze del jugador cambiaran de color o algo asi, para que se sepa a donde puede ir.
//		if(personajeSeleccionado == null) throw new NadaSeleccionado();
//		if(personajeSeleccionado.movimientoPosible(celda) && tablero.trayectoriaValida(celdaSeleccionada, celda)){
//			 tablero.moverFicha(personajeSeleccionado, celda.getX(), celda.getY());
//			 movio = true;
//		}
//		else{
//			throw new MovimientoInvalido();
//		}
//	}
	//Ahora se encarga el tablero de mover
	
	public void atacar(Celda celda){
		// el atacar es similar al mover. 

		if(!celda.estaOcupada()) throw new CeldaNoContieneFicha();
		Personaje personajeAtacado = (Personaje) celda.getFicha();
		if(personajeSeleccionado.puedeAtacar(personajeAtacado)){
			personajeSeleccionado.atacarA(personajeAtacado);
			this.ataco = true;
		}else throw new AtaqueNoValido();
	}
	
}
