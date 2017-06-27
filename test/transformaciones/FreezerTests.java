package transformaciones;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dab.personajes.Freezer.Freezer;

public class FreezerTests {

	private Freezer freezer;
	private int kiParaPrimerTransformacion = 20;
	private int kiParaSegundaTransformacion = 50;
	private int poderBase = 20;
	private int poderPrimerTransformacion = 40;
	private int poderSegundaTransformacion = 50;

	@Before
	public void before(){
		freezer = new Freezer();
	}
	@Test
	public void poderBaseEsperado(){
		assertEquals(poderBase, freezer.getPoder(), 0);
	}
	@Test
	public void primerTransformacionNoDisponibleSinKi() {
		assertFalse(freezer.transformarDisponible());
	}
	
	@Test
	public void primerTransformacionDisponibleConKiSuficiente(){
		freezer.modificarKi(kiParaPrimerTransformacion);
		assertTrue(freezer.transformarDisponible());
	}
	
	@Test
	public void segundaTransformacionDisponibleConKiSuficiente(){
		freezer.modificarKi(kiParaPrimerTransformacion + kiParaSegundaTransformacion);
		freezer.transformar();
		assertTrue(freezer.transformarDisponible());
	}
	
	@Test
	public void primerTransformacionAumentaPoderEsperado(){
		freezer.modificarKi(kiParaPrimerTransformacion);
		freezer.transformar();
		assertEquals(poderPrimerTransformacion, freezer.getPoder(), 0);
	}
	@Test
	public void segundaTransformacionAumentaPoderEsperado(){
		freezer.modificarKi(kiParaPrimerTransformacion+kiParaSegundaTransformacion);
		freezer.transformar();
		freezer.transformar();
		assertEquals(poderSegundaTransformacion, freezer.getPoder(), 0);
	}

}
