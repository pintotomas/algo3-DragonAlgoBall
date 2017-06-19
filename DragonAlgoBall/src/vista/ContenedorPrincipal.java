package vista;

import dab.juego.Juego;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane{
	Stage stage;
	BarraDeMenu barraDeMenu;
	BotoneraDerecha botoneraDerecha;
	Juego juego;
	VistaTablero tablero;
	VistaCaracteristicasPersonaje caracteristicasPersonaje;
	
	public ContenedorPrincipal(Stage stage, String nombreUsuarioGuerreros, String nombreUsuarioEnemigos){
		juego = new Juego(nombreUsuarioGuerreros, nombreUsuarioEnemigos);
		this.stage = stage;
		this.setMenu();
		this.setTablero();
		this.setBotoneraDerecha();
		this.setCaracteristicasPersonajeSeleccionado();
	}
	
	private void setBotoneraDerecha() {
		this.botoneraDerecha = new BotoneraDerecha(this.juego, this.tablero.getCeldas());
		this.setRight(this.botoneraDerecha);
	}
	
	private void setCaracteristicasPersonajeSeleccionado(){
		this.caracteristicasPersonaje = new VistaCaracteristicasPersonaje(null);
        this.setBottom(this.caracteristicasPersonaje);
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