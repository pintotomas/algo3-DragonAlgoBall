package vista.vistasCelda;

import dab.juego.Celda;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
//import javafx.scene.text.TextAlignment;
import vista.fabricadorPersonaje.FabricadorDeRepresentacionDePersonaje;

public abstract class VistaCelda extends StackPane{
	
	protected Celda celda;
	protected Rectangle rectangulo;
	private int recHeight = 55;
	private int recWidth = 55;
	
	protected Color color;
	
//	private Color colorUnpressed = Color.AQUAMARINE;
//	private Color colorPressed = Color.PALEVIOLETRED;

	
	public VistaCelda(Celda celda){
		this.celda = celda;
		
	}
	
	protected void setup(){
		Text text;
		
		rectangulo = new Rectangle();

		rectangulo.setWidth(recHeight);
		rectangulo.setHeight(recWidth);
		rectangulo.setFill(color);
		
		darPropiedadesARectangulo();
		
		//Creo que se deberia crear una ficha 'vacia' para no tener que preguntar esto
		if (celda.estaOcupada()){
			FabricadorDeRepresentacionDePersonaje fabricador = new FabricadorDeRepresentacionDePersonaje();
			String urlImagenRepresentadora = fabricador.fabricarPersonaje(celda.getFicha().getNombre());
			System.out.println(urlImagenRepresentadora);
			Image imagenRepresentador = new Image(urlImagenRepresentadora);
			
			Pane pane = new Pane();
			pane.setStyle(("-fx-background-image: url('" +imagenRepresentador + "'); " +
			   " -fx-background-repeat: no-repeat;"+
			    "-fx-background-size: contain;"));
			text = new Text(celda.getFicha().getNombre());
			
			this.getChildren().addAll(pane,rectangulo, text);
//			this.getChildren().addAll(rectangulo, text);
		}
		else{
			text = new Text("");
			this.getChildren().addAll(rectangulo, text);
		}
		
	    
	}
	
	public void darPropiedadesARectangulo(){
		
		rectangulo.setStroke(Color.BLACK);
	}


	public boolean estaOcupada(){
		return celda.estaOcupada();
	}

	public int getColumna() {
		return celda.getColumna();
	}
	
	public int getFila() {
		return celda.getFila();
	}

	public Celda getCelda() {
		return celda;
	}
	

	
}
