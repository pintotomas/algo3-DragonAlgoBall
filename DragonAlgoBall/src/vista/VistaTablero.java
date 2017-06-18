package vista;

import dab.juego.Celda;
import dab.juego.Juego;
import dab.juego.Tablero;
import dab.juego.Turno;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import vista.eventos.SeleccionarCeldaHandler;

public class VistaTablero extends GridPane{
	
	Stage stage;
	int altoTablero; 
    int anchoTablero;
    Juego juego;
    Turno turno;
    Tablero tablero;
    
	public VistaTablero(Stage stage, Juego juego) {
		this.stage = stage;
		this.juego = juego;
		
	
	 	this.setGridLinesVisible(true);
	 	
	 	turno = juego.getTurno();
	    tablero = juego.getTablero();
	    altoTablero = tablero.getAltura();
	    anchoTablero = tablero.getAncho();
	    
	    dibujarTablero();
	       
	      
	    
	    
	    stage.setTitle("DragonAlgoBall");

//	    Scene scene = new Scene(this, 350, 250);
//
//	    stage.setTitle("DragonAlgoBall");
//	    stage.setScene(scene);
//	    stage.show();
	}
	public void dibujarTablero(){
		
		Celda[][] celdasLogicas = tablero.getCeldas();
		VistaCelda[][] celdasGUI = new VistaCelda[altoTablero][anchoTablero];
		for (int row = 0; row < anchoTablero; row++) {
	        for (int col = 0; col < altoTablero; col++) {
	        	
	        	VistaCelda celda = new VistaCelda(celdasLogicas[row][col]);
	        	celdasGUI[row][col] = celda;
	        	
	            StackPane dibujoCelda = celda.dibujar();
	            
	            SeleccionarCeldaHandler seleccionCeldaHandler = new SeleccionarCeldaHandler(celda, tablero, celdasGUI, turno);
	            dibujoCelda.setOnMousePressed(seleccionCeldaHandler);
	            
	            VistaTablero.setRowIndex(dibujoCelda, row);
	            VistaTablero.setColumnIndex(dibujoCelda, col);

	            this.getChildren().addAll(dibujoCelda);
	        }
		}
	}



	public void setTurno(Turno turno){
		
		
	}





}
