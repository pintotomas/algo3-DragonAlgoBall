package dab.juego;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
	private String nombreEquipo1 = "guerrerosZ", nombreEquipo2 = "enemigosDeLaTierra";
	private Tablero tablero;
	private Usuario usuarioGuerrerosZ,usuarioEnemigosDeLaTierra;
	Equipo equipoGuerrerosZ, equipoEnemigosDeLaTierra;
	Turno turno;
	Queue<Equipo> ordenTurnos; 
	
	Personaje personajeSeleccionado;
	
	public Juego(String nombreUsuarioGuerrerosZ, String nombreUsuarioEnemigosDeLaTierra){
		Gohan gohan = new Gohan();
		Goku goku = new Goku();
		Piccolo piccolo = new Piccolo();
		equipoGuerrerosZ = new Equipo(nombreEquipo1, gohan, goku, piccolo);
	
		
		Cell cell = new Cell();
		MajinBoo boo = new MajinBoo();
		Freezer freezer = new Freezer();
		equipoEnemigosDeLaTierra = new Equipo(nombreEquipo2, cell, boo, freezer);
	
		this.tablero = new Tablero(5,5, equipoGuerrerosZ, equipoEnemigosDeLaTierra);
		usuarioGuerrerosZ = new Usuario (equipoGuerrerosZ, nombreUsuarioGuerrerosZ);// habria que hacer input para pedir el nombre
		usuarioEnemigosDeLaTierra = new Usuario (equipoEnemigosDeLaTierra, nombreUsuarioEnemigosDeLaTierra);// habria que hacer input para pedir el nombre
		
		
		ordenTurnos = new LinkedList<Equipo>(Arrays.asList(equipoGuerrerosZ, equipoEnemigosDeLaTierra));
		turno = new Turno(equipoGuerrerosZ, tablero);
		
		
		
	}

	public Turno getTurno() {
		
		
		if (turno.termino()){
			//
			this.pasarTurno();
		}
		
		return turno;	
//		//si se termino el turno devuelve uno nuevo, sino el mismo.
//		if(turno.getEquipo() == equipoGuerrerosZ && turno.termino()){
//			turno =  new Turno(equipoEnemigosDeLaTierra, tablero);		
//			return turno;
//		}
//		if(turno.getEquipo() == equipoEnemigosDeLaTierra && turno.termino()){
//			turno =  new Turno(equipoGuerrerosZ, tablero);		
//			return turno;
//		};
//		return turno;
	}
	public Tablero getTablero(){
		return tablero;
	}

	public void pasarTurno() {
//		Equipo equipo = equipoGuerrerosZ;
//		if(turno.getEquipo() == equipo){
//			equipo = equipoEnemigosDeLaTierra;
//		}
		
		//pongo el primer equipo al final
		personajeSeleccionado = null;
		ordenTurnos.offer(ordenTurnos.poll());
		turno = new Turno(ordenTurnos.peek(), tablero);
		
	}
	
	public boolean personajeSeleccionadoPuedeAtacarA(Personaje otroPersonaje){
		
		return personajeSeleccionado.puedeAtacar(otroPersonaje);
		
	}
	
	public void personajeSeleccionadoAtacaA(Personaje otroPersonaje){
		//excepcion si no puede?
		personajeSeleccionado.atacarA(otroPersonaje);
	}
	
	public boolean personajeSeleccionadoPuedeMoverseHacia(int fila, int columna){
		return tablero.puedeTrasladarse(personajeSeleccionado, fila, columna);
	}
	
	public void moverPersonajeSeleccionadoHacia(int fila, int columna){
		tablero.moverFicha(personajeSeleccionado, fila, columna);
	}
	
}
