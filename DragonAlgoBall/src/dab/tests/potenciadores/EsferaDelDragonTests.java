package dab.tests.potenciadores;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dab.juego.Tablero;
import dab.personajes.Goku.Goku;
import dab.potenciadores.EsferaDelDragon;

public class EsferaDelDragonTests {

	private Goku goku;
	private Tablero tablero;
	private EsferaDelDragon esfera;
	private int columnaEsfera;
	private int filaEsfera;
	
	@Before
	public void setUp() throws Exception {
		goku = new Goku();
		tablero = new Tablero(5,5);
		tablero.colocarFichaMovil(ficha, fila, columna);
		
	
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
