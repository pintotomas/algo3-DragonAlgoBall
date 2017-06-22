package dab.tests.integradoras;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import dab.equipo.Equipo;
import dab.juego.Celda;
import dab.juego.Juego;
import dab.juego.Tablero;
import dab.personajes.Personaje;
import dab.personajes.Freezer.Freezer;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Goku.Goku;
import dab.personajes.Piccolo.Piccolo;
import dab.personajes.cell.Cell;
import dab.personajes.majinBoo.MajinBoo;
import dab.potenciadores.NubeVoladora;
import dab.usuario.Usuario;

public class PruebasIntegradoras2 {

	private Gohan gohan;
	private Freezer freezer;
	private Tablero tablero;
	private Juego juego;
	private Usuario userGuerrerosZ;
	private Usuario userEnemigosDeLaTierra;
	private int altoTablero;
	private int anchoTablero;
	@Before
	public void setUp() throws Exception {
		userGuerrerosZ = new Usuario(new Equipo("Guerreros Z", new Goku(), new Gohan(), new Piccolo()),
				"Tomas");
		
		userEnemigosDeLaTierra = new Usuario(new Equipo("Enemigos de la Tierra", new Cell(), new Freezer(), new MajinBoo()),
				"PC");
		
		altoTablero = 10;
		anchoTablero = 10;
		juego = new Juego(altoTablero, anchoTablero, userGuerrerosZ, userEnemigosDeLaTierra);
		tablero = juego.getTablero();
	}

	@Test
	public void testTurnoOtorgueKiParaHabilidadYRealizarAtaques() {
		int filaGohan = 0;
		int columnaGohan = 5;
		juego.seleccionarPersonajeEnPosicion(filaGohan, columnaGohan);
		filaGohan = 2;
		columnaGohan = 5;
		juego.moverPersonajeSeleccionadoHacia(filaGohan, columnaGohan);
		juego.pasarTurno();
		
		int filaFreezer = 9;
		int columnaFreezer = 5;
		juego.seleccionarPersonajeEnPosicion(filaFreezer, columnaFreezer);
		filaFreezer = 6;
		columnaFreezer = 5;
		juego.moverPersonajeSeleccionadoHacia(filaFreezer, columnaFreezer);
		juego.pasarTurno();

		Celda celdaGohan = tablero.obtenerCelda(filaGohan, columnaGohan);
		juego.seleccionarPersonajeDeLaCelda(celdaGohan);
		gohan = (Gohan) juego.personajeSeleccionado();
		filaGohan = 4;
		columnaGohan = 5;
		juego.moverPersonajeSeleccionadoHacia(filaGohan, columnaGohan);
		ArrayList<Personaje> atacables = juego.obtenerPersonajesAtacablesDelSeleccionado();
		freezer = (Freezer) atacables.get(0);
		assertTrue(juego.personajeSeleccionadoTieneAtaqueEspecialDisponible());
		juego.personajeSeleccionadoAtaqueEspecialA(freezer);
		double vidaEsperada = freezer.getVidaMaxima() - gohan.getPoder()*1.25;
		assertEquals(vidaEsperada,freezer.getVida(),0.1);
		juego.pasarTurno();
		
		juego.seleccionarPersonajeEnPosicion(filaFreezer, columnaFreezer);
		atacables = juego.obtenerPersonajesAtacablesDelSeleccionado();
		gohan = (Gohan) atacables.get(0);
		juego.personajeSeleccionadoAtacaA(gohan);
		vidaEsperada = gohan.getVidaMaxima() - freezer.getPoder();
		assertEquals(vidaEsperada,gohan.getVida(),0.1);
	}
	@Test
	public void testAgarrarConsumibleLoRemueveDePosicion() {
		tablero = juego.getTablero();
		Celda celdaGohan = tablero.obtenerCelda(0,5);
		gohan = (Gohan)celdaGohan.getFicha();
		int filaNube = 2;
		int columnaNube = 5;
		int velocidadDuplicada = gohan.getVelocidad()*2;
		tablero.colocarFicha(new NubeVoladora(),filaNube,columnaNube);
		juego.seleccionarPersonajeDeLaCelda(celdaGohan);
		celdaGohan = tablero.obtenerCelda(filaNube, columnaNube);
		juego.moverPersonajeSeleccionadoACelda(celdaGohan);
		assertEquals(velocidadDuplicada, gohan.getVelocidad());
		juego.pasarTurno();
		
		Celda celdaFreezer = tablero.obtenerCelda(9, 5);
		juego.seleccionarPersonajeDeLaCelda(celdaFreezer);
		celdaFreezer = tablero.obtenerCelda(5, 5);
		juego.moverPersonajeSeleccionadoACelda(celdaFreezer);
		juego.pasarTurno();
		
		juego.seleccionarPersonajeDeLaCelda(celdaGohan);
		celdaGohan = tablero.obtenerCelda(4, 5);
		juego.moverPersonajeSeleccionadoACelda(celdaGohan);
		juego.pasarTurno();
		
		juego.seleccionarPersonajeDeLaCelda(celdaFreezer);
		freezer = (Freezer) juego.personajeSeleccionado();
		int velocidadInicial = freezer.getVelocidad();
		tablero.moverFicha(freezer, filaNube, columnaNube);
		assertEquals(velocidadInicial, freezer.getVelocidad());
	}

}
