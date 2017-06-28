package ataquesespeciales;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dab.equipo.Equipo;
import dab.juego.Tablero;
import dab.personajes.Goku.Goku;
import dab.personajes.majinBoo.MajinBoo;

public class KamehamehaTest {
	
		private MajinBoo majinboo;
		private Goku goku;
		private Equipo enemigos, guerrerosZ;
		private Tablero tablero;
		
		private int anchoTablero = 20;
		private int altoTablero = 20;
		
		private int filaGoku = 1;
		private int filaBoo = 1;
		private int columnaGoku = 1;
		private int columnaBoo = 2;
		private int kiParaKamehameha = 20;
		private double danoDeKamehameha;
		
		@Before
		public void setUp() throws Exception {
			majinboo = new MajinBoo();
			enemigos = new Equipo("Enemigos de la Tierra");
			enemigos.agregarPersonaje(majinboo);
			goku = new Goku();
			guerrerosZ = new Equipo("Guerreros Z");
			guerrerosZ.agregarPersonaje(goku);
			tablero = new Tablero(altoTablero,anchoTablero, guerrerosZ, enemigos);
			tablero.colocarFicha(goku, filaGoku, columnaGoku);
			tablero.colocarFicha(majinboo, filaBoo, columnaBoo);
			danoDeKamehameha = goku.getPoder()*1.5;
		}


		@Test
		public void testKamehamehaCausaDanoEsperado() {
			goku.modificarKi(kiParaKamehameha);
			double vidaEnemigaInicial = majinboo.getVida();
			goku.ataqueEspecial(majinboo);
			double danoCausado = vidaEnemigaInicial - majinboo.getVida();
			assertEquals(danoDeKamehameha, danoCausado, 0.1);
		}

		@Test
		public void testKamehamehaCuestaKiEsperado() {
			int kiInicial = 20;
			goku.modificarKi(kiInicial);
			goku.ataqueEspecial(majinboo);
			int kiRestanteEsperado = kiInicial-kiParaKamehameha;
			assertEquals(kiRestanteEsperado,goku.getKi());
		}
		@Test
		public void testNoSePuedeLanzarKamehamehaSinKiNecesario() {
			//Gohan comienza sin ki.
			assertFalse(goku.ataqueEspecialDisponible());
		}
}
