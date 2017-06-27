package vista.vistasCelda;

import dab.juego.Celda;
import javafx.scene.paint.Color;

public class VistaCeldaSeleccionada extends VistaCelda{

	public VistaCeldaSeleccionada(Celda celda) {
		super(celda);
		super.setup();
	}
	
	public void darPropiedadesARectangulo(){
		rectangulo.setStroke(Color.YELLOW);
	}

}
