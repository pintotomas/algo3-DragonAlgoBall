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
		}
	}


	public void updateSeleccionado(Personaje personajeSeleccionado) {
		seleccionado.update(personajeSeleccionado);
	}
	
	
	
	
	
	
	
	
}	