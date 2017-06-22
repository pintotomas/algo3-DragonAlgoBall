package dab.tests.tablero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import dab.juego.Tablero;
import dab.personajes.Goku.Goku;
public class PruebasTablero{

	@Test
	public void testCoordenadasDelPersonajeCorrectasAlPosicionarEnTablero() {
		Tablero tableroDab = new Tablero(20, 20);
		Goku goku = new Goku();
		tableroDab.colocarFicha(goku, 5, 6);
		assertEquals(tableroDab.getFilaDeLaFicha(goku), 5);
		assertEquals(tableroDab.getColumnaDeLaFicha(goku), 6);
		
	}
	@Test
	public void testCoordenadasActualizadasAlMoverPersonaje(){ 
		Tablero tableroDab = new Tablero(20, 20);
		Goku goku = new Goku();
		tableroDab.colocarFicha(goku, 5, 6);
		tableroDab.colocarFicha(goku, 4, 5);
		assertEquals(tableroDab.getFilaDeLaFicha(goku), 4);
		assertEquals(tableroDab.getColumnaDeLaFicha(goku), 5);
	}
	@Test
	public void testCeldaAnteriorQuedaLibreAlMoverPersonaje(){ 
		Tablero tableroDab = new Tablero(20, 20);
		Goku goku = new Goku();
		tableroDab.colocarFicha(goku, 5, 6);
		tableroDab.moverFicha(goku, 4, 5);
		assertFalse(tableroDab.celdaOcupada(5, 6));
	}
}
