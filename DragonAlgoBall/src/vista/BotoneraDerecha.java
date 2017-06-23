package vista;

import dab.juego.Juego;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import vista.eventos.BotonPasarTurnoEventHandler;

public class BotoneraDerecha extends VBox{
	private Juego juego;
	
	public BotoneraDerecha(Juego juego, VistaTablero vistaTablero){
		this.juego = juego;
		this.setSpacing(10);
		this.setPadding(new Insets(30));
		this.setBotonCederTurno(vistaTablero);
	
	}
	
	private void setBotonCederTurno(VistaTablero vistaTablero){
		Button botonPasarTurno = new Button("CEDER TURNO");
		BotonPasarTurnoEventHandler pasarTurnoEventHandler = new BotonPasarTurnoEventHandler(juego, vistaTablero);
	    botonPasarTurno.setOnAction(pasarTurnoEventHandler);
	    this.getChildren().add(botonPasarTurno);
	}
}