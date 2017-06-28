package tablero.movimiento;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import dab.dragonBallExceptions.MovimientoInvalido;
import dab.juego.Celda;
import dab.juego.Tablero;
import dab.personajes.Personaje;
import dab.personajes.Freezer.Freezer;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Goku.Goku;
import dab.personajes.Piccolo.Piccolo;
import dab.personajes.cell.Cell;
import dab.personajes.majinBoo.MajinBoo;

public class MovimientosPersonajeTest {

	@Test 
	public void moverPersonaje() {
		Tablero tablero = new Tablero(20, 20);
		Personaje piccolo = new Piccolo();
		tablero.colocarFicha(piccolo, 1, 1);
		Celda destino = tablero.obtenerCelda(1, 2);
		assert(piccolo.movimientoPosible(destino));
		tablero.moverFicha(piccolo,  1, 2);
		assert(destino.getFicha() == piccolo);
	}	
	

	@Test
	public void testPersonajePuedeMoverseEnSentidoHorizontalHastaSuAlcanceMaximo(){ 
		Tablero tableroDab = new Tablero(20, 20);
		Goku goku = new Goku();
		tableroDab.colocarFicha(goku, 5, 6);
		tableroDab.colocarFicha(goku, 5 + goku.getVelocidad(), 6);
		assertEquals(tableroDab.getFilaDeLaFicha(goku), 5+ goku.getVelocidad());
		assertEquals(tableroDab.getColumnaDeLaFicha(goku), 6);
	}
	
	@Test
	public void testPersonajePuedeMoverseEnSentidoVerticalHastaSuAlcanceMaximo(){
		Tablero tableroDab = new Tablero(20, 20);
		Goku goku = new Goku();
		tableroDab.colocarFicha(goku, 5, 6);
		tableroDab.colocarFicha(goku, 5, 6 + goku.getVelocidad());
		assertEquals(tableroDab.getFilaDeLaFicha(goku), 5);
		assertEquals(tableroDab.getColumnaDeLaFicha(goku), 6 + goku.getVelocidad());
	}
	@Test
	public void testPersonajePuedeMoverseEnSentidoDiagonalHastaSuAlcanceMaximo(){
		Tablero tableroDab = new Tablero(20, 20);
		Goku goku = new Goku();
		tableroDab.colocarFicha(goku, 5, 6);
		tableroDab.colocarFicha(goku, 5 + ((int)(goku.getVelocidad())), 6 + ((int)(goku.getVelocidad())));
		assertEquals(tableroDab.getFilaDeLaFicha(goku), 5 + ((int)(goku.getVelocidad())));
		assertEquals(tableroDab.getColumnaDeLaFicha(goku), 6 + ((int)(goku.getVelocidad())));
	}
	@Test(expected = MovimientoInvalido.class)
	public void testMoverPersonajeHorizontalMayorQueAlcanceLanzaMovimientoInvalido(){
		Tablero tableroDab = new Tablero(20, 20);
		Goku goku = new Goku();
		tableroDab.colocarFicha(goku, 5, 6);
		
		tableroDab.moverFicha(goku, 5 + goku.getVelocidad() + 1, 6);
	}
	
