package dab.tests.transformaciones;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dab.equipo.Equipo;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Goku.Goku;
import dab.personajes.Piccolo.Piccolo;

public class TransformacionesGohan {
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
	public void primerTransformacionNoDisponibleSinKi() {
		assertFalse(gohan.transformarDisponible());
	}
	
	@Test
	public void primerTransformacionDisponibleConKi() {
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
		goku.agregarVida(-goku.getVida()*(1 - gohan.porcentajeVidaAmigosParaTransformar));
		piccolo.agregarVida(-piccolo.getVida()*(1 - gohan.porcentajeVidaAmigosParaTransformar));
		gohan.agregarKi(30);
		assertFalse(gohan.transformarDisponible());
	}
	@Test
	public void segundaTransformacionDisponibleKiYCondiciones(){
		gohan.agregarKi(10);
		gohan.transformar();
		goku.agregarVida(-goku.getVida()*(1 - gohan.porcentajeVidaAmigosParaTransformar + 0.1));
		piccolo.agregarVida(-piccolo.getVida()* (1 - gohan.porcentajeVidaAmigosParaTransformar + 0.1));
		gohan.agregarKi(30);
		assertTrue(gohan.transformarDisponible());
	}
}
