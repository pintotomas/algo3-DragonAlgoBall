package dab.tests.juego;


import org.junit.Assert;
import org.junit.Test;

import dab.dragonBallExceptions.MovimientoInvalido;
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
	
	@Test(expected=EstePersonajeNoPuedeRealizarMovimientosEsteTurno.class)
	public void testNoSePuedeSeleccionarUnPersonajeFueraDelTurnoDeSuRespectivoEquipo(){
		
		Juego juego = new Juego("Tomas", "PC");
		juego.seleccionarPersonaje();
	}

}
