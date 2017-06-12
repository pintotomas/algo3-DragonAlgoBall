package dab.tests.transformaciones;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dab.equipo.Equipo;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Goku.Goku;
import dab.personajes.Piccolo.Piccolo;

public class gohan {
	private Gohan gohan;
	private Goku goku;
	private Piccolo piccolo;
	private Equipo guerrerosZ;

	@Before
	public void before(){
		gohan = new Gohan();
		goku = new Goku();
		piccolo = new Piccolo();
		guerrerosZ = new Equipo("Guerreros Z");
	
	}
	
	@Before
	public void setUp() throws Exception {
		
		guerrerosZ.agregarPersonaje(gohan);
		guerrerosZ.agregarPersonaje(goku);
		guerrerosZ.agregarPersonaje(piccolo);
		
	}

	@Test
	public void primerTransformacionExitosa() {
		gohan.agregarKi(10);
		assertTrue(gohan.transformarDisponible());
	}
	
	
}
