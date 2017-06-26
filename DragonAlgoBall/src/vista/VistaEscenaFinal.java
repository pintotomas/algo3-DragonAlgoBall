package vista;

import java.util.HashMap;

import dab.usuario.Usuario;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.Ajustes;
import utils.reproductorDeSonidos.ReproductorDeSonidos;
import vista.eventos.AbandonarPartidaEventHandler;
import vista.eventos.CambiarEscenaAlPresionarEventHandler;

public class VistaEscenaFinal extends StackPane {
	
		
		
		@SuppressWarnings("serial")
		private final HashMap<String, String> fondoGanador = new HashMap<String, String>() {{
		    put("Guerreros Z", "vista/Imagenes/ganadorGuerrerosZ.jpg");
		    put("Enemigos de la Tierra", "vista/Imagenes/ganadorEnemigos.jpg");
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
	 	

}


	private void mostrarEstadisticasDelGanador(Usuario usuarioGanador) {
		VBox caracteristicas = new VBox();
		Label nombre = new Label("Nombre "+usuarioGanador.getNombre());
		nombre.setGraphic(new ImageView(new Image("/resources/imagenes/iconos/user-name.png")));
		Label cantidadMovimientos = new Label("Cantidad de movimientos: "+String.valueOf(usuarioGanador.getCantidadMovimientos()));
		cantidadMovimientos.setGraphic(new ImageView(new Image("/resources/imagenes/iconos/steps.png")));
		Label cantidadAtaques = new Label("Cantidad de ataques: "+String.valueOf(usuarioGanador.getCantidadDeAtaques()));
		cantidadAtaques.setGraphic(new ImageView(new Image("/resources/imagenes/iconos/attack.png")));
		Label cantidadAsesinatos = new Label("Cantidad de asesinatos: "+String.valueOf(usuarioGanador.getCantidadDeAsesinatos()));
		cantidadAsesinatos.setGraphic(new ImageView(new Image("/resources/imagenes/iconos/sword.png")));
		Label cantidadPerdidas = new Label("Cantidad de perdidas: "+String.valueOf(usuarioGanador.getCantidadDePersonajesPerdidos()));
		cantidadPerdidas.setGraphic(new ImageView(new Image("/resources/imagenes/iconos/skull.png")));
		Label cantidadEsferasDelDragonConseguidas = new Label("Cantidad de esferas del dragon obtenidas: "+String.valueOf(usuarioGanador.cantidadDeItemsParaGanar()));
		cantidadEsferasDelDragonConseguidas.setGraphic(new ImageView(new Image("/resources/imagenes/iconos/EsferaDelDragon.png")));
		caracteristicas.getChildren().addAll(nombre, cantidadMovimientos, cantidadAtaques, cantidadAsesinatos, cantidadPerdidas,
				cantidadEsferasDelDragonConseguidas);
		this.getChildren().add(caracteristicas);
		caracteristicas.setAlignment(Pos.CENTER);
	}


	private void setBotones() {

		String estiloTransparente = "-fx-background-color: transparent;";
		Button botonVolverAlMenuPrincipal = creadorDeBoton("vista/Imagenes/volverAlMenuPrincipal.png", estiloTransparente);
	 	
		AbandonarPartidaEventHandler botonJugarHandler = new AbandonarPartidaEventHandler(stage, reproductorMusicaGanador, ajustesEfectosDePersonajes, ajustesMusicaDeBatalla, ajustesMusicaEnding, "Esta seguro?");
		botonVolverAlMenuPrincipal.setOnMouseClicked(botonJugarHandler);
		botonVolverAlMenuPrincipal.setAlignment(Pos.BOTTOM_CENTER);
	    this.getChildren().addAll(botonVolverAlMenuPrincipal);
	    StackPane.setAlignment(botonVolverAlMenuPrincipal, Pos.BOTTOM_CENTER);
		
	}


	private Button creadorDeBoton(String direccionImagen, String style){
		Button nuevoBoton = new Button();
		Image imagen = new Image(direccionImagen);
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
		 Image imagenDeFondo = new Image(fondoGanador.get(nombreEquipoGanador));
		 ImageView vistaFondoMenu = new ImageView(imagenDeFondo);
			 
		 vistaFondoMenu.fitWidthProperty().bind(stage.widthProperty());
		 vistaFondoMenu.fitHeightProperty().bind(stage.heightProperty());
			
		 this.getChildren().add(vistaFondoMenu);
	}
}
