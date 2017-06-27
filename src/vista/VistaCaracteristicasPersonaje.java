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
	private String rutaHP = "/resources/imagenes/hud/hp.png";
	private String rutaPP = "/resources/imagenes/hud/pp.png";
	private String rutaKI = "/resources/imagenes/hud/ki.png";
	protected Ajustes ajustesSonidosEspeciales;
	
	public VistaCaracteristicasPersonaje(Personaje personaje, Ajustes ajustesSonidosEspeciales,
			VistaTablero vistaTablero){
		this.personaje = personaje;
		this.ajustesSonidosEspeciales = ajustesSonidosEspeciales;
		this.setVista(vistaTablero);
	}
	private void setVista(VistaTablero vistaTablero){
		this.setSpacing(5);
        this.setPadding(new Insets(10));
        this.getStyleClass().add("marcoPersonaje");
        this.dibujar(this.personaje, vistaTablero);
	}

	
	public void dibujar(Personaje personaje, VistaTablero vistaTablero){
		if(personaje != null){
			Label nombre = generarVistaNombre(personaje);
			HBox avatarYDatos = generarVistaAvatarYDatos(personaje);
			Button botonTransformar = generarBotonTransformar(vistaTablero);
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
		Image avatar = new Image(this.getClass().getResource(rutaAvatar).toExternalForm());
		Label avatarLabel = new Label();
		avatarLabel.setGraphic(new ImageView(avatar));
		return avatarLabel;
	}

	private Label generarVistaVida(Personaje personaje){
		double vida = personaje.getVida();
		Label etiquetaVida = new Label(String.valueOf(vida));
		Image vidaIcon = new Image(this.getClass().getResource(rutaHP).toExternalForm());
		
		etiquetaVida.setGraphic(new ImageView(vidaIcon));
		return etiquetaVida;
	}
	
	private Label generarVistaKi(Personaje personaje){
		int ki = personaje.getKi();
		Label etiquetaKi = new Label(String.valueOf(ki));
		Image kiIcon = new Image(this.getClass().getResource(rutaKI).toExternalForm());
		etiquetaKi.setGraphic(new ImageView(kiIcon));
		return etiquetaKi;
	}
	
	private Label generarVistaPoder(Personaje personaje){
		double poderDeAtaque = personaje.getPoder();
		Label etiquetaPoderDeAtaque = new Label(String.valueOf(poderDeAtaque));	
		Image poderDeAtaqueIcon = new Image(this.getClass().getResource(rutaPP).toExternalForm());
		etiquetaPoderDeAtaque.setGraphic(new ImageView(poderDeAtaqueIcon));
		return etiquetaPoderDeAtaque;
	}
	public void update(Personaje personaje, VistaTablero vistaTablero){
		this.getChildren().clear();
		this.dibujar(personaje, vistaTablero);
	}
	
	
	public Button generarBotonTransformar(VistaTablero vistaTablero){
		Button boton = new Button();
		boton.getStyleClass().addAll("botonTransformar");
		boton.setOnMousePressed(new BotonTransformarHandler(personaje, this, ajustesSonidosEspeciales, vistaTablero));
		if(!personaje.transformarDisponible()){
			boton.setDisable(true);
		}
		return boton;
	}
	
	
	
	public Personaje getPersonaje(){
		return this.personaje;
	}
	
	
}