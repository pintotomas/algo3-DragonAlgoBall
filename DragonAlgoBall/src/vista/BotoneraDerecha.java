package vista;

import dab.juego.Juego;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import utils.Ajustes;
import utils.reproductorDeSonidos.ReproductorDeSonidos;
import vista.eventos.BotonPasarTurnoEventHandler;
import vista.eventos.ControlMusicaDeBatallaEventHandler;
import vista.eventos.ControlSonidosEspecialesEventHandler;

public class BotoneraDerecha extends VBox{
	private Juego juego;
	
	public BotoneraDerecha(Juego juego, VistaTablero vistaTablero, ReproductorDeSonidos reproductorMusicaDeBatalla, Ajustes ajusteMusicaDeBatalla,
			Ajustes ajusteSonidosEspeciales){
		this.juego = juego;
		this.setSpacing(10);
		this.setPadding(new Insets(30));
		this.setBotonCederTurno(vistaTablero);
		this.setBotonControlMusicaDeBatalla( reproductorMusicaDeBatalla,  ajusteMusicaDeBatalla);
		this.setBotonControlSonidosEspeciales(ajusteSonidosEspeciales);
	}
	

	private void setBotonCederTurno(VistaTablero vistaTablero){
		Button botonPasarTurno = new Button("CEDER TURNO");
		BotonPasarTurnoEventHandler pasarTurnoEventHandler = new BotonPasarTurnoEventHandler(juego, vistaTablero);
	    botonPasarTurno.setOnAction(pasarTurnoEventHandler);
	    botonPasarTurno.getStyleClass().add("boton");
	    this.getChildren().add(botonPasarTurno);
	}
	private void setBotonControlMusicaDeBatalla(ReproductorDeSonidos reproductorMusicaDeBatalla,
			Ajustes ajusteMusicaDeBatalla) {
		Button botonPararMusicaDeBatalla = new Button("PARAR/COMENZAR MUSICA DE BATALLA");
		botonPararMusicaDeBatalla.setOnMousePressed(new ControlMusicaDeBatallaEventHandler(reproductorMusicaDeBatalla));
		if (!ajusteMusicaDeBatalla.estaActivo()){
			botonPararMusicaDeBatalla.setDisable(true);
		}
		this.getChildren().add(botonPararMusicaDeBatalla);
	}
	
	private void setBotonControlSonidosEspeciales(Ajustes ajusteSonidosEspeciales){
		Button botonSilenciarSonidosDeBatalla = new Button("Silenciar/ activar sonidos especiales");
		botonSilenciarSonidosDeBatalla.setOnMousePressed(new ControlSonidosEspecialesEventHandler(ajusteSonidosEspeciales));
		this.getChildren().add(botonSilenciarSonidosDeBatalla);
	}
}