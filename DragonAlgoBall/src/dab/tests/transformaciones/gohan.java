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
		guerrerosZ.agregarPersonaje(gohan);
		guerrerosZ.agregarPersonaje(goku);
		guerrerosZ.agregarPersonaje(piccolo);
		
	}
	
	@Test
	public void primerTransformacionNoDisponible() {
		assertFalse(gohan.transformarDisponible());
	}
	
	@Test
	public void primerTransformacionDisponible() {
		gohan.agregarKi(10);
		assertTrue(gohan.transformarDisponible());
	}
	@Test
	public void segundaTransformacionNoDisponibleCompanerosConTodaLaVida() {
		gohan.agregarKi(10);
		gohan.transformar();
		assertFalse(gohan.transformarDisponible());
	}
	@Test
	public void segundaTransformacionNoDisponibleCompanerosDanados(){
		gohan.agregarKi(10);
		gohan.transformar();
		goku.agregarHp(-goku.getVida()*0.7);
		piccolo.agregarHp(-piccolo.getVida()*0.7);
		assertFalse(gohan.transformarDisponible());
	}
	@Test
	public void segundaTransformacionDisponible(){
		gohan.agregarKi(10);
		gohan.transformar();
		goku.agregarHp(-goku.getVida()*0.8);
		piccolo.agregarHp(-piccolo.getVida()*0.8);
		assertTrue(gohan.transformarDisponible());
	}
}
