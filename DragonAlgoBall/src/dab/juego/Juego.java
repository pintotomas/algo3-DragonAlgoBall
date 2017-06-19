package dab.juego;

import java.util.LinkedList;
import java.util.Queue;

import dab.dragonBallExceptions.EstePersonajeNoPuedeRealizarMovimientosEsteTurno;
import dab.equipo.Equipo;
import dab.personajes.Personaje;
import dab.personajes.Freezer.Freezer;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Goku.Goku;
import dab.personajes.Piccolo.Piccolo;
import dab.personajes.cell.Cell;
import dab.personajes.majinBoo.MajinBoo;
import dab.usuario.Usuario;

public class Juego {
	
	
	////CAMBIOS A HACER:
	///QUE JUEGO RECIBA UN USUARIO CON SU EQUIPO DENTRO YA CREADO
	///QUE LOS TURNOS SE MANEJEN POR USUARIO Y NO POR EQUIPO
	
	private Tablero tablero;
	Turno turno;
	Queue<Usuario> ordenTurnos; 
	
	private Personaje personajeSeleccionado;
	
	public Juego(int altoTablero, int anchoTablero, Usuario userGuerrerosZ, Usuario userEnemigos){
		//PRE: SOLO DOS USUARIOS Y EL PRIMERO SERA EL PRIMERO EN JUGAR

	
		//Cambiaro esto de que el tablero conozca al equipo enemigo de un determinado equipo. Eso lo podria hacer
		//El juego o el usuario
		this.tablero = new Tablero(altoTablero, anchoTablero, userGuerrerosZ.getEquipo(), userEnemigos.getEquipo());
	
		
		ordenTurnos = new LinkedList<Usuario>();
		ordenTurnos.offer(userGuerrerosZ);
		ordenTurnos.offer(userEnemigos);
		
		turno = new Turno(ordenTurnos.peek().getEquipo(), tablero);
		
		
		
	}
	
	

	public Turno getTurno() {
		
		
		if (turno.termino()){
			//POR AHORA ESTO LO DEJO PARA QUE CORRA LA APLICACION, 
			//PERO NO ESTA BIEN QUE getTurno() HAGA ESTO
			this.pasarTurno();
		}
		
		return turno;	

	}
	
	public void seleccionarPersonaje(Personaje aPersonaje){
		if (!turno.puedeJugar(aPersonaje)){
			throw new EstePersonajeNoPuedeRealizarMovimientosEsteTurno();
		}
		personajeSeleccionado = aPersonaje;
	}
	
	public Tablero getTablero(){
		return tablero;
	}

	public void pasarTurno() {

		personajeSeleccionado = null;
		ordenTurnos.offer(ordenTurnos.poll());
		turno = new Turno(ordenTurnos.peek().getEquipo(), tablero);
		
	}
	
	public boolean personajeSeleccionadoPuedeAtacarA(Personaje otroPersonaje){
		
		return personajeSeleccionado.puedeAtacar(otroPersonaje);
		
	}
	
	public void personajeSeleccionadoAtacaA(Personaje otroPersonaje){
	
		personajeSeleccionado.atacarA(otroPersonaje);
		
	}
	
	public boolean personajeSeleccionadoPuedeMoverseHacia(int fila, int columna){
		return tablero.puedeTrasladarse(personajeSeleccionado, fila, columna);
	}
	
	public void moverPersonajeSeleccionadoHacia(int fila, int columna){
		tablero.moverFicha(personajeSeleccionado, fila, columna);
		turno.movio();
		this.chequearFinDeTurno();
	}
	
	public void personajeSeleccionadoAtaqueEspecialA(Personaje otroPersonaje){
		personajeSeleccionado.ataqueEspecial(otroPersonaje);
		turno.ataco();
		this.chequearFinDeTurno();
	}
	
	public boolean personajeSeleccionadoTieneAtaqueEspecialDisponible(){
		return personajeSeleccionado.ataqueEspecialDisponible();
	}
	
	public boolean personajeSeleccionadoTieneTransformacionDisponible(){
		return personajeSeleccionado.transformarDisponible();
	}
	
	public void personajeSeleccionadoTransformar(){
		personajeSeleccionado.transformar();
	}
	
	private void chequearFinDeTurno(){
		if (turno.termino()){
			this.pasarTurno();
		}
	}
	
}
