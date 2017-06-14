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
	Equipo enemigos, guerrerosZ;
	Tablero tablero;
	
	@Before
	public void setUp() throws Exception {
		majinboo = new MajinBoo();
		enemigos = new Equipo("Enemigos de la Tierra");
		enemigos.agregarPersonaje(majinboo);
		goku = new Goku();
		guerrerosZ = new Equipo("Guerreros Z");
		guerrerosZ.agregarPersonaje(goku);
		tablero = new Tablero(guerrerosZ,enemigos);
		tablero.colocarFichaMovil(goku,1,1);
		tablero.colocarFichaMovil(majinboo,1,2);
	}

	@Test
	public void testSeConvierteEnChocolate() {
		majinboo.modificarKi(30);
		majinboo.ataqueEspecial(goku);
		Assert.assertEquals(0,goku.getAlcance());
		Assert.assertEquals(0,goku.getVelocidad());
		for (int i = 0; i < 3; i ++){
			goku.modificarKi(5);
			goku.nuevoTurno();
		}
		Assert.assertEquals(2, goku.getVelocidad());
		Assert.assertEquals(0, goku.getKi());
	}

}
