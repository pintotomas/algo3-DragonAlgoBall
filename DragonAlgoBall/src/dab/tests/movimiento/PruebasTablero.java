package dab.tests.movimiento;

import static org.junit.Assert.*;

import org.junit.Test;

import dab.juego.Tablero;
import dab.personajes.goku.Goku;

public class PruebasTablero{

	@Test
	public void testPosicionInicialCorrecta() {
		Tablero tableroDab = new Tablero(6);
		Goku goku = new Goku();
		tableroDab.colocarPersonaje(5, 6, goku);
		assertEquals(tableroDab.columnaPersonaje(goku), 6);
		assertEquals(tableroDab.filaPersonaje(goku), 5);
		
	}

}
