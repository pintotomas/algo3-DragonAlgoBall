package vista;

import dab.juego.Juego;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane{
	Stage stage;
	BarraDeMenu barraDeMenu;
	private Juego juego;
	private VistaTablero tablero;
	
	public ContenedorPrincipal(Stage stage, Juego juegoDAB){
		this.stage = stage;
		this.juego = juegoDAB;
		this.setMenu(stage);
		this.setTablero(stage);
	}
	
	private void setMenu(Stage stage){
		this.barraDeMenu = new BarraDeMenu(stage);
        this.setTop(barraDeMenu);
        
	}
	
	private void setTablero(Stage stage){
		this.tablero = new VistaTablero(stage);
		this.setCenter(tablero);
	}
	
	public BarraDeMenu getBarraDeMenu(){
		return this.barraDeMenu;
	}
}