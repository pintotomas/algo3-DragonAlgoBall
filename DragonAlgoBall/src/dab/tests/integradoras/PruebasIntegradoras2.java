package dab.tests.integradoras;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dab.equipo.Equipo;
import dab.juego.Celda;
import dab.juego.Juego;
import dab.juego.Tablero;
import dab.juego.Turno;
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
	private Turno turno;
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
	}

	@Test
	public void testTurnoOtorgueKiParaHabilidadYRealizarAtaques() {
		tablero = juego.getTablero();
		turno = juego.getTurno();
		Celda celdaGohan = tablero.obtenerCelda(0,5);
		gohan = (Gohan)celdaGohan.getFicha();
		tablero.moverFicha(gohan, 2, 5);
		juego.pasarTurno();
		
		turno = juego.getTurno();
		Celda celdaFreezer = tablero.obtenerCelda(9, 5);
		freezer = (Freezer)celdaFreezer.getFicha();
		tablero.moverFicha(freezer, 6, 5);
		turno.seleccionarPersonaje(freezer);
		juego.pasarTurno();
		
		turno = juego.getTurno();
		tablero.moverFicha(gohan, 4, 5);
		turno.seleccionarPersonaje(gohan);
		assertTrue(gohan.ataqueEspecialDisponible());
		gohan.ataqueEspecial(freezer);
		double vidaEsperada = freezer.getVidaMaxima() - gohan.getPoder()*1.25;
		assertEquals(vidaEsperada,freezer.getVida(),0.1);
		juego.pasarTurno();
		
		turno = juego.getTurno();
		turno.seleccionarPersonaje(freezer);
		freezer.atacarA(gohan);
		vidaEsperada = gohan.getVidaMaxima() - freezer.getPoder();
		assertEquals(vidaEsperada,gohan.getVida(),0.1);
	}
	@Test
	public void testAgarrarConsumibleLoRemueveDePosicion() {
		tablero = juego.getTablero();
		turno = juego.getTurno();
		Celda celdaGohan = tablero.obtenerCelda(0,5);
		gohan = (Gohan)celdaGohan.getFicha();
		int filaNube = 2;
		int columnaNube = 5;
		int velocidadDuplicada = gohan.getVelocidad()*2;
		tablero.colocarPotenciador(new NubeVoladora(),filaNube,columnaNube);
		tablero.moverFicha(gohan, filaNube, columnaNube);
		assertEquals(velocidadDuplicada, gohan.getVelocidad());
		juego.pasarTurno();
		
		turno = juego.getTurno();
		Celda celdaFreezer = tablero.obtenerCelda(9, 5);
		freezer = (Freezer)celdaFreezer.getFicha();
		tablero.moverFicha(freezer, 6, 5);
		turno.seleccionarPersonaje(freezer);
		juego.pasarTurno();
		
		turno = juego.getTurno();
		tablero.moverFicha(gohan, 5, 5);
		juego.pasarTurno();
		
		turno = juego.getTurno();
		int velocidadInicial = freezer.getVelocidad();
		tablero.moverFicha(freezer, filaNube, columnaNube);
		assertEquals(velocidadInicial, freezer.getVelocidad());
	}

}
