			package vista;

import java.util.HashMap;

import dab.usuario.Usuario;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import utils.Ajustes;
import utils.reproductorDeSonidos.ReproductorDeSonidos;
import vista.eventos.AbandonarPartidaEventHandler;

public class VistaEscenaFinal extends StackPane {
	
		
		
		@SuppressWarnings("serial")
		private final HashMap<String, String> fondoGanador = new HashMap<String, String>() {{
		    put("Guerreros Z", "/vista/Imagenes/ganadorGuerrerosZ.jpg");
		    put("Enemigos de la Tierra", "/vista/Imagenes/ganadorEnemigos.jpg");
		    }
		};
		@SuppressWarnings("serial")
		private final HashMap<String, String> musicaGanador = new HashMap<String, String>() {{
		    put("Guerreros Z", "/vista/sonidos/endingGuerreros.wav");
		    put("Enemigos de la Tierra", "/vista/sonidos/endingEnemigos.wav");
		    }
		};

		private String nombreEquipoGanador;
		private Stage stage;
		private Ajustes ajustesEfectosDePersonajes;
		private Ajustes ajustesMusicaDeBatalla;
		private Ajustes ajustesMusicaEnding;
		private ReproductorDeSonidos reproductorMusicaGanador;
		
	public VistaEscenaFinal(Stage stage, Usuario usuario, Ajustes ajustesMusicaDeBatalla, Ajustes ajustesEfectosDePersonajes, Ajustes ajustesMusicaEnding){
		
		nombreEquipoGanador = usuario.getEquipo().getNombre();
		reproductorMusicaGanador = new ReproductorDeSonidos(musicaGanador.get(nombreEquipoGanador));
		this.stage = stage;
		this.ajustesEfectosDePersonajes = ajustesEfectosDePersonajes;
		this.ajustesMusicaDeBatalla = ajustesMusicaDeBatalla;
		this.ajustesMusicaEnding = ajustesMusicaEnding;
		this.setFondo();   
		this.reproducirMusicaDeFondo();
		this.mostrarEstadisticasDelGanador(usuario);
	 	this.setBotones();
		String css = this.getClass().getResource("/vista/style.css").toExternalForm(); 
		this.getStylesheets().add(css);
	 	

}


	private void mostrarEstadisticasDelGanador(Usuario usuarioGanador) {
		GridPane estadisticas = new GridPane();
		estadisticas.getStyleClass().add("stats");
		estadisticas.setMaxWidth(500);
		estadisticas.setMaxHeight(300);
		ColumnConstraints column1 = new ColumnConstraints();
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setHalignment(HPos.LEFT);
		estadisticas.getColumnConstraints().addAll(column1, column2);
		
		Label labelNombre = new Label("Nombre:");
		labelNombre.setGraphic(new ImageView(new Image(this.getClass().getResource("/resources/imagenes/iconos/user-name.png").toExternalForm())));
		estadisticas.add(labelNombre, 0, 0);
		estadisticas.add(new Label(usuarioGanador.getNombre()), 1, 0);
		
		int cantidadMovimientos = usuarioGanador.getCantidadMovimientos();
		Label labelMovimientos = new Label("Cantidad de movimientos:");
		labelMovimientos.setGraphic(new ImageView(new Image(this.getClass().getResource("/resources/imagenes/iconos/steps.png").toExternalForm())));
		estadisticas.add(labelMovimientos, 0, 1);
		estadisticas.add(new Label(String.valueOf(cantidadMovimientos)), 1, 1);
		
		int cantidadAtaques = usuarioGanador.getCantidadDeAtaques();
		Label labelAtaques = new Label("Cantidad de ataques:");
		labelAtaques.setGraphic(new ImageView(new Image(this.getClass().getResource("/resources/imagenes/iconos/attack.png").toExternalForm())));
		estadisticas.add(labelAtaques, 0, 2);
		estadisticas.add(new Label(String.valueOf(cantidadAtaques)), 1, 2);
		
		int cantidadAsesinatos = usuarioGanador.getCantidadDeAsesinatos();
		Label labelAsesinatos = new Label("Cantidad de asesinatos:");
		labelAsesinatos.setGraphic(new ImageView(new Image(this.getClass().getResource("/resources/imagenes/iconos/sword.png").toExternalForm())));
		estadisticas.add(labelAsesinatos, 0, 3);
		estadisticas.add(new Label(String.valueOf(cantidadAsesinatos)), 1, 3);
		
		int cantidadMuertes = usuarioGanador.getCantidadDePersonajesPerdidos();
		Label labelMuertes = new Label("Cantidad de perdidas:");
		labelMuertes.setGraphic(new ImageView(new Image(this.getClass().getResource("/resources/imagenes/iconos/skull.png").toExternalForm())));
		estadisticas.add(labelMuertes, 0, 4);
		estadisticas.add(new Label(String.valueOf(cantidadMuertes)), 1, 4);
		
		int cantidadEsferasDelDragonConseguidas = usuarioGanador.cantidadDeItemsParaGanar();
		Label labelEsferas = new Label("Cantidad de esferas del dragon obtenidas:");
		labelEsferas.setGraphic(new ImageView(new Image(this.getClass().getResource("/resources/imagenes/iconos/EsferaDelDragon.png").toExternalForm())));
		estadisticas.add(labelEsferas, 0, 5);
		estadisticas.add(new Label(String.valueOf(cantidadEsferasDelDragonConseguidas)), 1, 5);
		this.getChildren().add(estadisticas);
		estadisticas.setAlignment(Pos.CENTER);
	}


	private void setBotones() {

		String estiloTransparente = "-fx-background-color: transparent;";
		Button botonVolverAlMenuPrincipal = creadorDeBoton("/vista/Imagenes/volverAlMenuPrincipal.png", estiloTransparente);
	 	
		AbandonarPartidaEventHandler botonJugarHandler = new AbandonarPartidaEventHandler(stage, reproductorMusicaGanador, ajustesEfectosDePersonajes, ajustesMusicaDeBatalla, ajustesMusicaEnding, "Esta seguro?");
		botonVolverAlMenuPrincipal.setOnMouseClicked(botonJugarHandler);
		botonVolverAlMenuPrincipal.setAlignment(Pos.BOTTOM_CENTER);
	    this.getChildren().addAll(botonVolverAlMenuPrincipal);
	    StackPane.setAlignment(botonVolverAlMenuPrincipal, Pos.BOTTOM_CENTER);
		
	}


	private Button creadorDeBoton(String direccionImagen, String style){
		Button nuevoBoton = new Button();
		Image imagen = new Image(this.getClass().getResource(direccionImagen).toExternalForm());
		nuevoBoton.setGraphic(new ImageView(imagen));
		nuevoBoton.setStyle(style);
		return nuevoBoton;
	}


	private void reproducirMusicaDeFondo() {
		if (this.ajustesMusicaEnding.estaActivo()){
			
			Thread thread = new Thread(reproductorMusicaGanador);
			thread.setDaemon(true);
			thread.start();
		}
	}


	private void setFondo() {
		String rutaFondoGanador = fondoGanador.get(nombreEquipoGanador);
		 Image imagenDeFondo = new Image(this.getClass().getResource(rutaFondoGanador).toExternalForm());
		 ImageView vistaFondoMenu = new ImageView(imagenDeFondo);
			 
		 vistaFondoMenu.fitWidthProperty().bind(stage.widthProperty());
		 vistaFondoMenu.fitHeightProperty().bind(stage.heightProperty());
			
		 this.getChildren().add(vistaFondoMenu);
	}
}
