package vista;
	
import java.util.ArrayList;

import dab.juego.Juego;
import dab.personajes.Personaje;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import vista.eventos.BotonPersonajeInferiorHandler;
	
public class VistaInferiorPersonajes extends GridPane{
	VistaCaracteristicasPersonaje seleccionado;
	HBox personajesAliados;
	Juego juego;
	VistaTablero vistaTablero;
	VistaEnemigo enemigo;
	public VistaInferiorPersonajes(Juego juego){
		this.juego = juego;
		seleccionado = new VistaCaracteristicasPersonaje(null);
		personajesAliados = new HBox();
		this.setPadding(new Insets(0,0,5,5));
		this.setHgap(20);
		}
	
	public void setTablero(VistaTablero vistaTablero){
		this.vistaTablero = vistaTablero;
	}
	
	public void setPersonajeDeTurno(){
		this.getChildren().clear();
		VistaCaracteristicasPersonaje vista;
		HBox mostrar = new HBox(10);
		mostrar.setStyle("-fx-background-color: #ffc800; -fx-background-radius: 5px; -fx-border-color: #9a1603; "
				+ "-fx-border-width: 4px; -fx-border-radius: 5px; -fx-padding: 10;");
		mostrar.setMinWidth(500);
		mostrar.setAlignment(Pos.CENTER);
		for(Personaje x : juego.getPersonajesDeTurno()){
			vista = new VistaCaracteristicasPersonaje(x);
			personajesAliados.getChildren().add(vista);
			BotonPersonajeInferiorHandler boton  = new BotonPersonajeInferiorHandler(vista, vistaTablero.getCeldas());
			vista.setOnMousePressed(boton);
			mostrar.getChildren().add(vista);
		}
		this.enemigo = new VistaEnemigo(null, juego, vistaTablero);
		VistaInferiorPersonajes.setColumnIndex(mostrar, 0);
		VistaInferiorPersonajes.setColumnIndex(enemigo, 1);
		this.getChildren().addAll(mostrar,enemigo);
	}

	
	public void updateSeleccionado(Personaje personajeSeleccionado) {
		seleccionado.update(personajeSeleccionado);
	}
	
	
	public void updateEnemigo(Personaje personajeEnemigo){
		this.enemigo.update(personajeEnemigo);
	}
	
	
	
	
	
	
	
	
}	