package vista;

import dab.juego.Celda;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
//import javafx.scene.text.TextAlignment;

public class VistaCelda {
	
	private Celda celda;
	private Rectangle rectangulo;
	private int recHeight = 70;
	private int recWidth = 70;
	
	private Color colorUnpressed = Color.AQUAMARINE;
	private Color colorPressed = Color.PALEVIOLETRED;

	
	public VistaCelda(Celda celda){
		this.celda = celda;
		rectangulo = new Rectangle();
		rectangulo.setFill(colorUnpressed);
	}
	
	public StackPane dibujar(){
		Text text;
		
		//Creo que se deberia crear una ficha 'vacia' para no tener que preguntar esto
		if (celda.estaOcupada()){
			text = new Text(celda.getFicha().getNombre());
		}
		else{
			text = new Text("");
		}
		
		rectangulo.setWidth(recHeight);
		rectangulo.setHeight(recWidth);
		rectangulo.setFill(Color.AQUAMARINE);
		rectangulo.setStroke(Color.BLACK);
	    StackPane layout = new StackPane();
	    layout.getChildren().addAll(
	                rectangulo,
	                text
	        );
		return layout;
	}
	
	public void presionada(){
		
		rectangulo.setFill(colorPressed);
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
