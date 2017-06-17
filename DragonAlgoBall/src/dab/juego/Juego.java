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
	private int contadorTurno = 1;
	private int cantidadJugadasPosibles = 2;
	
	public Juego(){
		Equipo equipoGuerrerosZ = new Equipo(nombreEquipo1);
		Equipo equipoEnemigosDeLaTierra = new Equipo(nombreEquipo2);
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
		this.tablero = new Tablero(equipoGuerrerosZ,equipoEnemigosDeLaTierra, 20, 20);
		this.usuarioGuerrerosZ = new Usuario (equipoGuerrerosZ);
		this.usuarioEnemigosDeLaTierra = new Usuario (equipoEnemigosDeLaTierra);
	}
	
	public void setNombreUsuarioGuerrerosZ(String nombre){
		this.usuarioGuerrerosZ.setNombre(nombre);
	}
	
	public void setNombreUsuarioEnemigosDeLaTierra(String nombre){
		this.usuarioEnemigosDeLaTierra.setNombre(nombre);
	}
}
