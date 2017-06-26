package vista;

import dab.juego.Juego;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Ajustes;
import utils.reproductorDeSonidos.ReproductorDeSonidos;
import vista.eventos.AbandonarPartidaEventHandler;
import vista.eventos.BotonPasarTurnoEventHandler;
import vista.eventos.ControlMusicaDeBatallaEventHandler;
import vista.eventos.ControlSonidosEspecialesEventHandler;

public class BotoneraDerecha extends VBox{
	
	private Juego juego;
	private Stage stage;
	
	public BotoneraDerecha(Juego juego, VistaTablero vistaTablero, ReproductorDeSonidos reproductorMusicaDeBatalla, Ajustes ajusteMusicaDeBatalla,
			Ajustes ajusteSonidosEspeciales, Stage stage){
		
		this.stage = stage;
		this.juego = juego;
		this.setSpacing(10);
		this.setPadding(new Insets(30));
		this.setBotonCederTurno(vistaTablero);
		this.setBotonControlMusicaDeBatalla( reproductorMusicaDeBatalla,  ajusteMusicaDeBatalla);
		this.setBotonControlSonidosEspeciales(ajusteSonidosEspeciales);
		this.setBotonVolverAlMenuPrincipal(ajusteSonidosEspeciales, ajusteMusicaDeBatalla, reproductorMusicaDeBatalla);
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
	

	private void setBotonVolverAlMenuPrincipal(Ajustes ajusteSonidosEspeciales, Ajustes ajusteMusicaDeBatalla, ReproductorDeSonidos reproductorMusicaDeBatalla) {
		// TODO Auto-generated method stub
		Button botonAbandonarPartida = new Button("Salir de la partida");
		botonAbandonarPartida.setOnMousePressed(new AbandonarPartidaEventHandler(ajusteSonidosEspeciales, ajusteMusicaDeBatalla, stage,
				reproductorMusicaDeBatalla));
		this.getChildren().add(botonAbandonarPartida);
	}
}