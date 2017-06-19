package dab.tests.juego;

import static org.junit.Assert.assertNotSame;

import org.junit.Assert;
import org.junit.Test;

import dab.juego.Juego;
import dab.juego.Turno;

public class testTurnos {

	@Test
	public void testPasarTurnos() {
		Juego juego = new Juego("Tomas", "PC");
		Turno turnoActual = juego.getTurno();
		String nombreEquipoActual = turnoActual.getEquipo().getNombre();
		juego.pasarTurno();
		Assert.assertNotSame(nombreEquipoActual, juego.getTurno().getEquipo().getNombre());
		
	}

}
