package dab.tests.tablero;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import dab.dragonBallExceptions.MovimientoInvalido;
import dab.estados.gohan.GohanBase;
import dab.estados.goku.GokuBase;
import dab.juego.Tablero;
public class PruebasTablero{

	@Test
	public void testPosicionInicialCorrecta() {
		Tablero tableroDab = new Tablero();
		GokuBase goku = new GokuBase();
		tableroDab.colocarPersonaje(5, 6, goku);
		assertEquals(tableroDab.filaPersonaje(goku), 5);
		assertEquals(tableroDab.columnaPersonaje(goku), 6);
		
	}
	@Test
	public void testMoverPersonajeLoDesplaza(){
		Tablero tableroDab = new Tablero();
		GokuBase goku = new GokuBase();
		tableroDab.colocarPersonaje(5, 6, goku);
		tableroDab.moverPersonaje(4, 5, goku);
		assertEquals(tableroDab.filaPersonaje(goku), 4);
		assertEquals(tableroDab.columnaPersonaje(goku), 5);
	}
	@Test
	public void testMoverPersonajeDejaLibreCeldaAnterior(){
		Tablero tableroDab = new Tablero();
		GokuBase goku = new GokuBase();
		tableroDab.colocarPersonaje(5, 6, goku);
		tableroDab.moverPersonaje(4, 5, goku);
		assertFalse(tableroDab.celdaOcupada(5, 6));
	}

	@Test
	public void testMoverPersonajeHorizontalAlcanceMaximo(){
		Tablero tableroDab = new Tablero();
		GokuBase goku = new GokuBase();
		tableroDab.colocarPersonaje(5, 6, goku);
		tableroDab.moverPersonaje(5 + goku.getVelocidad(), 6, goku);
		assertEquals(tableroDab.filaPersonaje(goku), 5+ goku.getVelocidad());
		assertEquals(tableroDab.columnaPersonaje(goku), 6);
	}
	
	@Test
	public void testMoverPersonajeVerticalAlcanceMaximo(){
		Tablero tableroDab = new Tablero();
		GokuBase goku = new GokuBase();
		tableroDab.colocarPersonaje(5, 6, goku);
		tableroDab.moverPersonaje(5, 6 + goku.getVelocidad(), goku);
		assertEquals(tableroDab.filaPersonaje(goku), 5);
		assertEquals(tableroDab.columnaPersonaje(goku), 6 + goku.getVelocidad());
	}
	@Test
	public void testMoverPersonajeDiagonalAlcanceMaximo(){
		Tablero tableroDab = new Tablero();
		GokuBase goku = new GokuBase();
		tableroDab.colocarPersonaje(5, 6, goku);
		tableroDab.moverPersonaje(5 + ((int)(goku.getVelocidad())), 6 + ((int)(goku.getVelocidad())), goku);
		assertEquals(tableroDab.filaPersonaje(goku), 5 + ((int)(goku.getVelocidad())));
		assertEquals(tableroDab.columnaPersonaje(goku), 6 + ((int)(goku.getVelocidad())));
	}
	@Test(expected = MovimientoInvalido.class)
	public void testMoverseHorizontalMayorQueAlcanceLanzaMovimientoInvalido(){
		Tablero tableroDab = new Tablero();
		GokuBase goku = new GokuBase();
		tableroDab.colocarPersonaje(5, 6, goku);
		tableroDab.moverPersonaje(5 + goku.getVelocidad() + 1, 6 , goku);
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void testMoverPersonajeVerticalMayorQueAlcanceLanzaMovimientoInvalido(){
		Tablero tableroDab = new Tablero();
		GokuBase goku = new GokuBase();
		tableroDab.colocarPersonaje(5, 6, goku);
		tableroDab.moverPersonaje(5, 6 + goku.getVelocidad() + 1, goku);
	}
	@Test(expected = MovimientoInvalido.class)
	public void testMoverPersonajeDiagonalMayorAlcanceMaximo(){
		Tablero tableroDab = new Tablero();
		GokuBase goku = new GokuBase();
		tableroDab.colocarPersonaje(5, 6, goku);
		tableroDab.moverPersonaje(5 + 1 + ((int)(goku.getVelocidad())), 6 + ((int)(goku.getVelocidad())), goku);
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void testMoverPersonajeSobrepasandoOtroLanzaError(){
		Tablero tableroDab = new Tablero();
		GokuBase goku = new GokuBase();
		GohanBase gohan = new GohanBase();
		tableroDab.colocarPersonaje(5, 6, goku);
		tableroDab.colocarPersonaje(6, 6, gohan);
		tableroDab.moverPersonaje(7,6,goku);
	}
	@Test(expected = MovimientoInvalido.class)
	public void testMoverPersonajeSobrepasandoOtroDiagonalLanzaError(){
		Tablero tableroDab = new Tablero();
		GokuBase goku = new GokuBase();
		GohanBase gohan = new GohanBase();
		tableroDab.colocarPersonaje(5, 7, goku);
		tableroDab.colocarPersonaje(6, 6, gohan);
		tableroDab.moverPersonaje(7,5,goku);
	}
	
}
