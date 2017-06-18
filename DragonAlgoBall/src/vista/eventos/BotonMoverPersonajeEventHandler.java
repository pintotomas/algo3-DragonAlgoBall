package vista.eventos;

import dab.juego.Tablero;
import dab.juego.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonMoverPersonajeEventHandler implements EventHandler<ActionEvent>{
	Turno turno;
	Tablero tablero;
	
	public BotonMoverPersonajeEventHandler(Turno turno){
				
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.juego.setNombreUsuarioEnemigosDeLaTierra(this.campoTextoEnemigos.getText());
		this.juego.setNombreUsuarioGuerrerosZ(this.campoTextoGuerreros.getText());
		this.stage.setScene(proximaEscena);
		stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
	}
}
