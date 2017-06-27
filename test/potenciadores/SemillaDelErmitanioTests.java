package potenciadores;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dab.juego.Tablero;
import dab.personajes.Goku.Goku;
import dab.potenciadores.SemillaDelErmitanio;

public class SemillaDelErmitanioTests {
	private Goku goku;
	private Tablero tablero;
	private SemillaDelErmitanio semilla = new SemillaDelErmitanio();
	private int columnaSemilla = 1;
	private int filaSemilla = 1;
	private int filaGoku = 0;
	private int columnaGoku = 0;
	@Before
	public void setUp() throws Exception {
		goku = new Goku();
		tablero = new Tablero(5,5);
		tablero.colocarFicha(semilla, filaSemilla, columnaSemilla);
		tablero.colocarFicha(goku, filaGoku, columnaGoku);	
	}

	@Test
	public void testSemillaCuraVidaEsperada() {
		goku.modificarVida(-100);
		tablero.moverFicha(goku, filaSemilla, columnaSemilla);
		double vidaEsperada = goku.getVidaMaxima();
		assertEquals(vidaEsperada, goku.getVida(), 0);
	}
	@Test
	public void testSemillaNoCuraMasQueVidaMaxima() {
		tablero.moverFicha(goku, filaSemilla, columnaSemilla);
		assertEquals(goku.getVidaMaxima(), goku.getVida(), 0);
	}
}
