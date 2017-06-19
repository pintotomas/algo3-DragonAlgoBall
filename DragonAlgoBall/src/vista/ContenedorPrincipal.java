package vista;

import dab.juego.Juego;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane{
	Stage stage;
	BarraDeMenu barraDeMenu;
	BotoneraDerecha botoneraDerecha;
	private Juego juego;
	private VistaTablero tablero;
	
	public ContenedorPrincipal(Stage stage, String nombreUsuarioGuerreros, String nombreUsuarioEnemigos){
		juego = new Juego(nombreUsuarioGuerreros, nombreUsuarioEnemigos);
		this.stage = stage;
		this.setMenu();
		this.setTablero();
		this.setBotoneraDerecha();
	}
	
	private void setBotoneraDerecha() {
		this.botoneraDerecha = new BotoneraDerecha(this.juego, this.tablero.getCeldas());
		this.setRight(this.botoneraDerecha);
	}

	private void setMenu(){
		this.barraDeMenu = new BarraDeMenu(this.stage);
        this.setTop(barraDeMenu);
	}
	
	private void setTablero(){
		this.tablero = new VistaTablero(juego);
		this.setCenter(tablero);
	}
	
	public BarraDeMenu getBarraDeMenu(){
		return this.barraDeMenu;
	}
}