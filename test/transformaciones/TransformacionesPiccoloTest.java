package transformaciones;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dab.equipo.Equipo;
import dab.personajes.Personaje;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Piccolo.Piccolo;

public class TransformacionesPiccoloTest {

	private Gohan gohan;
	private Piccolo piccolo;
	private Equipo guerrerosZ;
	private int kiParaPrimerTransformacion = 20;
	private int poderBase = 20;
	private int poderPrimerTransformacion = 40;
	private int poderSegundaTransformacion = 60;
	
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
		piccolo.modificarKi(kiParaPrimerTransformacion);
		assertTrue(piccolo.transformarDisponible());
	}
	
	@Test
	public void segundaTransformacionNoDisponibleGohanConDemasiadaVida(){
		piccolo.modificarKi(kiParaPrimerTransformacion);
		piccolo.transformar();
		assertFalse(piccolo.transformarDisponible());
	}
	
	private void reducirVidaAMenosDel20Porciento(Personaje personaje){
		double vidaAReducir = personaje.getVidaMaxima()*0.81;
		personaje.modificarVida(-vidaAReducir);
	}
	
	@Test
	public void segundaTransformacionDisponibleGohanConPocaVida(){
		piccolo.modificarKi(kiParaPrimerTransformacion);
		piccolo.transformar();
		reducirVidaAMenosDel20Porciento(gohan);
		assertTrue(piccolo.transformarDisponible());
	}
	
	@Test
	public void poderBaseEsperado(){
		assertEquals(poderBase, piccolo.getPoder(), 0);
	}
	@Test
	public void primerTransformacionAumentaPoderEsperado(){
		piccolo.modificarKi(kiParaPrimerTransformacion);
		piccolo.transformar();
		assertEquals(poderPrimerTransformacion, piccolo.getPoder(), 0);
	}
	@Test
	public void segundaTransformacionAumentaPoderEsperado(){
		piccolo.modificarKi(kiParaPrimerTransformacion);
		piccolo.transformar();
		reducirVidaAMenosDel20Porciento(gohan);
		piccolo.transformar();
		assertEquals(poderSegundaTransformacion, piccolo.getPoder(), 0);
	}
	
}


