package dab.tests.potenciadores;

import static org.junit.Assert.*;
import org.junit.Test;
import dab.personajes.Goku.Goku;

public class FuriaTests {

	@Test
	public void testFuria() {
		Goku goku = new Goku();
		double poderInicial = goku.getPoder();
		goku.agregarVida(-450);
		assertEquals(poderInicial*1.2, goku.getPoder(), 0.5);
		goku.agregarVida(450);
		assertEquals(poderInicial, goku.getPoder(), 0.5);
	}

}
