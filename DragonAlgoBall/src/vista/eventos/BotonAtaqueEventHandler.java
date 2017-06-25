package vista.eventos;

import dab.juego.Juego;
import dab.personajes.Personaje;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import utils.Ajustes;
import vista.VistaTablero;

public abstract class BotonAtaqueEventHandler implements EventHandler<MouseEvent>{
	   
	  protected Personaje enemigo; 
	  protected Juego juego; 
	  protected VistaTablero vistaTablero;
	  protected Ajustes ajustesEfectosDePersonajes;   
	  
	  public BotonAtaqueEventHandler(Personaje enemigo, Juego juego, VistaTablero vistaTablero, Ajustes ajustesEfectosDePersonajes){ 
	    this.enemigo = enemigo; 
	    this.juego = juego; 
	    this.vistaTablero = vistaTablero; 
	    this.ajustesEfectosDePersonajes = ajustesEfectosDePersonajes;
	  } 
	   
	  @Override 
	  public void handle(MouseEvent event) { 
 
		 efectuarAtaque();
	     juego.seHaEfectuadoUnAtaque(); 
	     vistaTablero.dibujarTableroSinNingunaSeleccion(); 
	     vistaTablero.actualizarVistaDePersonajes(); 
	     correrSonido();

	    }
	  
	  protected abstract void efectuarAtaque();
	  protected abstract void correrSonido();
	     
	} 
	  

