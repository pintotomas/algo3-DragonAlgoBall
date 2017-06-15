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
		this.tablero = new Tablero(equipoGuerrerosZ,equipoEnemigosDeLaTierra);
		usuarioGuerrerosZ = new Usuario (equipoGuerrerosZ);// habria que hacer input para pedir el nombre
		usuarioEnemigosDeLaTierra = new Usuario (equipoEnemigosDeLaTierra);// habria que hacer input para pedir el nombre
		this.iniciarLoopPrincipalJuego();
	}
	
	private void iniciarLoopPrincipalJuego(){
		while(true){
			Usuario usuarioTurnoActual;
			if(contadorTurno % 2 != 0){
				usuarioTurnoActual = this.usuarioGuerrerosZ;
			}else{
				usuarioTurnoActual = this.usuarioEnemigosDeLaTierra;
			}
			Turno turno = new Turno(usuarioTurnoActual.getEquipo(),this.tablero);
			for(int i = 0;i < this.cantidadJugadasPosibles;i += 1){
				// turno.haceralgo
			}
			this.contadorTurno += 1;
		}
	}
	
	private void traducirJugada(String jugada){
		// aca traducimos lo que nos dijo el usuario a mensajes entre los objetos de nuestro modelo
		// con interfaz grafica, no recibiria un string. Combiene implementarlo despues
	}

	
}
