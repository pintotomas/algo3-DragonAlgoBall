package transformaciones;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dab.equipo.Equipo;
import dab.juego.Tablero;
import dab.personajes.Personaje;
import dab.personajes.Goku.Goku;
import dab.personajes.cell.Cell;

public class CellTest {
	
	private Cell cell;
	private Goku goku;
	private Equipo enemigos, guerrerosz;
	private Tablero tablero;
	private int kiParaEspecial = 5;
	private int absorcionesParaPrimerTransformacion = 4;
	private int absorcionesParaSegundaTransformacion = 4;
	private int poderBase = 20;
	private int poderPrimerTransformacion = 40;
	private int poderSegundaTransformacion = 80;

	@Before
	public void setUp() throws Exception {
		cell = new Cell();
		enemigos = new Equipo("Enemigos de la Tierra");
		enemigos.agregarPersonaje(cell);
		goku = new Goku();
		guerrerosz = new Equipo("Guerreros Z");
		guerrerosz.agregarPersonaje(goku);
		tablero = new Tablero(20, 20);
		tablero.colocarFicha(goku,1,1);
		tablero.colocarFicha(cell,1,2);
	}

	@Test
	public void testTransformacionNoDisponible() {
		Assert.assertFalse(cell.transformarDisponible());
	}
	@Test
	public void testAbsorberVidaRecuperaVida() {
		cell.modificarVida(-20);
		cell.modificarKi(kiParaEspecial);
		cell.ataqueEspecial(goku);
		Assert.assertEquals(cell.getVidaMaxima(), cell.getVida(), 0);
		Assert.assertEquals(480, goku.getVida(),0);
	}
	
	private void absorberNVeces(Personaje personaje, int n){
		for (int i = 0; i < n; i++) {
			cell.modificarKi(kiParaEspecial);
			cell.ataqueEspecial(personaje);
		}
	}
	
	@Test
	public void testPrimerTransformacionAumentaPoderEsperado(){
		absorberNVeces(goku, 4);
		cell.transformar();
		Assert.assertEquals(poderPrimerTransformacion, cell.getPoder(), 0);
	}
	@Test
	public void testSegundaTransformacionAumentaPoderEsperado(){
		absorberNVeces(goku, absorcionesParaPrimerTransformacion + absorcionesParaSegundaTransformacion);
		cell.transformar();
		cell.transformar();
		Assert.assertEquals(poderSegundaTransformacion, cell.getPoder(), 0);
	}
	@Test
	public void poderBaseEsperado(){
		assertEquals(poderBase, cell.getPoder(), 0);
	}

}
