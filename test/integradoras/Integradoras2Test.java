package integradoras;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import dab.equipo.Equipo;
import dab.juego.Celda;
import dab.juego.Juego;
import dab.juego.Tablero;
import dab.personajes.Freezer.Freezer;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Goku.Goku;
import dab.personajes.Piccolo.Piccolo;
import dab.personajes.cell.Cell;
import dab.personajes.majinBoo.MajinBoo;
import dab.potenciadores.NubeVoladora;
import dab.usuario.Usuario;

public class Integradoras2Test {

	private Tablero tablero;
	private Juego juego;
	private Usuario userGuerrerosZ;
	private Usuario userEnemigosDeLaTierra;
	private int altoTablero;
	private int anchoTablero;
	private Goku goku = new Goku();
	private Gohan gohan = new Gohan();
	private Piccolo piccolo = new Piccolo();
	private Freezer freezer = new Freezer();
	private Cell cell = new Cell();
	private MajinBoo majinboo = new MajinBoo();
	@Before
	public void setUp() throws Exception {
		
		userGuerrerosZ = new Usuario(new Equipo("Guerreros Z", goku, gohan, piccolo),
				"Tomas");
		
		userEnemigosDeLaTierra = new Usuario(new Equipo("Enemigos de la Tierra", freezer, cell, majinboo),
				"PC");
		
		altoTablero = 8;
		anchoTablero = 8;
		juego = new Juego(altoTablero, anchoTablero, userGuerrerosZ, userEnemigosDeLaTierra);
		tablero = juego.getTablero();
	}

	@Test
	public void testTurnoOtorgueKiParaHabilidadYRealizarAtaques() {
		juego.seleccionarPersonajeDeLaCelda((Celda)gohan.getPosicion());
		int filaGohan = 3;
		int columnaGohan = 2;
		juego.moverPersonajeSeleccionadoHacia(filaGohan, columnaGohan);
		juego.pasarTurno();
		
		juego.seleccionarPersonajeDeLaCelda((Celda)freezer.getPosicion());
		int filaFreezer = 3;
		int columnaFreezer = 4;
		juego.moverPersonajeSeleccionadoHacia(filaFreezer, columnaFreezer);
		juego.pasarTurno();

		Celda celdaGohan = tablero.obtenerCelda(filaGohan, columnaGohan);
		juego.seleccionarPersonajeDeLaCelda(celdaGohan);
		filaGohan = 3;
		columnaGohan = 3;
		juego.moverPersonajeSeleccionadoHacia(filaGohan, columnaGohan);
		assertTrue(juego.personajeSeleccionadoTieneAtaqueEspecialDisponible());
		juego.personajeSeleccionadoAtaqueEspecialA(freezer);
		double vidaEsperada = freezer.getVidaMaxima() - gohan.getPoder()*1.25;
		assertEquals(vidaEsperada,freezer.getVida(),0.1);
		
		juego.seleccionarPersonajeDeLaCelda((Celda)freezer.getPosicion());
		juego.personajeSeleccionadoAtacaA(gohan);
		vidaEsperada = gohan.getVidaMaxima() - freezer.getPoder();
		assertEquals(vidaEsperada,gohan.getVida(),0.1);
	}
	@Test
	public void testAgarrarConsumibleLoRemueveDePosicion() {
		tablero = juego.getTablero();
		Celda celdaGohan = (Celda) gohan.getPosicion();
		gohan = (Gohan)celdaGohan.getFicha();
		int filaNube = 3;
		int columnaNube = 2;
		int velocidadDuplicada = gohan.getVelocidad()*2;
		tablero.colocarFicha(new NubeVoladora(),filaNube,columnaNube);
		juego.seleccionarPersonajeDeLaCelda(celdaGohan);
		celdaGohan = tablero.obtenerCelda(filaNube, columnaNube);
		juego.moverPersonajeSeleccionadoACelda(celdaGohan);
		assertEquals(velocidadDuplicada, gohan.getVelocidad());
		juego.pasarTurno();
		Celda celdaFreezer = (Celda) freezer.getPosicion();
		juego.seleccionarPersonajeDeLaCelda(celdaFreezer);
		celdaFreezer = tablero.obtenerCelda(3, 4);
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
