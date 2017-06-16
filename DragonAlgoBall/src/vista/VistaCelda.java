package vista;

import dab.juego.Celda;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

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
	
	public Rectangle dibujar(){
		rectangulo.setWidth(recHeight);
		rectangulo.setHeight(recWidth);
		rectangulo.setFill(Color.AQUAMARINE);
		rectangulo.setStroke(Color.BLACK);
		
		return rectangulo;
	}

	public Text getTextoRepresentativo() {
		// TODO Auto-generated method stub
		Text texto;
		if (celda.estaOcupada()){
			texto = new Text("O");
		}
		else{
			texto = new Text("L");
		}
		return texto;
	}
	
	
	
}
