package dab.tests.movimiento;

import org.junit.Test;

import dab.juego.Celda;
import dab.juego.Tablero;
import dab.personajes.Personaje;
import dab.personajes.Piccolo.Piccolo;

public class MoverPersonaje {

	@Test 
	public void moverPersonaje() {
		Tablero tablero = new Tablero();
		Personaje piccolo = new Piccolo();
		tablero.colocarFichaMovil(piccolo, 1, 1);
		Celda destino = tablero.obtenerCelda(1, 2);
		assert(piccolo.movimientoPosible(destino));
		tablero.moverFicha(piccolo,  1, 2);
		assert(destino.getFicha() == piccolo);
	}	
}