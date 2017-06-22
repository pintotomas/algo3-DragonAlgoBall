package dab.tests.ataquesespeciales;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dab.equipo.Equipo;
import dab.juego.Tablero;
import dab.personajes.Gohan.Gohan;
import dab.personajes.majinBoo.MajinBoo;

public class MasenkoTests {

	private MajinBoo majinboo;
	private Gohan gohan;
	private Equipo enemigos, guerrerosZ;
	private Tablero tablero;
	
	private int anchoTablero = 20;
	private int altoTablero = 20;
	
	private int filaGohan = 1;
	private int filaBoo = 1;
	private int columnaGohan = 1;
	private int columnaBoo = 2;
	private int kiParaMasenko = 10;
	private double danoDeMasenko;
	
	@Before
	public void setUp() throws Exception {
		majinboo = new MajinBoo();
		enemigos = new Equipo("Enemigos de la Tierra");
		enemigos.agregarPersonaje(majinboo);
		gohan = new Gohan();
		guerrerosZ = new Equipo("Guerreros Z");
		guerrerosZ.agregarPersonaje(gohan);
		tablero = new Tablero(altoTablero,anchoTablero, guerrerosZ, enemigos);
		tablero.colocarFicha(gohan, filaGohan, columnaGohan);
		tablero.colocarFicha(majinboo, filaBoo, columnaBoo);
		danoDeMasenko = gohan.getPoder()*1.25;
	}


	@Test
	public void testMasenkoCausaDanoEsperado() {
		gohan.modificarKi(kiParaMasenko);
		double vidaEnemigaInicial = majinboo.getVida();
		gohan.ataqueEspecial(majinboo);
		double danoCausado = vidaEnemigaInicial - majinboo.getVida();
		assertEquals(danoDeMasenko, danoCausado, 0.1);
	}

	@Test
	public void testMasenkoCuestaKiEsperado() {
		int kiInicial = 20;
		gohan.modificarKi(kiInicial);
		gohan.ataqueEspecial(majinboo);
		int kiRestanteEsperado = kiInicial-kiParaMasenko;
		assertEquals(kiRestanteEsperado ,gohan.getKi());
	}
	@Test
	public void testNoSePuedeLanzarMasenkoSinKiNecesario() {
		//Gohan comienza sin ki.
		assertFalse(gohan.ataqueEspecialDisponible());
	}
}
