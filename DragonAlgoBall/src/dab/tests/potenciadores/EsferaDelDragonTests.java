package dab.tests.potenciadores;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dab.juego.Tablero;
import dab.personajes.Goku.Goku;
import dab.personajes.cell.Cell;
import dab.potenciadores.EsferaDelDragon;

public class EsferaDelDragonTests {

	private Goku goku;
	private Cell cell;
	private Tablero tablero;
	private EsferaDelDragon esfera = new EsferaDelDragon();
	private int columnaEsfera = 1;
	private int filaEsfera = 1;
	private int filaCell = 0;
	private int columnaCell = 1;
	private int filaGoku = 0;
	private int columnaGoku = 0;
	
	@Before
	public void setUp() throws Exception {
		goku = new Goku();
		cell = new Cell();
		tablero = new Tablero(5,5);
		tablero.colocarPotenciador(esfera, filaEsfera, columnaEsfera);
		tablero.colocarFichaMovil(goku, filaGoku, columnaGoku);	
		tablero.colocarFichaMovil(cell, filaCell, columnaCell);
	}

	@Test
	public void testAgarrarEsferaOtorgaPoderEsperado() {
		double vidaCellInicial = cell.getVida();
		double ataqueEsperado = goku.getPoder()*1.25;
		tablero.moverFicha(goku, filaEsfera, columnaEsfera);
		goku.atacarA(cell);
		double vidaCellPerdida = vidaCellInicial - cell.getVida();
		assertEquals(ataqueEsperado, vidaCellPerdida, 0.1);
	}

	@Test
	public void testPoderOtorgadoPorEsferaDesapareceAlPasarDosTurnos() {
		double ataqueInicial = goku.getPoder();
		tablero.moverFicha(goku, filaEsfera, columnaEsfera);
		goku.atacarA(cell);
		goku.atacarA(cell);
		assertEquals(ataqueInicial, goku.getPoder(), 0.1);
	}
}
