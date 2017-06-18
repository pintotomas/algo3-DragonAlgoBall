package dab.juego;

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
	private int contadorTurno = 1;
	private int cantidadJugadasPosibles = 2;
	Turno turno;
	public Juego(){
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
		
		this.tablero = new Tablero(10,10, equipoGuerrerosZ, equipoEnemigosDeLaTierra);
		usuarioGuerrerosZ = new Usuario (equipoGuerrerosZ);// habria que hacer input para pedir el nombre
		usuarioEnemigosDeLaTierra = new Usuario (equipoEnemigosDeLaTierra);// habria que hacer input para pedir el nombre
		turno = new Turno(equipoGuerrerosZ, tablero);
	}
	
	public void setNombreUsuarioGuerrerosZ(String nombre){
		this.usuarioGuerrerosZ.setNombre(nombre);
	}
	
	public void setNombreUsuarioEnemigosDeLaTierra(String nombre){
		this.usuarioEnemigosDeLaTierra.setNombre(nombre);
	}

	public Turno getTurno() {
		if(turno.getEquipo() == equipoGuerrerosZ){
			turno =  new Turno(equipoEnemigosDeLaTierra, tablero);		
			return turno;
		}
		turno =  new Turno(equipoGuerrerosZ,tablero);
		return turno;
	}
	public Tablero getTablero(){
		return tablero;
	}
}
