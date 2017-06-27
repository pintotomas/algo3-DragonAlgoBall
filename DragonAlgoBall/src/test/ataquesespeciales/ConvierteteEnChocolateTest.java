package test.ataquesespeciales;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dab.equipo.Equipo;
import dab.juego.Tablero;
import dab.personajes.Goku.Goku;
import dab.personajes.majinBoo.MajinBoo;
import dab.potenciadores.Inutilizador;

public class ConvierteteEnChocolateTest {
	
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
	}

	@Test
	public void testConvertirGokuEnChocolateModificaAlcanceYVelocidad() {
		majinboo.modificarKi(30);
		majinboo.ataqueEspecial(goku);
		Assert.assertEquals(0,goku.getAlcance());
		Assert.assertEquals(0,goku.getVelocidad());
		
	}
	
	@Test
	public void testConvertirEnChocolateYPasarTurnosHastaFinalizarEfectoRestauraAtributosDeGoku(){
		majinboo.modificarKi(30);
		majinboo.ataqueEspecial(goku);
		
		double turnosInutilizador = new Inutilizador().getDuracionTurnos();
		for (int i = 0; i < turnosInutilizador; i ++){
			guerrerosZ.nuevoTurno();
		}
		Assert.assertEquals(2, goku.getVelocidad());
		Assert.assertEquals(0, goku.getKi());
		Assert.assertEquals(2, goku.getAlcance());
	}

}