	@Test(expected = MovimientoInvalido.class)
	public void testMoverPersonajeVerticalMayorQueAlcanceLanzaMovimientoInvalido(){
		Tablero tableroDab = new Tablero(20, 20);
		Goku goku = new Goku();
		tableroDab.colocarFicha(goku, 5, 6);
		tableroDab.moverFicha(goku, 5, 6 + goku.getVelocidad() + 1);
	}
	@Test(expected = MovimientoInvalido.class)
	public void testMoverPersonajeDiagonalMayorAlcanceMaximoLanzaMovimientoInvalido(){
		Tablero tableroDab = new Tablero(20, 20);
		Goku goku = new Goku();
		tableroDab.colocarFicha(goku, 5, 6);
		tableroDab.moverFicha(goku, 5 + 1 + ((int)(goku.getVelocidad())), 6 + ((int)(goku.getVelocidad())));
	}
		
	
	@Test(expected=MovimientoInvalido.class)
	public void testMoverACeldaOcupadaLanzaError() {
		Tablero tablero = new Tablero(20, 20);
		Personaje goku = new Goku();
		int filaGoku = 1;
		int columnaGoku = 1;
		Personaje cell = new Cell();
		int filaCell = 2;
		int columnaCell = 1;
		tablero.colocarFicha(goku, filaGoku, columnaGoku);
		tablero.colocarFicha(cell, filaCell, columnaCell);
		tablero.moverFicha(goku, 2, 1);
	}
	@Test
	public void testPersonajeNoTieneDondeMoverseSiEstaRodeado() {
		//La idea de este test es rodear a un personaje por otros 6 y verificar
		//que no hayan celdas disponibles a las cual moverse
		//En este test, goku es el que esta encerrado
		Tablero tablero = new Tablero(20, 20);
				
		Personaje cell = new Cell();
		int filaCell = 4;
		int columnaCell = 4;
		tablero.colocarFicha(cell, filaCell, columnaCell);
		
		Personaje majinBoo = new MajinBoo();
		int filaMajinBoo = 4;
		int columnaMajinBoo = 5;
		tablero.colocarFicha(majinBoo, filaMajinBoo, columnaMajinBoo);
		
		Personaje freezer = new Freezer();
		int filaFreezer= 4;
		int columnaFreezer = 6;
		tablero.colocarFicha(freezer, filaFreezer, columnaFreezer);
		Personaje piccolo = new Piccolo();
		int filaPiccolo = 5;
		int columnaPiccolo = 4;
		tablero.colocarFicha(piccolo, filaPiccolo, columnaPiccolo);
		
		Personaje goku = new Goku();
		int filaGoku = 5;
		int columnaGoku = 5;
		tablero.colocarFicha(goku, filaGoku, columnaGoku);
		
		Personaje gohan = new Gohan();
		int filaGohan = 5;
		int columnaGohan = 6;
		tablero.colocarFicha(gohan, filaGohan, columnaGohan);
		
		Personaje clonGohan = new Gohan();
		int filaClonGohan= 6;
		int columnaClonGohan = 4;
		tablero.colocarFicha(clonGohan, filaClonGohan, columnaClonGohan);
		
		Personaje clonFreezer = new Freezer();
		int filaClonFreezer= 6;
		int columnaClonFreezer = 5;
		tablero.colocarFicha(clonFreezer, filaClonFreezer, columnaClonFreezer);
		
		Personaje clonPiccolo = new Piccolo();
		int filaClonPiccolo= 6;
		int columnaClonPiccolo = 6;
		tablero.colocarFicha(clonPiccolo, filaClonPiccolo, columnaClonPiccolo);
		
		ArrayList<Celda> celdasDisponiblesParaQueSeMuevaGoku = tablero.celdasPermitidas((Celda) goku.getPosicion(), goku.getVelocidad());
		assertEquals(celdasDisponiblesParaQueSeMuevaGoku.isEmpty(), true);
	}
	
