package vista;

import dab.juego.Juego;
import dab.personajes.Personaje;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vista.eventos.BotonAtaqueNormalHandler;

public class VistaEnemigo extends VistaCaracteristicasPersonaje{
	private Personaje personaje;
	VistaTablero vistaTablero;
	Juego juego;
	public VistaEnemigo(Personaje personaje, Juego juego, VistaTablero vistaTablero){
		super(personaje);
		this.juego = juego;
		this.vistaTablero = vistaTablero;
		this.setVista();
	}
	
	private void setVista(){
		this.setSpacing(5);
        this.setPadding(new Insets(50));
        this.setMinWidth(350);
        this.getStyleClass().add("vistaEnemigo");
        this.dibujar(this.personaje);
	}
	
	
	public void dibujar(Personaje personaje){
		if(personaje != null){
			HBox vistaYAcciones = new HBox(10);
			VBox nombreYDatos = new VBox(5);
			Label nombre = generarVistaNombre(personaje);
			HBox avatarYDatos = generarVistaAvatarYDatos(personaje);
			nombreYDatos.getChildren().addAll(nombre,avatarYDatos);
			nombreYDatos.setPadding(new Insets(10,0,0,10));
			VBox acciones = new VBox(10);
			acciones.setPadding(new Insets(10,0,0,10));
			acciones.setAlignment(Pos.CENTER_LEFT);
			Button ataqueNormal = new Button("ATAQUE NORMAL");
			ataqueNormal.setOnMousePressed(new BotonAtaqueNormalHandler(personaje, juego, vistaTablero));
			Button ataqueEspecial = new Button("ATAQUE ESPECIAL");
			acciones.getChildren().addAll(ataqueNormal,ataqueEspecial);
			vistaYAcciones.getChildren().addAll(nombreYDatos,acciones);
			this.getChildren().add(vistaYAcciones);
		}else{
			this.getChildren().clear();
		}
	}
	
	public void update(Personaje personaje){
		this.getChildren().clear();
		this.dibujar(personaje);
	}
	
	public Personaje getPersonaje(){
		return this.personaje;
	}
	
	
}