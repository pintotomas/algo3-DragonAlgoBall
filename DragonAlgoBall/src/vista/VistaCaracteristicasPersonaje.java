package vista;

import dab.personajes.Personaje;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import utils.Ajustes;
import utils.FabricadorDeRepresentacionDeAvatar;

import javafx.scene.layout.VBox;
import vista.eventos.BotonTransformarHandler;


public class VistaCaracteristicasPersonaje extends VBox{
	private Personaje personaje;
	private FabricadorDeRepresentacionDeAvatar fabricador = new FabricadorDeRepresentacionDeAvatar();
	private String rutaHP = "/vista/imagenes/hud/hp.png";
	private String rutaPP = "/vista/imagenes/hud/pp.png";
	private String rutaKI = "/vista/imagenes/hud/ki.png";
	protected Ajustes ajustesSonidosEspeciales;
	
	public VistaCaracteristicasPersonaje(Personaje personaje, Ajustes ajustesSonidosEspeciales){
		this.personaje = personaje;
		this.ajustesSonidosEspeciales = ajustesSonidosEspeciales;
		this.setVista();
	}
	private void setVista(){
		this.setSpacing(5);
        this.setPadding(new Insets(10));
        this.getStyleClass().add("marcoPersonaje");
        this.dibujar(this.personaje);
	}

	
	public void dibujar(Personaje personaje){
		if(personaje != null){
			Label nombre = generarVistaNombre(personaje);
			HBox avatarYDatos = generarVistaAvatarYDatos(personaje);
			Button botonTransformar = generarBotonTransformar();
			this.getChildren().addAll(nombre, avatarYDatos, botonTransformar);
		}else{
			this.getChildren().clear();
		}
	}
	
	public HBox generarVistaAvatarYDatos(Personaje personaje){
		HBox avatarYDatos = new HBox(5);
		Label avatar = generarAvatar(personaje);
		VBox datos = new VBox(0);
		Label vida = generarVistaVida(personaje);
		Label ki = generarVistaKi(personaje);
		Label poder = generarVistaPoder(personaje);
		datos.getChildren().addAll(vida, ki, poder);
		avatarYDatos.getChildren().addAll(avatar, datos);
		return avatarYDatos;
	}
	
	public Label generarVistaNombre(Personaje personaje){
		String nombre = personaje.getNombre();
		Label etiquetaNombre = new Label(nombre);
		etiquetaNombre.getStyleClass().addAll("nombrePersonaje","outline");
		return etiquetaNombre;
	}
	
	private Label generarAvatar(Personaje personaje){
		String rutaAvatar = fabricador.fabricarAvatar(personaje.getNombre());
		Image avatar = new Image(rutaAvatar);
		Label avatarLabel = new Label();
		avatarLabel.setGraphic(new ImageView(avatar));
		return avatarLabel;
	}

	private Label generarVistaVida(Personaje personaje){
		double vida = personaje.getVida();
		Label etiquetaVida = new Label(String.valueOf(vida));
		Image vidaIcon = new Image(rutaHP);
		etiquetaVida.setGraphic(new ImageView(vidaIcon));
		return etiquetaVida;
	}
	
	private Label generarVistaKi(Personaje personaje){
		int ki = personaje.getKi();
		Label etiquetaKi = new Label(String.valueOf(ki));
		Image kiIcon = new Image(rutaKI);
		etiquetaKi.setGraphic(new ImageView(kiIcon));
		return etiquetaKi;
	}
	
	private Label generarVistaPoder(Personaje personaje){
		double poderDeAtaque = personaje.getPoder();
		Label etiquetaPoderDeAtaque = new Label(String.valueOf(poderDeAtaque));
		Image poderDeAtaqueIcon = new Image(rutaPP);
		etiquetaPoderDeAtaque.setGraphic(new ImageView(poderDeAtaqueIcon));
		return etiquetaPoderDeAtaque;
	}
	public void update(Personaje personaje){
		this.getChildren().clear();
		this.dibujar(personaje);
	}
	
	
	public Button generarBotonTransformar(){
		Button boton = new Button ("TRANSFORMAR");

		boton.setOnMousePressed(new BotonTransformarHandler(personaje, this, ajustesSonidosEspeciales));
		if(!personaje.transformarDisponible()){
			boton.setDisable(true);
		}

		return boton;
	}
	
	
	
	public Personaje getPersonaje(){
		return this.personaje;
	}
	
	
}