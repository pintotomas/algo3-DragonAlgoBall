package dab.tests.movimiento;

import org.junit.Test;

import dab.dragonBallExceptions.CeldaOcupada;
import dab.estados.cell.CellBase;
import dab.estados.goku.GokuBase;
import dab.juego.Tablero;
import dab.personajes.Personaje;
public class moverACeldaOcupadaPorUnPersonaje {

	@Test(expected=CeldaOcupada.class)
	public void testMoverACeldaOcupada() {
		Tablero tablero = new Tablero();
		Personaje goku = new Personaje(new GokuBase());
		int filaGoku = 1;
		int columnaGoku = 1;
		Personaje cell = new Personaje(new CellBase());
		int filaCell = 2;
		int columnaCell = 1;
		tablero.colocarPersonaje(filaGoku, columnaGoku, goku);
		tablero.colocarPersonaje(filaCell, columnaCell, cell);
		goku.mover(tablero.obtenerCelda(2, 1));
	}

}
