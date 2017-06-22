package dab.tests.potenciadores;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dab.juego.Tablero;
import dab.personajes.Goku.Goku;
import dab.potenciadores.NubeVoladora;

public class NubeVoladoraTests {
	private Goku goku;
	private Tablero tablero;
	private NubeVoladora nube = new NubeVoladora();
	private int columnaNube = 1;
	private int filaNube = 1;
	private int filaGoku = 0;
	private int columnaGoku = 0;
	
	@Before
	public void setUp() throws Exception {
		goku = new Goku();
		tablero = new Tablero(5,5);
		tablero.colocarFicha(nube, filaNube, columnaNube);
		tablero.colocarFicha(goku, filaGoku, columnaGoku);	
	}

	@Test
	public void testAgarrarNubeOtorgaVelocidadEsperada() {
		int velocidadEsperada = goku.getVelocidad()*2;
		tablero.moverFicha(goku, filaNube, columnaNube);
		assertEquals(velocidadEsperada, goku.getVelocidad());
	}

	@Test
	public void testVelocidadOtorgadaPermaneceAlPasarUnTurno() {
		int velocidadEsperada = goku.getVelocidad()*2;
		tablero.moverFicha(goku, filaNube, columnaNube);
		goku.nuevoTurno();
		assertEquals(velocidadEsperada, goku.getVelocidad());
	}
	@Test
	public void testPoderOtorgadoPorEsferaDesapareceAlPasarDosTurnos() {
		int velocidadInicial = goku.getVelocidad();
		tablero.moverFicha(goku, filaNube, columnaNube);
		goku.nuevoTurno();
		goku.nuevoTurno();
		goku.nuevoTurno();
		goku.nuevoTurno();
		assertEquals(velocidadInicial, goku.getVelocidad());
	}
}
