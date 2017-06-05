package dab.tests.movimiento;

import org.junit.Test;

import dab.juego.Celda;
import dab.juego.Tablero;
import dab.personajes.Personaje;
import dab.personajes.piccolo.Piccolo;

public class MoverPersonaje {

	@Test 
	public void moverPersonaje() {
		Tablero tablero = new Tablero();
		Personaje piccolo = new Piccolo();
		tablero.colocarPersonaje(1, 1, piccolo);
		Celda destino = tablero.obtenerCelda(1, 2);
		assert(piccolo.movimientoPosible(destino));
		piccolo.mover(destino);
		assert(destino.darOcupante() == piccolo);
	}	
}