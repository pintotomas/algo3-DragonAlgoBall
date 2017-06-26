package vista;

import dab.juego.Juego;
import dab.usuario.Usuario;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VistaInformacionDelJugadorActual extends VBox {

	private Juego juego;
	
	public VistaInformacionDelJugadorActual(Juego juego) {
	
		this.juego = juego;
		this.refrescarInformacion();
	}
	
	public void refrescarInformacion(){
		this.getChildren().clear();
		Usuario userActual = juego.obtenerJugadorActual();
		Label nombreDelJugador = new Label("Es tu turno "+userActual.getNombre()+"!");
		this.getChildren().add(nombreDelJugador);
		
		int cantidadEsferasDelDragonCapturadas = userActual.cantidadDeItemsParaGanar();
		HBox informacionEsferasDelDragon = new HBox();
		informacionEsferasDelDragon.setAlignment(Pos.CENTER);
		Label textoInformativoEsferasDelDragon = new Label("Esferas del dragon obtenidas: ");

		informacionEsferasDelDragon.getChildren().add(textoInformativoEsferasDelDragon);
		for (int i = 0; i < cantidadEsferasDelDragonCapturadas; i++){
			informacionEsferasDelDragon.getChildren().add(new ImageView(new Image("/resources/imagenes/iconos/EsferaDelDragon.png")));
		}
		this.getChildren().add(informacionEsferasDelDragon);
		
	}
	
	
	

}
