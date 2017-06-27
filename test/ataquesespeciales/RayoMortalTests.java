package test.ataquesespeciales;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dab.equipo.Equipo;
import dab.juego.Tablero;
import dab.personajes.Goku.Goku;
import dab.personajes.Freezer.Freezer;


public class RayoMortalTests {

	private Freezer freezer;
	private Goku goku;
	private Equipo enemigos, guerrerosZ;
	private Tablero tablero;
	
	private int anchoTablero = 20;
	private int altoTablero = 20;
	
	private int filaGoku = 1;
	private int filaCell = 1;
	private int columnaGoku = 1;
	private int columnaCell = 2;
	private double danoHabilidad;
	private int kiParaRayoMortal = 20;
	@Before
	public void setUp() throws Exception {
		freezer = new Freezer();
		enemigos = new Equipo("Enemigos de la Tierra");
		enemigos.agregarPersonaje(freezer);
		goku = new Goku();
		guerrerosZ = new Equipo("Guerreros Z");
		guerrerosZ.agregarPersonaje(goku);
		tablero = new Tablero(altoTablero,anchoTablero, guerrerosZ, enemigos);
		tablero.colocarFicha(goku, filaGoku, columnaGoku);
		tablero.colocarFicha(freezer, filaCell, columnaCell);
		danoHabilidad = freezer.getPoder()*1.5;
	}

	@Test
	public void testRayoMOrtalCausaDanoEsperado() {
		freezer.modificarKi(kiParaRayoMortal);
		double danoEsperado = danoHabilidad;
		freezer.ataqueEspecial(goku);
		double danoCausado = goku.getVidaMaxima()-goku.getVida();
		assertEquals(danoEsperado,danoCausado,0.1);
	}
	@Test
	public void testNoSePuedeLanzarRayoMortalSinKiNecesario() {
		//Comienza sin ki.
		assertFalse(freezer.ataqueEspecialDisponible());
	}
	
	@Test
	public void testRayoMortalCuestaKiEsperado() {
		int kiInicial = 20;
		freezer.modificarKi(kiInicial);
		freezer.ataqueEspecial(goku);
		int kiRestanteEsperado = kiInicial-kiParaRayoMortal;
		assertEquals(kiRestanteEsperado, freezer.getKi());
	}
}


