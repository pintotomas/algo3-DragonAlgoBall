package dab.tests.juego;


import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dab.dragonBallExceptions.EstePersonajeNoPuedeRealizarMovimientosEsteTurno;
import dab.equipo.Equipo;
import dab.juego.Celda;
import dab.juego.Juego;
import dab.personajes.Personaje;
import dab.personajes.Freezer.Freezer;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Goku.Goku;
import dab.personajes.Piccolo.Piccolo;
import dab.personajes.cell.Cell;
import dab.personajes.majinBoo.MajinBoo;
import dab.potenciadores.EsferaDelDragon;
import dab.usuario.Usuario;

public class TestsJuego {

	private int altoTablero;
	private int anchoTablero;
	private Usuario userGuerrerosZ;
	private Usuario userEnemigosDeLaTierra;
	private Goku goku = new Goku();
	private Cell cell = new Cell();
	private Freezer freezer = new Freezer();
	private MajinBoo majinBoo = new MajinBoo();
	private Equipo equipoGuerrerosZ = new Equipo("Guerreros Z", goku, new Gohan(), new Piccolo());
	private Equipo equipoEnemigos = new Equipo("Enemigos de la Tierra", cell, freezer, majinBoo);
	
	@Before
	public void before(){
		userGuerrerosZ = new Usuario(equipoGuerrerosZ, "Tomas");
		
		userEnemigosDeLaTierra = new Usuario(equipoEnemigos, "PC");
		
		altoTablero = 5;
		anchoTablero = 5;
	}
	
	@Test
	public void testPasarTurnoCambiaDeEquipo() {
		Juego juego = new Juego(altoTablero, anchoTablero, userGuerrerosZ, userEnemigosDeLaTierra);		
		Usuario usuarioInicial = juego.obtenerJugadorActual();
		juego.pasarTurno();
		Assert.assertNotSame(usuarioInicial, juego.obtenerJugadorActual());
	}
	
	@Test(expected=EstePersonajeNoPuedeRealizarMovimientosEsteTurno.class)
	public void testNoSePuedeSeleccionarUnPersonajeFueraDelTurnoDeSuRespectivoEquipo(){
		Juego juego = new Juego(altoTablero, anchoTablero, userGuerrerosZ, userEnemigosDeLaTierra);	
		juego.seleccionarPersonajeDeLaCelda((Celda) (userEnemigosDeLaTierra.getEquipo().obtenerPersonaje("Freezer").getPosicion()));
	}
	
	@Test
	public void testGanaElEquipoDelTurnoActualSiTienenLaCantidadDeEsferasNecesariasParaGanar(){
		Juego juego = new Juego(altoTablero, anchoTablero, userGuerrerosZ, userEnemigosDeLaTierra);	
		for (int i = Usuario.cantidadEsferasDelDragonParaGanar; i > 0; i --){
			goku.interactuarAlContacto(new EsferaDelDragon());
		}
		Assert.assertTrue(juego.ganoElDelTurnoActual());
	}

	@Test
	public void testGanaElEquipoDelTurnoActualSiElOtroQuedaSinPersonajes(){
		Juego juego = new Juego(altoTablero, anchoTablero, userGuerrerosZ, userEnemigosDeLaTierra);	
		Collection<Personaje> personajesEnemigos = equipoEnemigos.obtenerPersonajes();
		personajesEnemigos.clear();
		Assert.assertTrue(juego.ganoElDelTurnoActual());
	}
	@Test
	public void testNoGanaElEquipoDelTurnoActualSiTieneUnaEsferaMenosQueLasNecesariasParaGanar(){
		Juego juego = new Juego(altoTablero, anchoTablero, userGuerrerosZ, userEnemigosDeLaTierra);	
		for (int i = Usuario.cantidadEsferasDelDragonParaGanar - 1; i > 0; i --){
			goku.interactuarAlContacto(new EsferaDelDragon());
		}
		Assert.assertFalse(juego.ganoElDelTurnoActual());
	}
	
	@Test
	public void testNoGanaElEquipoDelTurnoActualSiElOtroTieneUnPersonaje(){
		Juego juego = new Juego(altoTablero, anchoTablero, userGuerrerosZ, userEnemigosDeLaTierra);	
		equipoEnemigos.quitarPersonaje(majinBoo);
		equipoEnemigos.quitarPersonaje(cell);
		Assert.assertFalse(juego.ganoElDelTurnoActual());
	}
}
