package dab.tests.movimiento;

import org.junit.Test;

import dab.dragonBallExceptions.CeldaOcupada;
import dab.juego.Tablero;
import dab.personajes.Personaje;
import dab.personajes.Goku.Goku;
import dab.personajes.cell.Cell;
public class moverACeldaOcupadaPorUnPersonaje {

	@Test(expected=CeldaOcupada.class)
	public void testMoverACeldaOcupada() {
		Tablero tablero = new Tablero();
		Personaje goku = new Goku();
		int filaGoku = 1;
		int columnaGoku = 1;
		Personaje cell = new Cell();
		int filaCell = 2;
		int columnaCell = 1;
		tablero.colocarPersonaje(goku, filaGoku, columnaGoku);
		tablero.colocarPersonaje(cell, filaCell, columnaCell);
		goku.mover(tablero.obtenerCelda(2, 1));
	}

}
