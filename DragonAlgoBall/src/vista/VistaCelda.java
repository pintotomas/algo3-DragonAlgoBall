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
	private int recHeight = 40;
	private int recWidth = 40;

	public VistaCelda(Celda celda){
		this.celda = celda;
		rectangulo = new Rectangle();
		rectangulo.setFill(Color.AQUAMARINE);
	}
	
	public StackPane dibujar(){
		Text text;
		if (celda.estaOcupada()){
			text = new Text("O");
		}
		else{
			text = new Text("Libre");
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
	
}
