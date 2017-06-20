package vista;

import dab.juego.Juego;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import vista.eventos.BotonPasarTurnoEventHandler;
import vista.vistasCelda.VistaCelda;

public class BotoneraDerecha extends VBox{
	private Juego juego;
	
	public BotoneraDerecha(Juego juego){
		this.juego = juego;
		this.setSpacing(10);
		this.setPadding(new Insets(30));
		this.setBotonCederTurno();
	}
	
	private void setBotonCederTurno(){
		Button botonPasarTurno = new Button("CEDER TURNO");
		BotonPasarTurnoEventHandler pasarTurnoEventHandler = new BotonPasarTurnoEventHandler(juego);
	    botonPasarTurno.setOnAction(pasarTurnoEventHandler);
	    this.getChildren().add(botonPasarTurno); 
	}
}