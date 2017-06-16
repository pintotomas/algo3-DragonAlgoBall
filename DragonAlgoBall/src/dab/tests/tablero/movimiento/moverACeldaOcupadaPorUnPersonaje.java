package dab.tests.tablero.movimiento;

import org.junit.Test;

import dab.dragonBallExceptions.CeldaOcupada;
import dab.juego.Tablero;
import dab.personajes.Personaje;
import dab.personajes.Goku.Goku;
import dab.personajes.cell.Cell;
public class moverACeldaOcupadaPorUnPersonaje {

	@Test(expected=CeldaOcupada.class)
	public void testMoverACeldaOcupada() {
		Tablero tablero = new Tablero(20, 20);
		Personaje goku = new Goku();
		int filaGoku = 1;
		int columnaGoku = 1;
		Personaje cell = new Cell();
		int filaCell = 2;
		int columnaCell = 1;
		tablero.colocarFichaMovil(goku, filaGoku, columnaGoku);
		tablero.colocarFichaMovil(cell, filaCell, columnaCell);
		tablero.moverFicha(goku, 2, 1);
	}

}
