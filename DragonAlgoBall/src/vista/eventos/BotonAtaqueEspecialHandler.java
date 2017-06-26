package vista.eventos; 
 
import dab.juego.Juego;
import dab.personajes.Personaje;
import utils.Ajustes;
import utils.reproductorDeSonidos.ReproductorSonidosEspeciales;
import vista.VistaTablero; 
 
public class BotonAtaqueEspecialHandler extends BotonAtaqueEventHandler { 
    
   
  public BotonAtaqueEspecialHandler(Personaje enemigo, Juego juego, VistaTablero vistaTablero, Ajustes ajustesEfectosDePersonajes){ 
    super(enemigo, juego, vistaTablero, ajustesEfectosDePersonajes);
  } 
   


  @Override
  protected void efectuarAtaque() {
	juego.personajeSeleccionadoAtaqueEspecialA(enemigo); 
	vistaTablero.actualizarInformacionDelTurnoActual();
	
  }

  @Override
  protected void correrSonido() {
	  if (ajustesEfectosDePersonajes.estaActivo()){
		  ReproductorSonidosEspeciales.reproducir(juego.personajeSeleccionado().getNombre());
	  }
	
  } 
 
} 
