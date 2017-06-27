package transformaciones;

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
	private double limite = 0.0000000000000001;
	//se usa para comprobar que gohan pueda transformarse cuando tenga 29.9999% de vida
	private int kiParaPrimerTransformacion = 10;
	private int kiParaSegundaTransformacion = 30;
	@Before
	public void before(){
		guerrerosZ = new Equipo("Guerreros Z");
		gohan = new Gohan(guerrerosZ);
		goku = new Goku(guerrerosZ);
		piccolo = new Piccolo(guerrerosZ);
		guerrerosZ.agregarPersonaje(gohan);
		guerrerosZ.agregarPersonaje(goku);
		guerrerosZ.agregarPersonaje(piccolo);	
	}
	
	@Test
	public void primerTransformacionNoDisponibleSinKi() {
		assertFalse(gohan.transformarDisponible());
	}
	
	@Test
	public void primerTransformacionDisponibleConKiSuficiente() {
		gohan.modificarKi(kiParaPrimerTransformacion);
		assertTrue(gohan.transformarDisponible());
	}
	@Test
	public void segundaTransformacionNoDisponibleCompanerosConTodaLaVida() {
		gohan.modificarKi(kiParaPrimerTransformacion);
		gohan.transformar();
		assertFalse(gohan.transformarDisponible());
	}
	@Test
	public void segundaTransformacionNoDisponibleCompanerosDanados(){
		gohan.modificarKi(kiParaPrimerTransformacion);
		gohan.transformar();
		goku.modificarVida(-goku.getVida()*(1 - gohan.porcentajeVidaAmigosParaTransformar));
		piccolo.modificarVida(-piccolo.getVida()*(1 - gohan.porcentajeVidaAmigosParaTransformar));
		gohan.modificarKi(kiParaSegundaTransformacion);
		assertFalse(gohan.transformarDisponible());
	}
	@Test
	public void segundaTransformacionDisponibleKiYCondiciones(){
		gohan.modificarKi(kiParaPrimerTransformacion);
		gohan.transformar();
		goku.modificarVida(-goku.getVida()*(1 - gohan.porcentajeVidaAmigosParaTransformar + limite));
		piccolo.modificarVida(-piccolo.getVida()* (1 - gohan.porcentajeVidaAmigosParaTransformar + limite));
		gohan.modificarKi(kiParaSegundaTransformacion);
		assertTrue(gohan.transformarDisponible());
	}
}
