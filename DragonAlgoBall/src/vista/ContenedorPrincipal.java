package vista;

import dab.juego.Juego;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane{
	Stage stage;
	BarraDeMenu barraDeMenu;
	private Juego juego;
	
	public ContenedorPrincipal(Stage stage, Juego juegoDAB){
		this.stage = stage;
		this.juego = juegoDAB;
		this.setMenu(stage);
	}
	
	private void setMenu(Stage stage){
		this.barraDeMenu = new BarraDeMenu(stage);
        this.setTop(barraDeMenu);
	}
	
	public BarraDeMenu getBarraDeMenu(){
		return this.barraDeMenu;
	}
}