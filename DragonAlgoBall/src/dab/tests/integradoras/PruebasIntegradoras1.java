/*
package dab.tests.integradoras;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dab.dragonBallExceptions.CeldaOcupada;
import dab.dragonBallExceptions.MovimientoInvalido;
import dab.equipo.Equipo;
import dab.juego.Tablero;
import dab.personajes.Goku.Goku;
import dab.personajes.Piccolo.Piccolo;
import dab.personajes.Gohan.Gohan;
import dab.personajes.cell.Cell;
import dab.personajes.majinBoo.MajinBoo;
import dab.personajes.Freezer.Freezer;
public class PruebasIntegradoras1 {

	Goku goku;
	Piccolo piccolo;
	Gohan gohan;
	Cell cell;
	MajinBoo majinboo;
	Freezer freezer;
	Equipo equipo1;
	Equipo equipo2;
	@Before
	public void setUp() throws Exception {
		goku = new Goku();
		gohan = new Gohan();
		piccolo = new Piccolo();	
		equipo1 = new Equipo("Guerreros Z");
		equipo1.agregarPersonaje(goku);
		equipo1.agregarPersonaje(gohan);
		equipo1.agregarPersonaje(piccolo);
		
		cell = new Cell();
		majinboo = new MajinBoo();
		freezer = new Freezer();
		equipo2 = new Equipo("Enemigos De La Tierra");
		equipo2.agregarPersonaje(cell);
		equipo2.agregarPersonaje(freezer);
		equipo2.agregarPersonaje(majinboo);
		
	}

	
	@Test 
	public void testTransformarPersonaje() {
		Tablero tablero = new Tablero(20, 20);
		int filaGoku = 1;
		int columnaGoku = 1;
		tablero.colocarFichaMovil(goku, filaGoku, columnaGoku);
		goku.modificarKi(20);
		Assert.assertTrue(goku.transformarDisponible());
		goku.transformar();
		Assert.assertEquals(goku.getNombre(), "Goku Kaio-Ken");
		Assert.assertEquals(goku.getPosicion().getFila(), filaGoku);
		Assert.assertEquals(goku.getPosicion().getColumna(), columnaGoku);
		Assert.assertEquals(goku.getPoder(), 40,0);
	}


	@Test 
	public void testTransformarYMover(){
		Tablero tablero = new Tablero(20, 20);
		int filaGoku = 1;
		int columnaGoku = 1;
		tablero.colocarFichaMovil(goku, filaGoku, columnaGoku);
		goku.modificarKi(20);
		goku.transformar();
		tablero.moverFicha(goku, 1, 2);
		Assert.assertEquals(goku.getPoder(), 40, 0);
		Assert.assertEquals(goku.getPosicion().getFila(), 1);
		Assert.assertEquals(goku.getPosicion().getColumna(), 2);
	}
	
//	@Test
//	public void testInicializarTablero(){
//		Tablero tablero = new Tablero(equipo2, equipo1);
//		Assert.assertEquals(19, tablero.filaPersonaje(goku));
//		Assert.assertEquals(0, tablero.filaPersonaje(piccolo));
//	}
	
	@Test
	public void testPelearCerca(){
		Tablero tablero = new Tablero(20, 20);
		int filaGoku = 1;
		int columnaGoku = 1;
		tablero.colocarFichaMovil(goku, filaGoku, columnaGoku);
		int filaFreezer = 1;
		int columnaFreezer = 2;
		tablero.colocarFichaMovil(freezer, filaFreezer, columnaFreezer);
		Assert.assertEquals(400, freezer.getVida(),0);
		if (goku.puedeAtacar(freezer))
			goku.atacarA(freezer);	
		Assert.assertEquals(380, freezer.getVida(),0);
	}
	
	@Test
	public void testPelearLejos(){
		Tablero tablero = new Tablero(20, 20);
		int filaGoku = 1;
		int columnaGoku = 1;
		tablero.colocarFichaMovil(goku, filaGoku, columnaGoku);
		int filaFreezer = 9;
		int columnaFreezer = 1;
		tablero.colocarFichaMovil(freezer, filaFreezer, columnaFreezer);
		if (goku.puedeAtacar(freezer))
			goku.atacarA(freezer);
		Assert.assertEquals(400, freezer.getVida(),0);
	}
	@Test(expected=MovimientoInvalido.class)
	public void testMoverACeldaOcupada() {
		Tablero tablero = new Tablero(20, 20);
		int filaGoku = 1;
		int columnaGoku = 1;
		tablero.colocarFichaMovil(goku, filaGoku, columnaGoku);
		int filaCell = 2;
		int columnaCell = 1;
		tablero.colocarFichaMovil(cell, filaCell, columnaCell);	
		tablero.moverFicha(goku, 2, 1);
	}

}
*/