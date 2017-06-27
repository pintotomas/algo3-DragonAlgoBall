package test.transformaciones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import dab.personajes.Goku.Goku;

public class GokuTests {

	private Goku goku;
	private int kiParaPrimerTransformacion = 20;
	private int kiParaSegundaTransformacion = 50;
	private int poderBase = 20;
	private int poderPrimerTransformacion = 40;
	private int poderSegundaTransformacion = 60;

	@Before
	public void before(){
		goku = new Goku();
	}
	@Test
	public void poderBaseEsperado(){
		assertEquals(poderBase, goku.getPoder(), 0);
	}
	@Test
	public void primerTransformacionNoDisponibleSinKi() {
		assertFalse(goku.transformarDisponible());
	}
	
	@Test
	public void primerTransformacionDisponibleConKiSuficiente(){
		goku.modificarKi(kiParaPrimerTransformacion);
		assertTrue(goku.transformarDisponible());
	}
	
	@Test
	public void segundaTransformacionDisponibleConKiSuficiente(){
		goku.modificarKi(kiParaPrimerTransformacion + kiParaSegundaTransformacion);
		goku.transformar();
		assertTrue(goku.transformarDisponible());
	}
	
	@Test
	public void primerTransformacionAumentaPoderEsperado(){
		goku.modificarKi(kiParaPrimerTransformacion);
		goku.transformar();
		assertEquals(poderPrimerTransformacion, goku.getPoder(), 0);
	}
	@Test
	public void segundaTransformacionAumentaPoderEsperado(){
		goku.modificarKi(kiParaPrimerTransformacion+kiParaSegundaTransformacion);
		goku.transformar();
		goku.transformar();
		assertEquals(poderSegundaTransformacion, goku.getPoder(), 0);
	}
}
