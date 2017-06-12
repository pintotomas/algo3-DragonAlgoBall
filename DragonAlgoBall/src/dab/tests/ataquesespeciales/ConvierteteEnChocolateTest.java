package dab.tests.ataquesespeciales;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dab.equipo.Equipo;
import dab.juego.Tablero;
import dab.personajes.Goku.Goku;
import dab.personajes.majinBoo.MajinBoo;

public class ConvierteteEnChocolateTest {
	
	MajinBoo majinboo;
	Goku goku;
	Equipo enemigos, guerrerosz;
	Tablero tablero;
	
	@Before
	public void setUp() throws Exception {
		majinboo = new MajinBoo();
		enemigos = new Equipo("Enemigos de la Tierra");
		enemigos.agregarPersonaje(majinboo);
		goku = new Goku();
		guerrerosz = new Equipo("Guerreros Z");
		guerrerosz.agregarPersonaje(goku);
		tablero = new Tablero();
		tablero.colocarPersonaje(1,1,goku);
		tablero.colocarPersonaje(1,2,majinboo);
	}

	@Test
	public void testSeConvierteEnChocolate() {
		majinboo.agregarKi(30);
		majinboo.ataqueEspecial(goku);
		Assert.assertEquals(0,goku.getAlcance());
		Assert.assertEquals(0,goku.getVelocidad());
		for (int i = 0; i < 3; i ++){
			goku.agregarKi(5);
			goku.nuevoTurno();
		}
		Assert.assertEquals(2, goku.getVelocidad());
		Assert.assertEquals(0, goku.getKi());
	}

}
