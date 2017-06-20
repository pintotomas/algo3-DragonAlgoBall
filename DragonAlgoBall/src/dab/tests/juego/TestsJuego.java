package dab.tests.juego;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dab.dragonBallExceptions.EstePersonajeNoPuedeRealizarMovimientosEsteTurno;
import dab.equipo.Equipo;
import dab.juego.Celda;
import dab.juego.Juego;
import dab.juego.Turno;
import dab.personajes.Freezer.Freezer;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Goku.Goku;
import dab.personajes.Piccolo.Piccolo;
import dab.personajes.cell.Cell;
import dab.personajes.majinBoo.MajinBoo;
import dab.usuario.Usuario;

public class TestsJuego {

	private int altoTablero;
	private int anchoTablero;
	private Usuario userGuerrerosZ;
	private Usuario userEnemigosDeLaTierra;
	
	@Before
	public void before(){
		userGuerrerosZ = new Usuario(new Equipo("Guerreros Z", new Goku(), new Gohan(), new Piccolo()),
				"Tomas");
		
		userEnemigosDeLaTierra = new Usuario(new Equipo("Enemigos de la Tierra", new Cell(), new Freezer(), new MajinBoo()),
				"PC");
		
		altoTablero = 5;
		anchoTablero = 5;
	}
	
	@Test
	public void testPasarTurnos() {
		
		Juego juego = new Juego(altoTablero, anchoTablero, userGuerrerosZ, userEnemigosDeLaTierra);		
		Turno turnoActual = juego.getTurno();
		String nombreEquipoActual = turnoActual.getEquipo().getNombre();
		juego.pasarTurno();
		Assert.assertNotSame(nombreEquipoActual, juego.getTurno().getEquipo().getNombre());
		
	}
	
	@Test(expected=EstePersonajeNoPuedeRealizarMovimientosEsteTurno.class)
	public void testNoSePuedeSeleccionarUnPersonajeFueraDelTurnoDeSuRespectivoEquipo(){
		
		Juego juego = new Juego(altoTablero, anchoTablero, userGuerrerosZ, userEnemigosDeLaTierra);	
		juego.seleccionarPersonajeDeLaCelda((Celda) (userEnemigosDeLaTierra.getEquipo().obtenerPersonaje("Freezer").getPosicion()));
	}

}
