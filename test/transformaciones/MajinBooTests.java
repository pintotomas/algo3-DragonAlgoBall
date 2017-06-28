package transformaciones;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dab.personajes.majinBoo.MajinBoo;

public class MajinBooTests {


	private MajinBoo majinboo;
	private int kiParaPrimerTransformacion = 20;
	private int kiParaSegundaTransformacion = 50;
	private int poderBase = 30;
	private int poderPrimerTransformacion = 50;
	private int poderSegundaTransformacion = 60;

	@Before
	public void before(){
		majinboo = new MajinBoo();
	}
	@Test
	public void poderBaseEsperado(){
		assertEquals(poderBase, majinboo.getPoder(), 0);
	}
	@Test
	public void primerTransformacionNoDisponibleSinKi() {
		assertFalse(majinboo.transformarDisponible());
	}
	
	@Test
	public void primerTransformacionDisponibleConKiSuficiente(){
		majinboo.modificarKi(kiParaPrimerTransformacion);
		assertTrue(majinboo.transformarDisponible());
	}
	
	@Test
	public void segundaTransformacionDisponibleConKiSuficiente(){
		majinboo.modificarKi(kiParaPrimerTransformacion + kiParaSegundaTransformacion);
		majinboo.transformar();
		assertTrue(majinboo.transformarDisponible());
	}
	
	@Test
	public void primerTransformacionAumentaPoderEsperado(){
		majinboo.modificarKi(kiParaPrimerTransformacion);
		majinboo.transformar();
		assertEquals(poderPrimerTransformacion, majinboo.getPoder(), 0);
	}
	@Test
	public void segundaTransformacionAumentaPoderEsperado(){
		majinboo.modificarKi(kiParaPrimerTransformacion+kiParaSegundaTransformacion);
		majinboo.transformar();
		majinboo.transformar();
		assertEquals(poderSegundaTransformacion, majinboo.getPoder(), 0);
	}
}
