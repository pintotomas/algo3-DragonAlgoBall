package dab.tests.movimiento;

import org.junit.Assert;
import org.junit.Test;

import dab.dragonBallExceptions.CeldaOcupada;
import dab.equipos.EnemigosDeLaTierra;
import dab.equipos.Equipo;
import dab.equipos.GuerrerosZ;
import dab.estados.cell.Cell;
import dab.estados.goku.Goku;
import dab.juego.Tablero;
import dab.personajes.Personaje;

public class PruebasIntegradoras1 {
	
	@Test 
	public void testTransformarPersonaje() {
		Tablero tablero = new Tablero();
		Personaje goku = new Personaje(new Goku());
		int filaGoku = 1;
		int columnaGoku = 1;
		tablero.colocarPersonaje(filaGoku, columnaGoku, goku);
		goku.agregarKi(20);
		Assert.assertTrue(goku.transformarDisponible());
		goku.transformar();
		Assert.assertEquals(goku.getNombre(), "Goku Kaio-Ken");
		Assert.assertEquals(goku.getPosicion().getFila(), filaGoku);
		Assert.assertEquals(goku.getPosicion().getColumna(), columnaGoku);
		Assert.assertEquals(goku.getPoder(), 40);
	}


	@Test 
	public void testTransformarYMover(){
		Tablero tablero = new Tablero();
		Personaje goku = new Personaje(new Goku());
		int filaGoku = 1;
		int columnaGoku = 1;
		tablero.colocarPersonaje(filaGoku, columnaGoku, goku);
		goku.agregarKi(20);
		goku.transformar();
		goku.mover(tablero.obtenerCelda(1, 2));
		Assert.assertEquals(goku.getPoder(), 40);
		Assert.assertEquals(goku.getPosicion().getFila(), 1);
		Assert.assertEquals(goku.getPosicion().getColumna(), 2);
	}
	@Test
	public void testInicializarTablero(){
		Equipo equipo1 = new EnemigosDeLaTierra();
		Equipo equipo2 = new GuerrerosZ();
		Tablero tablero = new Tablero(equipo1,equipo2);
		Personaje goku = equipo2.obtenerPersonaje("Goku");
		Assert.assertEquals(19, goku.getPosicion().getFila());
		Personaje freezer = equipo1.obtenerPersonaje("Freezer");
		Assert.assertEquals(0, freezer.getPosicion().getFila());
	}
	@Test
	public void testPelearCerca(){
		Tablero tablero = new Tablero();
		Equipo equipo1 = new EnemigosDeLaTierra();
		Equipo equipo2 = new GuerrerosZ();
		Personaje goku = equipo2.obtenerPersonaje("Goku");
		int filaGoku = 1;
		int columnaGoku = 1;
		tablero.colocarPersonaje(filaGoku, columnaGoku, goku);
		Personaje freezer = equipo1.obtenerPersonaje("Freezer");
		int filaFreezer = 1;
		int columnaFreezer = 2;
		tablero.colocarPersonaje(filaFreezer, columnaFreezer, freezer);
		Assert.assertEquals(400, freezer.getVida());
		if (goku.puedeAtacar(freezer))
			goku.atacarA(freezer);	
		Assert.assertEquals(380, freezer.getVida());
	}
	
	@Test
	public void testPelearLejos(){
		Tablero tablero = new Tablero();
		Equipo equipo1 = new EnemigosDeLaTierra();
		Equipo equipo2 = new GuerrerosZ();
		Personaje goku = equipo2.obtenerPersonaje("Goku");
		int filaGoku = 1;
		int columnaGoku = 1;
		tablero.colocarPersonaje(filaGoku, columnaGoku, goku);
		Personaje freezer = equipo1.obtenerPersonaje("Freezer");
		int filaFreezer = 9;
		int columnaFreezer = 1;
		tablero.colocarPersonaje(filaFreezer, columnaFreezer, freezer);
		if (goku.puedeAtacar(freezer))
			goku.atacarA(freezer);
		Assert.assertEquals(400, freezer.getVida());
	}
	@Test(expected=CeldaOcupada.class)
	public void testMoverACeldaOcupada() {
		Tablero tablero = new Tablero();
		Personaje goku = new Personaje(new Goku());
		int filaGoku = 1;
		int columnaGoku = 1;
		tablero.colocarPersonaje(filaGoku, columnaGoku, goku);
		Personaje cell = new Personaje(new Cell());
		int filaCell = 2;
		int columnaCell = 1;
		tablero.colocarPersonaje(filaCell, columnaCell, cell);	
		goku.mover(tablero.obtenerCelda(2, 1));
	}

}
