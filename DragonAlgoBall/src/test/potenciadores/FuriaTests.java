package test.potenciadores;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dab.estados.goku.GokuBase;
import dab.personajes.Goku.Goku;
import dab.personajes.cell.Cell;
import dab.potenciadores.Furia;

public class FuriaTests {

	
	private double vidaMaximaGokuBase;
	
	//para testear cuando Goku esta en xx.99% justo cuando se activa la furia
	private double limite;
	
	
	@Before
	public void before(){
		vidaMaximaGokuBase = new GokuBase(null).getVidaMaxima();
		limite = 0.0000000000000001;
	}
	
	@Test
	public void testAlBajarLaVidaDeGokuSuficientementeParaQueActiveFuriaCambiaSuPoder() {
		
		Goku goku = new Goku();
		double poderInicial = goku.getPoder();
		goku.modificarVida(-(goku.getVida() * (1 - Furia.porcentajeVidaNecesaria + limite )));
		assertEquals(poderInicial*1.2, goku.getPoder(), 0.5);
		
	}
	@Test
	public void testAlRestaurarLaVidaDeGokuSeDesactivaFuriaYSuPoderSeDecrementa(){
		Goku goku = new Goku();
		double poderInicial = goku.getPoder();
		goku.modificarVida(-(goku.getVida() * (1 - Furia.porcentajeVidaNecesaria + limite )));
		goku.modificarVida(vidaMaximaGokuBase);
		goku.getPoder();
		assertEquals(poderInicial, goku.getPoder(), 0.5);
	}
	@Test
	public void testAtacarConFuriaAUnEnemigoLoDanaMas(){
		Goku goku = new Goku();
		
		
		Cell cell = new Cell();
		
		double vidaCellAntesDeRecibirAtaqueSinFuria = cell.getVida();
		goku.atacarA(cell);
		double vidaCellPosteriorRecibirAtaqueSinFuria = cell.getVida();
		double danoDeGokuSinFuria = vidaCellAntesDeRecibirAtaqueSinFuria - vidaCellPosteriorRecibirAtaqueSinFuria;
		
		goku.modificarVida(-(goku.getVida() * (1 - Furia.porcentajeVidaNecesaria + limite )));
		
		double vidaCellAntesDeRecibirAtaqueConFuria = cell.getVida();
		goku.atacarA(cell);
		double vidaCellPosteriorRecibirAtaqueConFuria = cell.getVida();
		double danoDeGokuConFuria = vidaCellAntesDeRecibirAtaqueConFuria - vidaCellPosteriorRecibirAtaqueConFuria;
		assertNotSame(danoDeGokuConFuria, danoDeGokuSinFuria);
	}
}
