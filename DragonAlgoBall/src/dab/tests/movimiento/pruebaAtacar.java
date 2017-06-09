package dab.tests.movimiento;

import org.junit.Test;

import dab.equipos.EnemigosDeLaTierra;
import dab.equipos.Equipo;
import dab.equipos.GuerrerosZ;
import dab.juego.Tablero;
import dab.personajes.Personaje;

public class pruebaAtacar{
		
	@Test
	public void testAtacarMismoPP(){
		Equipo equipo1 = new GuerrerosZ();
		Equipo equipo2 = new EnemigosDeLaTierra();
		Tablero tablero = new Tablero();
		Personaje piccolo = equipo1.obtenerPersonaje("Piccolo");
		Personaje cell = equipo2.obtenerPersonaje("Cell");
		tablero.colocarPersonaje(5, 6, piccolo);
		tablero.colocarPersonaje(5, 7,cell);
		
		int vidaEsperada = cell.getVida() - piccolo.getPoder();
		piccolo.atacarA(cell);
		assert(cell.getVida() == vidaEsperada);	
	}
	
	@Test
	public void pruebaAtacarMayorPP(){
		Equipo equipo1 = new GuerrerosZ();
		Equipo equipo2 = new EnemigosDeLaTierra();
		Tablero tablero = new Tablero();
		Personaje piccolo = equipo1.obtenerPersonaje("Piccolo");
		Personaje majinboo = equipo2.obtenerPersonaje("MajinBoo");
		
		tablero.colocarPersonaje(5, 6, piccolo);
		tablero.colocarPersonaje(5, 7,majinboo);
		
		int vidaEsperada = majinboo.getVida() - (int)(piccolo.getPoder() * 0.8);
		piccolo.atacarA(majinboo);
		assert(majinboo.getVida() == vidaEsperada);
	}
	
	@Test
	public void atacarADistancia(){
		Equipo equipo1 = new GuerrerosZ();
		Equipo equipo2 = new EnemigosDeLaTierra();
		@SuppressWarnings("unused")
		Tablero tablero = new Tablero(equipo1, equipo2);
		Personaje piccolo = equipo1.obtenerPersonaje("Piccolo");
		Personaje majinboo = equipo2.obtenerPersonaje("MajinBoo");
		
		assert(!piccolo.puedeAtacar(majinboo));
		
		
	}
	
}


