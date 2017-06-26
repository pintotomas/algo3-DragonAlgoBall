package vista;

import dab.equipo.Equipo;
import dab.juego.Juego;
import dab.personajes.Freezer.Freezer;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Goku.Goku;
import dab.personajes.Piccolo.Piccolo;
import dab.personajes.cell.Cell;
import dab.personajes.majinBoo.MajinBoo;
import dab.usuario.Usuario;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import utils.Ajustes;
import utils.reproductorDeSonidos.ReproductorDeSonidos;

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
	private Ajustes ajustesMusicaDeBatalla;
	private Ajustes ajustesEfectosDePersonajes;
	private ReproductorDeSonidos reproductorMusicaDeBatalla;
	
	public ContenedorPrincipal(Stage stage, TextField campoNombreUsuarioGuerreros,
			TextField campoNombreUsuarioEnemigos, Ajustes ajustesMusicaDeBatalla, Ajustes ajustesEfectosDePersonajes, 
			ReproductorDeSonidos reproductorMusicaDeBatalla){
		this.prepararJuego(campoNombreUsuarioGuerreros, campoNombreUsuarioEnemigos);
		this.ajustesEfectosDePersonajes = ajustesEfectosDePersonajes;
		this.ajustesMusicaDeBatalla = ajustesMusicaDeBatalla;
	
		this.reproductorMusicaDeBatalla = reproductorMusicaDeBatalla;
		this.stage = stage;
		this.setMenu();
		this.setCaracteristicasPersonajeSeleccionado();
		this.setTablero();
		this.setBotoneraDerecha();
	}

	private void prepararJuego(TextField campoNombreUsuarioGuerreros, TextField campoNombreUsuarioEnemigos) {
		String nombreUsuarioGuerreros = campoNombreUsuarioGuerreros.getText();
		String nombreUsuarioEnemigos = campoNombreUsuarioEnemigos.getText();
		juego = new Juego(altoTablero, anchoTablero, 
				new Usuario(new Equipo("Guerreros Z", new Goku(), new Gohan(), new Piccolo()), nombreUsuarioGuerreros),
				new Usuario(new Equipo("Enemigos de la Tierra", new Cell(), new Freezer(), new MajinBoo()), nombreUsuarioEnemigos));
	}

	private void setBotoneraDerecha() {
		this.botoneraDerecha = new BotoneraDerecha(this.juego, vistaTablero, reproductorMusicaDeBatalla,
				ajustesMusicaDeBatalla, ajustesEfectosDePersonajes, stage);
		this.setRight(this.botoneraDerecha);
	}
	
	private void setCaracteristicasPersonajeSeleccionado(){
		this.vistaInferiorPersonajes = new VistaInferiorPersonajes(juego, ajustesEfectosDePersonajes);
        this.setBottom(this.vistaInferiorPersonajes);
	}

	private void setMenu(){
		this.barraDeMenu = new BarraDeMenu(this.stage);
        this.setTop(barraDeMenu);
	}
	
	private void setTablero(){
		this.vistaTablero = new VistaTablero(this.juego,this.vistaInferiorPersonajes, this.stage,
				ajustesMusicaDeBatalla, ajustesEfectosDePersonajes, reproductorMusicaDeBatalla);
		this.setCenter(this.vistaTablero);
	}
	
	public BarraDeMenu getBarraDeMenu(){
		return this.barraDeMenu;
	}
}