package vista;

import dab.juego.Celda;
import dab.juego.Juego;
import dab.juego.Tablero;
import dab.personajes.Personaje;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utils.Ajustes;
import utils.reproductorDeSonidos.ReproductorDeSonidos;
import vista.eventos.celdas.SeleccionarCeldaInactivaHandler;
import vista.vistasCelda.VistaCelda;
import vista.vistasCelda.VistaCeldaInactiva;

public class VistaTablero extends GridPane{
	
	private int altoTablero; 
    private int anchoTablero;
    private Juego juego;
    private Stage stage;
    private Ajustes ajustesMusicaDeBatalla;
    private Ajustes ajustesEfectosDePersonajes;
    private Tablero tablero;
    private Celda[][] celdasLogicas;
    private VistaCelda[][] celdasGUI;
	private VistaInferiorPersonajes vistaInferiorPersonaje;
	private ReproductorDeSonidos reproductorDeMusicaDeBatalla;
	private Ajustes ajustesMusicaEnding;
	private VistaInformacionDelJugadorActual vistaInfoDelJugadorActual;
    
	public VistaTablero(Juego juego,
			VistaInferiorPersonajes vistaInferiorPersonaje, Stage stage, ReproductorDeSonidos reproductorDeMusicaDeBatalla, Ajustes ajustesMusicaDeBatalla, 
			Ajustes ajustesEfectosDePersonajes, Ajustes ajustesMusicaEnding, VistaInformacionDelJugadorActual vistaInfoDelJugadorActual) {
		this.reproductorDeMusicaDeBatalla = reproductorDeMusicaDeBatalla;
		this.ajustesMusicaDeBatalla = ajustesMusicaDeBatalla;
	    this.ajustesEfectosDePersonajes = ajustesEfectosDePersonajes;
	    this.ajustesMusicaEnding = ajustesMusicaEnding;
		this.stage = stage;
		this.juego = juego;
		this.vistaInferiorPersonaje = vistaInferiorPersonaje;
	 	this.setGridLinesVisible(true);
	 	tablero = juego.getTablero();
	    altoTablero = tablero.getAltura();
		anchoTablero = tablero.getAncho();
		celdasGUI = new VistaCelda[altoTablero][anchoTablero];
		vistaInferiorPersonaje.setTablero(this);    //permite que la vista inferior tenga acceso a las celdas para poder seleccionarlas.
		this.vistaInfoDelJugadorActual = vistaInfoDelJugadorActual;
		
	    tablero = juego.getTablero();
	    this.setAlignment(Pos.CENTER);
	    
	    dibujarTableroSinNingunaSeleccion();
	    this.vistaInferiorPersonaje.setPersonajeDeTurno();
	    celdasLogicas = tablero.getCeldas();
	}
	
	public void dibujarTableroSinNingunaSeleccion(){
		celdasLogicas = tablero.getCeldas();
		for (int row = 0; row < altoTablero; row++) {
	        for (int col = 0; col < anchoTablero; col++) {
	        	//Al inicializar estan todas inactivas.
	        	VistaCelda celda = new VistaCeldaInactiva(celdasLogicas[row][col]);
	        
	        	celdasGUI[row][col] = celda;
 	        	SeleccionarCeldaInactivaHandler seleccionCeldaInactivaHandler = new SeleccionarCeldaInactivaHandler(celda, juego, celdasGUI, this, vistaInferiorPersonaje);
	        	refrescar(row, col, seleccionCeldaInactivaHandler);
	        }
		}
	}
	
	public VistaCelda[][] getCeldas(){
		return this.celdasGUI;
	}

	public void refrescar(int fila, int columna, EventHandler<MouseEvent> onMousePressedEvent) {
		
		
		VistaCelda celdaARefrescar = celdasGUI[fila][columna];
		celdaARefrescar.setOnMousePressed(onMousePressedEvent);
        VistaTablero.setRowIndex(celdaARefrescar, fila);
        VistaTablero.setColumnIndex(celdaARefrescar, columna);
        this.getChildren().add(celdaARefrescar);
		
	}
	

	public void actualizarInformacionDelTurnoActual() {
		
		this.vistaInferiorPersonaje.setPersonajeDeTurno();
		this.vistaInfoDelJugadorActual.refrescarInformacion();
		
	}

	public void actualizarVistaEnemigo(Personaje personajeEnemigo) {
		this.vistaInferiorPersonaje.updateEnemigo(personajeEnemigo);
		
	}

	public void hayUnGanador() {
		if (ajustesMusicaDeBatalla.estaActivo()){
			reproductorDeMusicaDeBatalla.stop();
		}
		VistaEscenaFinal escenaFinal = new VistaEscenaFinal(stage, juego.ganador(), ajustesMusicaDeBatalla, ajustesEfectosDePersonajes, ajustesMusicaEnding);
		stage.setScene(new Scene(escenaFinal));
		stage.setFullScreenExitHint("");
	    stage.setFullScreen(true);
	    }
	}
