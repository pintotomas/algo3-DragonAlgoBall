package dab.tests.ataquesespeciales;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dab.equipo.Equipo;
import dab.juego.Tablero;
import dab.personajes.Piccolo.Piccolo;
import dab.personajes.cell.Cell;

public class MakankosappoTests {


	private Cell cell;
	private Piccolo piccolo;
	private Equipo enemigos, guerrerosZ;
	private Tablero tablero;
	
	private int anchoTablero = 20;
	private int altoTablero = 20;
	private int filaPiccolo = 1;
	private int filaCell = 1;
	private int columnaPiccolo = 1;
	private int columnaCell = 2;
	private double danoHabilidad;
	private int kiParaMakankosappo = 10;
	
	@Before
	public void setUp() throws Exception {
		cell = new Cell();
		enemigos = new Equipo("Enemigos de la Tierra");
		enemigos.agregarPersonaje(cell);
		piccolo = new Piccolo();
		guerrerosZ = new Equipo("Guerreros Z");
		guerrerosZ.agregarPersonaje(piccolo);
		tablero = new Tablero(altoTablero,anchoTablero, guerrerosZ, enemigos);
		tablero.colocarFichaMovil(piccolo, filaPiccolo, columnaPiccolo);
		tablero.colocarFichaMovil(cell, filaCell, columnaCell);
		danoHabilidad = piccolo.getPoder()*1.25;
	}

	@Test
	public void testNoSePuedeLanzarMakankosappoSinKiNecesario() {
		assertFalse(piccolo.ataqueEspecialDisponible());
	}
	
	@Test
	public void testMakankosappoCuestaKiEsperado() {
		int kiInicial = 20;
		piccolo.modificarKi(kiInicial);
		piccolo.ataqueEspecial(cell);
		int kiRestanteEsperado = kiInicial-kiParaMakankosappo;
		assertEquals(kiRestanteEsperado, piccolo.getKi());
	}

	@Test
	public void testMakankosappoCausaDanoEsperado() {
		piccolo.modificarKi(kiParaMakankosappo);
		double danoEsperado = danoHabilidad;
		piccolo.ataqueEspecial(cell);
		double danoCausado = cell.getVidaMaxima()-cell.getVida();
		assertEquals(danoEsperado,danoCausado,0.1);
	}
}
