package vista.vistasCelda;

import dab.juego.Celda;
import javafx.scene.paint.Color;

public class VistaCeldaConPersonajeAtacable extends VistaCelda{

	public VistaCeldaConPersonajeAtacable(Celda celda) {
		super(celda);
		color = Color.web("#e6dd6e");
		super.setup();
	}

}
