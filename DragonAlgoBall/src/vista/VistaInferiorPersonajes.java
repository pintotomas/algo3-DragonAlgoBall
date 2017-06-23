package vista;
	
import java.util.ArrayList;

import dab.juego.Juego;
import dab.personajes.Personaje;
import javafx.scene.layout.GridPane;
import vista.eventos.BotonPersonajeInferiorHandler;
	
public class VistaInferiorPersonajes extends GridPane{
	VistaCaracteristicasPersonaje seleccionado;
	ArrayList<VistaCaracteristicasPersonaje> personajesAliados;
	int cantidadDePersonajes = 3; //obviamente hay que cambiar esto.
	Juego juego;
	VistaTablero vistaTablero;
	VistaEnemigo enemigo;
	public VistaInferiorPersonajes(Juego juego){
		this.juego = juego;
		seleccionado = new VistaCaracteristicasPersonaje(null);
		personajesAliados = new ArrayList<VistaCaracteristicasPersonaje>();	
	}
	
	public void setTablero(VistaTablero vistaTablero){
		this.vistaTablero = vistaTablero;
	}
	
	public void setPersonajeDeTurno(){
		this.getChildren().clear();
		VistaCaracteristicasPersonaje vista;
		int i = 0;
		for(Personaje x : juego.getPersonajesDeTurno()){
			vista = new VistaCaracteristicasPersonaje(x);
			personajesAliados.add(vista);
			VistaInferiorPersonajes.setColumnIndex(vista, i);
			BotonPersonajeInferiorHandler boton  = new BotonPersonajeInferiorHandler(vista, vistaTablero.getCeldas());
			vista.setOnMousePressed(boton);
			this.getChildren().add(vista);
			i++;
			this.enemigo = new VistaEnemigo(null, juego, vistaTablero);
			VistaInferiorPersonajes.setColumnIndex(enemigo, i);
			this.getChildren().add(enemigo);
		}
	}

	
	public void updateSeleccionado(Personaje personajeSeleccionado) {
		seleccionado.update(personajeSeleccionado);
	}
	
	
	public void updateEnemigo(Personaje personajeEnemigo){
		this.enemigo.update(personajeEnemigo);
	}
	
	
	
	
	
	
	
	
}	