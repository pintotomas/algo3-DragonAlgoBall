package dab.tests.movimiento;

import org.junit.Test;

import dab.juego.Tablero;
import dab.personaje.Personaje;
import dab.dragonBallExceptions.CeldaOcupada;
import dab.estados.cell.Cell;
import dab.estados.goku.Goku;
public class moverACeldaOcupadaPorUnPersonaje {

	@Test(expected=CeldaOcupada.class)
	public void testMoverACeldaOcupada() {
		Tablero tablero = new Tablero();
		Personaje goku = new Personaje(new Goku());
		int filaGoku = 1;
		int columnaGoku = 1;
		Personaje cell = new Personaje(new Cell());
		int filaCell = 2;
		int columnaCell = 1;
		tablero.colocarPersonaje(filaGoku, columnaGoku, goku);
		tablero.colocarPersonaje(filaCell, columnaCell, cell);
		goku.mover(tablero.obtenerCelda(2, 1));
	}

}
