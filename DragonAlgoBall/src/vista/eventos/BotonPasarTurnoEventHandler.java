//package vista.eventos;
//
//import dab.juego.Juego;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import vista.VistaCelda;
//
//public class BotonPasarTurnoEventHandler implements EventHandler<ActionEvent>{
//	
//	Juego juego;
//	VistaCelda[][] celdasGUI;
//	
//	public BotonPasarTurnoEventHandler(Juego juego, VistaCelda[][] celdasGUI){
//		this.juego = juego;
//		this.celdasGUI = celdasGUI;		
//	}
//
//	@Override
//	public void handle(ActionEvent event) {
//		juego.pasarTurno();
//		for (VistaCelda[] lista : celdasGUI){
//			for(VistaCelda celda : lista){
//				celda.liberada();
//				celda.actualizarPersonaje();
//			}
//		}
//	}
//}