	@Test
	public void testPersonajeTieneDondeMoverseSiEstaRodeadoPorSolo5Personajes() {
		//Sigue la idea de rodear al personaje del test anterior, pero esta vez lo 
		//rodeo por uno menos. 
		Tablero tablero = new Tablero(20, 20);
		
		Personaje cell = new Cell();
		int filaCell = 4;
		int columnaCell = 4;
		tablero.colocarFicha(cell, filaCell, columnaCell);
						
		Personaje majinBoo = new MajinBoo();
		int filaMajinBoo = 4;
		int columnaMajinBoo = 5;
		tablero.colocarFicha(majinBoo, filaMajinBoo, columnaMajinBoo);
		
		Personaje freezer = new Freezer();
		int filaFreezer= 4;
		int columnaFreezer = 6;
		tablero.colocarFicha(freezer, filaFreezer, columnaFreezer);
		
		Personaje piccolo = new Piccolo();
		int filaPiccolo = 5;
		int columnaPiccolo = 4;
		tablero.colocarFicha(piccolo, filaPiccolo, columnaPiccolo);
		
		Personaje goku = new Goku();
		int filaGoku = 5;
		int columnaGoku = 5;
		tablero.colocarFicha(goku, filaGoku, columnaGoku);
		
		Personaje gohan = new Gohan();
		int filaGohan = 5;
		int columnaGohan = 6;
		tablero.colocarFicha(gohan, filaGohan, columnaGohan);
		
		Personaje clonGohan = new Gohan();
		int filaClonGohan= 6;
		int columnaClonGohan = 4;
		tablero.colocarFicha(clonGohan, filaClonGohan, columnaClonGohan);
		
		Personaje clonFreezer = new Freezer();
		int filaClonFreezer= 6;
		int columnaClonFreezer = 5;
		tablero.colocarFicha(clonFreezer, filaClonFreezer, columnaClonFreezer);
		
		Personaje clonPiccolo = new Piccolo();
		int filaClonPiccolo= 6;
		int columnaClonPiccolo = 6;
		tablero.colocarFicha(clonPiccolo, filaClonPiccolo, columnaClonPiccolo);
		
		List<Personaje> personajesARemover = Arrays.asList(cell, majinBoo, freezer, gohan, 
				piccolo, clonGohan, clonFreezer, clonPiccolo);
		boolean pudoMoverseEnCualquierOportunidad = true;
		int filaRemovido;
		int columnaRemovido;
		Personaje removido;
		for (Personaje p: personajesARemover){
			filaRemovido = p.getPosicion().getFila();
			columnaRemovido = p.getPosicion().getColumna();
			removido = p;
			tablero.removerFicha(removido);
			ArrayList<Celda> celdasDisponiblesParaQueSeMuevaGoku = tablero.celdasPermitidas((Celda) goku.getPosicion(), goku.getVelocidad());
			if (celdasDisponiblesParaQueSeMuevaGoku.isEmpty()){
				pudoMoverseEnCualquierOportunidad = false;
				break;
			}
			tablero.colocarFicha(removido, filaRemovido, columnaRemovido);
			//reinserto y pruebo con el siguiente
		}
		assertEquals(pudoMoverseEnCualquierOportunidad, true);
	}

	@Test
	public void testPersonajeRodeadoEnEsquinaInferiorIzquierdaDelTableroNoTieneMovimientosPosibles(){
		
		int filasTablero = 20;
		int columnasTablero = 20;
		Tablero tablero = new Tablero(filasTablero, columnasTablero);
		
		Personaje cell = new Cell();
		int filaCell = filasTablero - 1;
		int columnaCell = 0;
		tablero.colocarFicha(cell, filaCell, columnaCell);
						
		Personaje majinBoo = new MajinBoo();
		int filaMajinBoo = filasTablero - 2;
		int columnaMajinBoo = 0;
		tablero.colocarFicha(majinBoo, filaMajinBoo, columnaMajinBoo);
		
		Personaje freezer = new Freezer();
		int filaFreezer= filasTablero - 2;
		int columnaFreezer = 1;
		tablero.colocarFicha(freezer, filaFreezer, columnaFreezer);
		
		Personaje piccolo = new Piccolo();
		int filaPiccolo = filasTablero - 1;
		int columnaPiccolo = 1;
		tablero.colocarFicha(piccolo, filaPiccolo, columnaPiccolo);
		
		ArrayList<Celda> celdasDisponiblesParaQueSeMuevaCell= tablero.celdasPermitidas((Celda) cell.getPosicion(), cell.getVelocidad());
		assertEquals(celdasDisponiblesParaQueSeMuevaCell.isEmpty(), true);
		
		
	}
	
