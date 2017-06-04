package dab.tests.movimiento;

import static org.junit.Assert.*;

import org.junit.Test;

import dab.juego.Tablero;
import dab.personajes.goku.Goku;

public class PruebasTablero{

	@Test
	public void testPosicionInicialCorrecta() {
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarPersonaje(5, 6, goku);
		assertEquals(tableroDab.filaPersonaje(goku), 5);
		assertEquals(tableroDab.columnaPersonaje(goku), 6);
		
	}
	@Test
	public void testMoverseDesplazaPersonaje(){
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarPersonaje(5, 6, goku);
		tableroDab.moverPersonaje(4, 5, goku);
		assertEquals(tableroDab.filaPersonaje(goku), 4);
		assertEquals(tableroDab.columnaPersonaje(goku), 5);
	}
	@Test
	public void testMoverseDejaLibreCeldaAnterior(){
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarPersonaje(5, 6, goku);
		tableroDab.moverPersonaje(4, 5, goku);
		assertFalse(tableroDab.celdaOcupada(5, 6));
	}

	@Test
	public void testMoverseHorizontalAlcanceMaximo(){
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarPersonaje(5, 6, goku);
		tableroDab.moverPersonaje(5 + goku.getVelocidad(), 6, goku);
		assertEquals(tableroDab.filaPersonaje(goku), 5+ goku.getVelocidad());
		assertEquals(tableroDab.columnaPersonaje(goku), 6);
	}
	
	@Test
	public void testMoverseVerticalAlcanceMaximo(){
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarPersonaje(5, 6, goku);
		tableroDab.moverPersonaje(5, 6 + goku.getVelocidad(), goku);
		assertEquals(tableroDab.filaPersonaje(goku), 5);
		assertEquals(tableroDab.columnaPersonaje(goku), 6 + goku.getVelocidad());
	}
	@Test
	public void testMoverseDiagonalAlcanceMaximo(){
		Tablero tableroDab = new Tablero();
		Goku goku = new Goku();
		tableroDab.colocarPersonaje(5, 6, goku);
		tableroDab.moverPersonaje(5 + ((int)(goku.getVelocidad()/2)), 6 + ((int)(goku.getVelocidad()/2)), goku);
		assertEquals(tableroDab.filaPersonaje(goku), 5 + ((int)(goku.getVelocidad()/2)));
		assertEquals(tableroDab.columnaPersonaje(goku), 6 + ((int)(goku.getVelocidad()/2)));
	}
}
