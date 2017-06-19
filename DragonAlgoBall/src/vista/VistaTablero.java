package vista;

import dab.juego.Celda;
import dab.juego.Juego;
import dab.juego.Tablero;
import dab.juego.Turno;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import vista.eventos.SeleccionarCeldaHandler;

public class VistaTablero extends GridPane{
	
	int altoTablero; 
    int anchoTablero;
    Juego juego;
    Turno turno;
    Tablero tablero;
    Celda[][] celdasLogicas;
    VistaCelda[][] celdasGUI;
    VistaCaracteristicasPersonaje vistaCaracteristicasPersonaje;
    
	public VistaTablero(Juego juego,VistaCaracteristicasPersonaje vistaCaracteristicasPersonaje) {
		
		this.juego = juego;
		this.vistaCaracteristicasPersonaje = vistaCaracteristicasPersonaje;
	 	this.setGridLinesVisible(true);
	 	
	 	turno = juego.getTurno();
	    tablero = juego.getTablero();
	    altoTablero = tablero.getAltura();
	    anchoTablero = tablero.getAncho();
	    
	    dibujarTablero();
	      
	    celdasLogicas = tablero.getCeldas();
		celdasGUI = new VistaCelda[altoTablero][anchoTablero];
	}
	
	public void dibujarTablero(){
		celdasLogicas = tablero.getCeldas();
		celdasGUI = new VistaCelda[altoTablero][anchoTablero];
		for (int row = 0; row < anchoTablero; row++) {
	        for (int col = 0; col < altoTablero; col++) {
	        	
	        	VistaCelda celda = new VistaCelda(celdasLogicas[row][col]);
	        	celdasGUI[row][col] = celda;
	        	
	            StackPane dibujoCelda = celda.dibujar();
	            
	            SeleccionarCeldaHandler seleccionCeldaHandler = new SeleccionarCeldaHandler(juego, celda,celdasGUI,this.vistaCaracteristicasPersonaje);
	            dibujoCelda.setOnMousePressed(seleccionCeldaHandler);
	            
	            VistaTablero.setRowIndex(dibujoCelda, row);
	            VistaTablero.setColumnIndex(dibujoCelda, col);

	            this.getChildren().addAll(dibujoCelda);
	        }
		}
	}

	public void setTurno(Turno turno){
	
	}
	
	public VistaCelda[][] getCeldas(){
		return this.celdasGUI;
	}
}
