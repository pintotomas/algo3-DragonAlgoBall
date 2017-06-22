package vista;

import dab.juego.Celda;
import dab.juego.Juego;
import dab.juego.Tablero;
import dab.juego.Turno;
import dab.personajes.Personaje;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import vista.eventos.celdas.SeleccionarCeldaInactivaHandler;
import vista.vistasCelda.VistaCelda;
import vista.vistasCelda.VistaCeldaInactiva;

public class VistaTablero extends GridPane{
	
	int altoTablero; 
    int anchoTablero;
    Juego juego;
    
    Tablero tablero;
    Celda[][] celdasLogicas;
    VistaCelda[][] celdasGUI;
    VistaCaracteristicasPersonaje vistaCaracteristicasPersonaje;
	VistaInferiorPersonajes vistaInferiorPersonaje;
    
	public VistaTablero(Juego juego,VistaInferiorPersonajes vistaInferiorPersonaje) {
		
		this.juego = juego;
		this.vistaInferiorPersonaje = vistaInferiorPersonaje;
	 	this.setGridLinesVisible(true);
	 	tablero = juego.getTablero();
	    altoTablero = tablero.getAltura();
		anchoTablero = tablero.getAncho();
		celdasGUI = new VistaCelda[altoTablero][anchoTablero];
		vistaInferiorPersonaje.setTablero(this);    //permite que la vista inferior tenga acceso a las celdas para poder seleccionarlas.
	
	    tablero = juego.getTablero();
	   
	    
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

	public void setTurno(Turno turno){
	
	}
	
	public VistaCelda[][] getCeldas(){
		return this.celdasGUI;
	}

	public void refrescar(int fila, int columna, EventHandler<MouseEvent> onMousePressedEvent) {
		
		
		VistaCelda celdaARefrescar = celdasGUI[fila][columna];
//		StackPane dibujoCelda = celdaARefrescar.dibujar();
		celdaARefrescar.setOnMousePressed(onMousePressedEvent);
        VistaTablero.setRowIndex(celdaARefrescar, fila);
        VistaTablero.setColumnIndex(celdaARefrescar, columna);
        this.getChildren().add(celdaARefrescar);
		
	}
	
	public VistaCaracteristicasPersonaje getVistaCaracteristicasPersonaje(){
		return vistaCaracteristicasPersonaje;
		
	}

	public void actualizarVistaDePersonajes() {
		this.vistaInferiorPersonaje.setPersonajeDeTurno();
		
	}

	public VistaInferiorPersonajes getVistaInferiorPersonajes() {
		
		return this.vistaInferiorPersonaje;
	}

	public void actualizarVistaEnemigo(Personaje personajeEnemigo) {
		this.vistaInferiorPersonaje.updateEnemigo(personajeEnemigo);
		
	}
	
	
	
}
