package vista;

import dab.juego.Celda;
import dab.juego.Juego;
import dab.juego.Tablero;
import dab.juego.Turno;
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
    
	public VistaTablero(Juego juego,VistaCaracteristicasPersonaje vistaCaracteristicasPersonaje) {
		
		this.juego = juego;
		this.vistaCaracteristicasPersonaje = vistaCaracteristicasPersonaje;
	 	this.setGridLinesVisible(true);
	 	tablero = juego.getTablero();
	    altoTablero = tablero.getAltura();
		anchoTablero = tablero.getAncho();
		celdasGUI = new VistaCelda[altoTablero][anchoTablero];
	
	    tablero = juego.getTablero();
	   
	    
	    dibujarTableroSinNingunaSeleccion();
	      
	    celdasLogicas = tablero.getCeldas();
	}
	
	public void dibujarTableroSinNingunaSeleccion(){
		celdasLogicas = tablero.getCeldas();
		for (int row = 0; row < altoTablero; row++) {
	        for (int col = 0; col < anchoTablero; col++) {
	        	//Al inicializar estan todas inactivas.
	        	VistaCelda celda = new VistaCeldaInactiva(celdasLogicas[row][col]);
	        	celdasGUI[row][col] = celda;
 	        	SeleccionarCeldaInactivaHandler seleccionCeldaInactivaHandler = new SeleccionarCeldaInactivaHandler(celda, juego, celdasGUI, this, vistaCaracteristicasPersonaje);
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
	
	
	
}
