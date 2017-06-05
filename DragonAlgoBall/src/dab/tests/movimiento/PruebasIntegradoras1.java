package dab.tests.movimiento;

import org.junit.Assert;
import org.junit.Test;

import dab.dragonBallExceptions.CeldaOcupada;
import dab.juego.Tablero;
import dab.personajes.Personaje;
import dab.personajes.cell.Cell;
import dab.personajes.goku.Goku;

public class PruebasIntegradoras1 {
	Tablero tablero = new Tablero();
	Personaje goku = new Goku();
	int filaGoku = 1;
	int columnaGoku = 1;
	Personaje cell = new Cell();
	int filaCell = 2;
	int columnaCell = 1;

	@Test 
	public void testTransformarPersonaje() {
		goku.agregarKi(20);
		Assert.assertTrue(goku.transformarDisponible());
		goku = goku.transformar();
		Assert.assertEquals(goku.getNombre(), "Goku Kaio-Ken");
		Assert.assertEquals(goku.getPosicion().getFila(), filaGoku);
		Assert.assertEquals(goku.getPosicion().getColumna(), columnaGoku);
		Assert.assertEquals(goku.getPoder(), 40);
	}

	@Test(expected=CeldaOcupada.class)
	public void testMoverACeldaOcupada() {
		
		tablero.colocarPersonaje(filaGoku, columnaGoku, goku);
		tablero.colocarPersonaje(filaCell, columnaCell, cell);
		goku.mover(tablero.obtenerCelda(2, 1));
	}

}
