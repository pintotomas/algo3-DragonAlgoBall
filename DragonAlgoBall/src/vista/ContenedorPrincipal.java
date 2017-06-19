package vista;

import dab.juego.Juego;
import dab.usuario.Usuario;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane{
	Stage stage;
	BarraDeMenu barraDeMenu;
	private Juego juego;
	private VistaTablero tablero;
	private int altoTablero = 10;
	private int anchoTablero = 11;
	
	public ContenedorPrincipal(Stage stage, Usuario usuariogz, Usuario usuarioenemigos){
		
		juego = new Juego(altoTablero, anchoTablero, usuariogz, usuarioenemigos);
		this.stage = stage;
		this.setMenu(stage);
		this.setTablero(stage);
	}
	
	private void setMenu(Stage stage){
		this.barraDeMenu = new BarraDeMenu(stage);
        this.setTop(barraDeMenu);
        
	}
	
	private void setTablero(Stage stage){
		this.tablero = new VistaTablero(stage, juego);
		this.setCenter(tablero);
	}
	
	public BarraDeMenu getBarraDeMenu(){
		return this.barraDeMenu;
	}
}