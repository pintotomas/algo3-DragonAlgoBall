package dab.tests.transformaciones;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dab.equipo.Equipo;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Piccolo.Piccolo;

public class TransformacionesPiccolo {



	private Gohan gohan;
	private Piccolo piccolo;
	private Equipo guerrerosZ;
	
	@Before
	public void before(){
		guerrerosZ = new Equipo("Guerreros Z");
		gohan = new Gohan(guerrerosZ);
		piccolo = new Piccolo(guerrerosZ);		
		guerrerosZ.agregarPersonaje(gohan);
		guerrerosZ.agregarPersonaje(piccolo);
		
	}
	
	@Test
	public void primerTransformacionNoDisponibleSinKi() {
		assertFalse(piccolo.transformarDisponible());
	}
	
	@Test
	public void primerTransformacionDisponibleConKiSuficiente(){
		piccolo.modificarKi(20);
		assertTrue(piccolo.transformarDisponible());
	}
	
	@Test
	public void segundaTransformacionNoDisponibleGohanConDemasiadaVida(){
		gohan.modificarVida(-gohan.getVida()*(1 - gohan.porcentajeVidaAmigosParaTransformar));
		assertFalse(piccolo.transformarDisponible());
	}
	
	@Test
	public void segundaTransformacionDisponibleGohanConPocaVida(){
		piccolo.modificarKi(20);
		piccolo.transformar();
		gohan.modificarVida(-gohan.getVida()*(1 - piccolo.porcetanejVidaGohanParaTransformar + 0.1));
		assertTrue(piccolo.transformarDisponible());
	}
	
}


