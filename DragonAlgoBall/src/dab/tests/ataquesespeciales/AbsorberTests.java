package dab.tests.ataquesespeciales;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dab.equipo.Equipo;
import dab.juego.Tablero;
import dab.personajes.Goku.Goku;
import dab.personajes.cell.Cell;

public class AbsorberTests {

	private Cell cell;
	private Goku goku;
	private Equipo enemigos, guerrerosZ;
	private Tablero tablero;
	
	private int anchoTablero = 20;
	private int altoTablero = 20;
	
	private int filaGoku = 1;
	private int filaCell = 1;
	private int columnaGoku = 1;
	private int columnaCell = 2;
	private double danoHabilidad;
	private int kiParaAbsorber = 5;
	@Before
	public void setUp() throws Exception {
		cell = new Cell();
		enemigos = new Equipo("Enemigos de la Tierra");
		enemigos.agregarPersonaje(cell);
		goku = new Goku();
		guerrerosZ = new Equipo("Guerreros Z");
		guerrerosZ.agregarPersonaje(goku);
		tablero = new Tablero(altoTablero,anchoTablero, guerrerosZ, enemigos);
		tablero.colocarFichaMovil(goku, filaGoku, columnaGoku);
		tablero.colocarFichaMovil(cell, filaCell, columnaCell);
		danoHabilidad = cell.getPoder();
	}

	@Test
	public void testAbsorberCausaDanoEsperado() {
		cell.modificarKi(kiParaAbsorber);
		double danoEsperado = danoHabilidad;
		cell.ataqueEspecial(goku);
		double danoCausado = goku.getVidaMaxima()-goku.getVida();
		assertEquals(danoEsperado,danoCausado,0.1);
	}
	@Test
	public void testNoSePuedeAbsorberSinKiNecesario() {
		//Comienza sin ki.
		assertFalse(cell.ataqueEspecialDisponible());
	}
	
	@Test
	public void testAbsorberCuestaKiEsperado() {
		int kiInicial = 20;
		cell.modificarKi(kiInicial);
		cell.ataqueEspecial(goku);
		int kiRestanteEsperado = kiInicial-kiParaAbsorber;
		assertEquals(kiRestanteEsperado, cell.getKi());
	}

	@Test
	public void testAbsorberCuraCantidadEsperada() {
		cell.modificarVida(-20);
		cell.modificarKi(kiParaAbsorber);
		cell.ataqueEspecial(goku);
		double vidaEsperada = cell.getVidaMaxima();
		assertEquals(vidaEsperada,cell.getVida(),0.1);
	}
	
	@Test
	public void testAbsorberNoCuraMasDeVidaMaxima() {
		cell.modificarKi(kiParaAbsorber);
		cell.ataqueEspecial(goku);
		double vidaEsperada = cell.getVidaMaxima();
		assertEquals(vidaEsperada,cell.getVida(),0);
	}

}
