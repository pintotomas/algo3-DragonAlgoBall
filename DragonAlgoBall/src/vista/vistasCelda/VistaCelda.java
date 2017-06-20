package vista.vistasCelda;

import dab.juego.Celda;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
//import javafx.scene.text.TextAlignment;

public abstract class VistaCelda {
	
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
	
	public StackPane dibujar(){
		Text text;
		
		rectangulo = new Rectangle();

		rectangulo.setWidth(recHeight);
		rectangulo.setHeight(recWidth);
		rectangulo.setFill(color);
		darPropiedadesARectangulo();
		
		//Creo que se deberia crear una ficha 'vacia' para no tener que preguntar esto
		if (celda.estaOcupada()){
			text = new Text(celda.getFicha().getNombre());
		}
		else{
			text = new Text("");
		}
		
	    StackPane layout = new StackPane();
	    layout.getChildren().addAll(
	                rectangulo,
	                text
	        );
		return layout;
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
