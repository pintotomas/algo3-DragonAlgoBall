package vista;

import dab.juego.Juego;
import dab.usuario.Usuario;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane{
	Stage stage;
	BarraDeMenu barraDeMenu;

	BotoneraDerecha botoneraDerecha;
	

	VistaCaracteristicasPersonaje caracteristicasPersonaje;

	private Juego juego;
	private VistaTablero vistaTablero;
	private int altoTablero = 7;
	private int anchoTablero = 18;
	private VistaInferiorPersonajes vistaInferiorPersonajes;

	
	public ContenedorPrincipal(Stage stage, Usuario usuariogz, Usuario usuarioEnemigos){
		
		juego = new Juego(altoTablero, anchoTablero, usuariogz, usuarioEnemigos);
		this.stage = stage;
		this.setMenu();
		this.setCaracteristicasPersonajeSeleccionado();
		this.setTablero();
		this.setBotoneraDerecha();
	}
	
	private void setBotoneraDerecha() {
		this.botoneraDerecha = new BotoneraDerecha(this.juego, vistaTablero);
		this.setRight(this.botoneraDerecha);
	}
	
	private void setCaracteristicasPersonajeSeleccionado(){
		this.vistaInferiorPersonajes = new VistaInferiorPersonajes(juego);
        this.setBottom(this.vistaInferiorPersonajes);
	}

	private void setMenu(){
		this.barraDeMenu = new BarraDeMenu(this.stage);
        this.setTop(barraDeMenu);
	}
	
	private void setTablero(){
		this.vistaTablero = new VistaTablero(this.juego,this.vistaInferiorPersonajes);
		this.setCenter(this.vistaTablero);
	}
	
	public BarraDeMenu getBarraDeMenu(){
		return this.barraDeMenu;
	}
}