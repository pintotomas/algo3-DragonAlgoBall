package vista.vistasCelda;

import dab.juego.Celda;
import javafx.scene.paint.Color;

public class VistaCeldaInactiva extends VistaCelda{

	public VistaCeldaInactiva(Celda celda) {
		super(celda);
		color = Color.AQUAMARINE;
		super.setup();
	}
	
}
