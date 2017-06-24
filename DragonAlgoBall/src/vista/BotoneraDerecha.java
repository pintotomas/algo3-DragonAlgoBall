package vista;

import dab.juego.Juego;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import utils.Ajustes;
import utils.reproductorDeSonidos.ReproductorDeSonidos;
import vista.eventos.BotonPasarTurnoEventHandler;
import vista.eventos.ControlMusicaDeBatallaEventHandler;

public class BotoneraDerecha extends VBox{
	private Juego juego;
	
	public BotoneraDerecha(Juego juego, VistaTablero vistaTablero, ReproductorDeSonidos reproductorMusicaDeBatalla, Ajustes ajusteMusicaDeBatalla){
		this.juego = juego;
		this.setSpacing(10);
		this.setPadding(new Insets(30));
		this.setBotonCederTurno(vistaTablero);
		this.setBotonControlMusicaDeBatalla( reproductorMusicaDeBatalla,  ajusteMusicaDeBatalla);
	}
	

	private void setBotonCederTurno(VistaTablero vistaTablero){
		Button botonPasarTurno = new Button("CEDER TURNO");
		BotonPasarTurnoEventHandler pasarTurnoEventHandler = new BotonPasarTurnoEventHandler(juego, vistaTablero);
	    botonPasarTurno.setOnAction(pasarTurnoEventHandler);
	    this.getChildren().add(botonPasarTurno);
	}
	private void setBotonControlMusicaDeBatalla(ReproductorDeSonidos reproductorMusicaDeBatalla,
			Ajustes ajusteMusicaDeBatalla) {
		Button botonMutearMusicaDeBatalla = new Button("PARAR/COMENZAR MUSICA DE BATALLA");
		botonMutearMusicaDeBatalla.setOnMousePressed(new ControlMusicaDeBatallaEventHandler(reproductorMusicaDeBatalla));
		if (!ajusteMusicaDeBatalla.estaActivo()){
			botonMutearMusicaDeBatalla.setDisable(true);
		}
		this.getChildren().add(botonMutearMusicaDeBatalla);
	}
}