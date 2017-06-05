package dab.tests.movimiento;

import org.junit.Test;

import dab.equipos.EnemigosDeLaTierra;
import dab.equipos.Equipo;
import dab.equipos.GuerrerosZ;
import dab.juego.Tablero;
import dab.personajes.Personaje;
import junit.framework.TestCase;

public class pruebaAtacar extends TestCase{
	
	@Before
	public void before(){
	Equipo equipo1 = new GuerrerosZ();
	Equipo equipo2 = new EnemigosDeLaTierra();
	Tablero tablero = new Tablero();
	}
	
	
	@Test
	public void testAtacarMismoPP(){
		Personaje piccolo = equipo1.obtenerPersonaje("piccolo");
		Personaje cell = equipo2.obtenerPersonaje("cell");
		tablero.colocarPersonaje(5, 6, piccolo);
		tablero.colocarPersonaje(5, 7,cell);
		
		int vidaEsperada = cell.getVida() - piccolo.getPoder();
		piccolo.atacarA(cell);
		assert(cell.getVida() == vidaEsperada);	
	}
	
	@Test
	public void pruebaAtacarMayorPP(){
		Personaje piccolo = equipo1.obtenerPersonaje("piccolo");
		Personaje majinBoo = equipo2.obtenerPersonaje("majinBoo");
		
		tablero.colocarPersonaje(5, 6, piccolo);
		tablero.colocarPersonaje(5, 7,majinBoo);
		
		int vidaEsperada = majinBoo.getVida() - (int)(piccolo.getPoder() * 0.8);
		piccolo.atacarA(majinBoo);
		assert(majinBoo.getVida() == vidaEsperada);
	}
	
	@Test
	public void atacarADistancia(){
		Tablero tablero2 = new Tablero(equipo1,equipo2);
		Personaje piccolo = equipo1.obtenerPersonaje("piccolo");
		Personaje majinBoo = equipo2.obtenerPersonaje("majinBoo");
		
		assert(!piccolo.puedeAtacar(majinBoo));
		
		
	}
	
}


