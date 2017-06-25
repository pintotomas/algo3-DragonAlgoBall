package vista;
	
import dab.juego.Juego;
import dab.personajes.Personaje;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import utils.Ajustes;
import vista.eventos.BotonPersonajeInferiorHandler;
	
public class VistaInferiorPersonajes extends GridPane{
	private VistaCaracteristicasPersonaje seleccionado;
	private HBox personajesAliados;
	private Juego juego;
	private VistaTablero vistaTablero;
	private VistaEnemigo enemigo;
	private Ajustes ajustesSonidosEspeciales;
	public VistaInferiorPersonajes(Juego juego, Ajustes ajustesSonidosEspeciales){
		this.juego = juego;
		this.ajustesSonidosEspeciales = ajustesSonidosEspeciales;
		seleccionado = new VistaCaracteristicasPersonaje(null, ajustesSonidosEspeciales);
		personajesAliados = new HBox();
		this.setPadding(new Insets(0,0,5,5));
		this.setHgap(30);
		}
	
	public void setTablero(VistaTablero vistaTablero){
		this.vistaTablero = vistaTablero;
	}
	
	public void setPersonajeDeTurno(){
		this.getChildren().clear();
		VistaCaracteristicasPersonaje vista;
		HBox mostrar = new HBox(10);
		mostrar.getStyleClass().add("vistaAliados");
		mostrar.setMinWidth(500);
		mostrar.setAlignment(Pos.CENTER);
		for(Personaje x : juego.getPersonajesDeTurno()){
			vista = new VistaCaracteristicasPersonaje(x, ajustesSonidosEspeciales);
			personajesAliados.getChildren().add(vista);
			BotonPersonajeInferiorHandler boton  = new BotonPersonajeInferiorHandler(vista, vistaTablero.getCeldas());
			vista.setOnMousePressed(boton);
			mostrar.getChildren().add(vista);
		}
		this.enemigo = new VistaEnemigo(null, juego, vistaTablero, ajustesSonidosEspeciales);
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