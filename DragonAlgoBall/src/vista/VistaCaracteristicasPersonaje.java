package vista;

import dab.personajes.Personaje;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import utils.FabricadorDeRepresentacionDeAvatar;

public class VistaCaracteristicasPersonaje extends VBox{
	private Personaje personaje;
	private FabricadorDeRepresentacionDeAvatar fabricador = new FabricadorDeRepresentacionDeAvatar();
	private String rutaHP = "/vista/imagenes/hud/hp.png";
	private String rutaPP = "/vista/imagenes/hud/pp.png";
	private String rutaKI = "/vista/imagenes/hud/ki.png";
	
	public VistaCaracteristicasPersonaje(Personaje personaje){
		this.personaje = personaje;
		this.setVista();
	}
	
	private void setVista(){
		this.setSpacing(5);
        this.setPadding(new Insets(10));
        //this.setStyle("-fx-background-color: #ffb400; -fx-border-color: red; -fx-border-width: 4px; -fx-border-radius: 5px; -fx-padding: 10;");
        this.dibujar(this.personaje);
	}
	
	
	public void dibujar(Personaje personaje){
		if(personaje != null){
			String fuente = "Arial";
			int tamanioFuente = 26;
			String nombre = personaje.getNombre();
			Label etiquetaNombre = new Label(nombre);
			etiquetaNombre.setFont(new Font(fuente,tamanioFuente));
			etiquetaNombre.setStyle("color: white");
			
			HBox avatarYDatos = new HBox(5);
			String rutaAvatar = fabricador.fabricarAvatar(personaje.getNombre());
			Image avatar = new Image(rutaAvatar);
			Label avatarLabel = new Label();
			avatarLabel.setGraphic(new ImageView(avatar));
			
			VBox datos = new VBox(0);

			double vida = personaje.getVida();
			int ki = personaje.getKi();
			double poderDeAtaque = personaje.getPoder();

			Label etiquetaVida = new Label(String.valueOf(vida));
			Image vidaIcon = new Image(rutaHP);
			etiquetaVida.setGraphic(new ImageView(vidaIcon));

			Label etiquetaPoderDeAtaque = new Label(String.valueOf(poderDeAtaque));
			Image poderDeAtaqueIcon = new Image(rutaPP);
			etiquetaPoderDeAtaque.setGraphic(new ImageView(poderDeAtaqueIcon));
			
			Label etiquetaKi = new Label(String.valueOf(ki));
			Image kiIcon = new Image(rutaKI);
			etiquetaKi.setGraphic(new ImageView(kiIcon));
			
			datos.getChildren().addAll(etiquetaVida,etiquetaKi,etiquetaPoderDeAtaque);
			avatarYDatos.getChildren().addAll(avatarLabel, datos);
			this.getChildren().addAll(etiquetaNombre, avatarYDatos);
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