	@Test
	public void testPersonajeRodeadoEnEsquinaSuperiorIzquierdaDelTableroNoTieneMovimientosPosibles(){
		
		int filasTablero = 20;
		int columnasTablero = 20;
		Tablero tablero = new Tablero(filasTablero, columnasTablero);
		
		Personaje cell = new Cell();
		int filaCell = 0;
		int columnaCell = 0;
		tablero.colocarFicha(cell, filaCell, columnaCell);
						
		Personaje majinBoo = new MajinBoo();
		int filaMajinBoo = 0;
		int columnaMajinBoo = 1;
		tablero.colocarFicha(majinBoo, filaMajinBoo, columnaMajinBoo);
		
		Personaje freezer = new Freezer();
		int filaFreezer= 1;
		int columnaFreezer = 0;
		tablero.colocarFicha(freezer, filaFreezer, columnaFreezer);
		
		Personaje piccolo = new Piccolo();
		int filaPiccolo = 1;
		int columnaPiccolo = 1;
		tablero.colocarFicha(piccolo, filaPiccolo, columnaPiccolo);
		
		ArrayList<Celda> celdasDisponiblesParaQueSeMuevaCell= tablero.celdasPermitidas((Celda) cell.getPosicion(), cell.getVelocidad());
		assertEquals(celdasDisponiblesParaQueSeMuevaCell.isEmpty(), true);
		
		
	}
	
	@Test
	public void testPersonajeRodeadoEnEsquinaSuperiorDerechaDelTableroNoTieneMovimientosPosibles(){
		
		int filasTablero = 20;
		int columnasTablero = 20;
		Tablero tablero = new Tablero(filasTablero, columnasTablero);
		
		Personaje cell = new Cell();
		int filaCell = 0;
		int columnaCell = columnasTablero - 1;
		tablero.colocarFicha(cell, filaCell, columnaCell);
						
		Personaje majinBoo = new MajinBoo();
		int filaMajinBoo = 0;
		int columnaMajinBoo = columnasTablero - 2;
		tablero.colocarFicha(majinBoo, filaMajinBoo, columnaMajinBoo);
		
		Personaje freezer = new Freezer();
		int filaFreezer= 1;
		int columnaFreezer = columnasTablero - 2;
		tablero.colocarFicha(freezer, filaFreezer, columnaFreezer);
		
		Personaje piccolo = new Piccolo();
		int filaPiccolo = 1;
		int columnaPiccolo = columnasTablero - 1;
		tablero.colocarFicha(piccolo, filaPiccolo, columnaPiccolo);
		
		ArrayList<Celda> celdasDisponiblesParaQueSeMuevaCell= tablero.celdasPermitidas((Celda) cell.getPosicion(), cell.getVelocidad());
		assertEquals(celdasDisponiblesParaQueSeMuevaCell.isEmpty(), true);
		
		
	}
	
	@Test
	public void testPersonajeRodeadoEnEsquinaInferiorDerechaDelTableroNoTieneMovimientosPosibles(){
		
		int filasTablero = 20;
		int columnasTablero = 20;
		Tablero tablero = new Tablero(filasTablero, columnasTablero);
		
		Personaje cell = new Cell();
		int filaCell = filasTablero - 1;
		int columnaCell = columnasTablero - 1;
		tablero.colocarFicha(cell, filaCell, columnaCell);
						
		Personaje majinBoo = new MajinBoo();
		int filaMajinBoo = filasTablero - 2;
		int columnaMajinBoo = columnasTablero - 1;
		tablero.colocarFicha(majinBoo, filaMajinBoo, columnaMajinBoo);
		
		Personaje freezer = new Freezer();
		int filaFreezer= filasTablero - 2;
		int columnaFreezer = columnasTablero - 2;
		tablero.colocarFicha(freezer, filaFreezer, columnaFreezer);
		
		Personaje piccolo = new Piccolo();
		int filaPiccolo = filasTablero - 1;
		int columnaPiccolo = columnasTablero - 2;
		tablero.colocarFicha(piccolo, filaPiccolo, columnaPiccolo);
		
		ArrayList<Celda> celdasDisponiblesParaQueSeMuevaCell= tablero.celdasPermitidas((Celda) cell.getPosicion(), cell.getVelocidad());
		assertEquals(celdasDisponiblesParaQueSeMuevaCell.isEmpty(), true);
		
		
	}
		
}
	