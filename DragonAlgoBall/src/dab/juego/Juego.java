package dab.juego;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import dab.equipo.Equipo;
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
	public Juego(String nombreUsuarioGuerrerosZ, String nombreUsuarioEnemigosDeLaTierra){
		equipoGuerrerosZ = new Equipo(nombreEquipo1);
		equipoEnemigosDeLaTierra = new Equipo(nombreEquipo2);
		Gohan gohanBase = new Gohan();
		Goku gokuBase = new Goku();
		Piccolo piccoloBase = new Piccolo();
		equipoGuerrerosZ.agregarPersonaje(gohanBase);
		equipoGuerrerosZ.agregarPersonaje(gokuBase);
		equipoGuerrerosZ.agregarPersonaje(piccoloBase);
		Cell cellBase = new Cell();
		MajinBoo booBase = new MajinBoo();
		Freezer freezerBase = new Freezer();
		equipoEnemigosDeLaTierra.agregarPersonaje(cellBase);
		equipoEnemigosDeLaTierra.agregarPersonaje(booBase);
		equipoEnemigosDeLaTierra.agregarPersonaje(freezerBase);
		
		this.tablero = new Tablero(5,5, equipoGuerrerosZ, equipoEnemigosDeLaTierra);
		usuarioGuerrerosZ = new Usuario (equipoGuerrerosZ, nombreUsuarioGuerrerosZ);// habria que hacer input para pedir el nombre
		usuarioEnemigosDeLaTierra = new Usuario (equipoEnemigosDeLaTierra, nombreUsuarioEnemigosDeLaTierra);// habria que hacer input para pedir el nombre
		ordenTurnos = new LinkedList<Equipo>(Arrays.asList(equipoGuerrerosZ, equipoEnemigosDeLaTierra));
		
		turno = new Turno(equipoGuerrerosZ, tablero);
		
		
	}

	public Turno getTurno() {
		
		
		if (turno.termino()){
			//Hace falta?
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
		ordenTurnos.offer(ordenTurnos.poll());
		turno = new Turno(ordenTurnos.peek(), tablero);
		
	}
	
	
	
}
