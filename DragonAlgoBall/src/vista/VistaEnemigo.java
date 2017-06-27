package vista;

import dab.juego.Juego;
import dab.personajes.Personaje;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import utils.Ajustes;
import vista.eventos.BotonAtaqueEspecialHandler;
import vista.eventos.BotonAtaqueNormalHandler;

public class VistaEnemigo extends VistaCaracteristicasPersonaje{
	private Personaje personaje;
	private VistaTablero vistaTablero;
	private Juego juego;
	private String rutaAtaque = "/vista/imagenes/hud/ataque.png";
	private String rutaEspecial = "/vista/imagenes/hud/especial.png";
	
	public VistaEnemigo(Personaje personaje, Juego juego, VistaTablero vistaTablero, Ajustes ajustesSonidosEspeciales){
		super(personaje, ajustesSonidosEspeciales, vistaTablero);
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
			VBox nombreYDatos = new VBox(5);
			Label nombre = generarVistaNombre(personaje);
			HBox avatarYDatos = generarVistaAvatarYDatos(personaje);
			nombreYDatos.getChildren().addAll(nombre, avatarYDatos);
			nombreYDatos.setPadding(new Insets(10,0,0,10));

			VBox acciones = generarVistaAcciones(personaje);
			HBox vistaYAcciones = new HBox(10);
			vistaYAcciones.getChildren().addAll(nombreYDatos, acciones);
			this.getChildren().add(vistaYAcciones);
		}else{
			this.getChildren().clear();
		}
	}
	private VBox generarVistaAcciones(Personaje personaje){
		VBox acciones = new VBox(10);
		acciones.setPadding(new Insets(10,0,0,10));
		acciones.setAlignment(Pos.CENTER_LEFT);
		Button ataqueNormal = new Button();
		Image ataque = new Image(rutaAtaque);
		ataqueNormal.setGraphic(new ImageView(ataque));
		ataqueNormal.setOnMousePressed(new BotonAtaqueNormalHandler(personaje, juego, vistaTablero, ajustesSonidosEspeciales));
		Button ataqueEspecial = new Button();
		Image especial = new Image(this.getClass().getResource(rutaEspecial).toExternalForm());
		ataqueEspecial.setGraphic(new ImageView(especial));
		ataqueEspecial.setOnMousePressed(new BotonAtaqueEspecialHandler(personaje, juego, vistaTablero, ajustesSonidosEspeciales));
		if(!juego.personajeSeleccionadoTieneAtaqueEspecialDisponible()){
			ataqueEspecial.setDisable(true);
		}

		acciones.getChildren().addAll(ataqueNormal, ataqueEspecial);
		return acciones;
	}
	
	public void update(Personaje personaje){
		this.getChildren().clear();
		this.dibujar(personaje);
	}
	
	public Personaje getPersonaje(){
		return this.personaje;
	}
	
	
}