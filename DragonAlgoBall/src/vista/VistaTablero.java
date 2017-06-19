package vista;

import dab.juego.Celda;
import dab.juego.Juego;
import dab.juego.Tablero;
import dab.juego.Turno;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import vista.eventos.BotonPasarTurnoEventHandler;
import vista.eventos.SeleccionarCeldaHandler;

public class VistaTablero extends GridPane{
	
	Stage stage;
	int altoTablero; 
    int anchoTablero;
    Juego juego;
    Turno turno;
    Tablero tablero;
    Celda[][] celdasLogicas;
    VistaCelda[][] celdasGUI;
	public VistaTablero(Stage stage, Juego juego) {
		this.stage = stage;
		this.juego = juego;
		
	
	 	this.setGridLinesVisible(true);
	 	
	 	turno = juego.getTurno();
	    tablero = juego.getTablero();
	    altoTablero = tablero.getAltura();
	    anchoTablero = tablero.getAncho();
	    
	    dibujarTablero();
	    agregarBotones();
	      
	    celdasLogicas = tablero.getCeldas();
		celdasGUI = new VistaCelda[altoTablero][anchoTablero];
	    
	    stage.setTitle("DragonAlgoBall");

//	    Scene scene = new Scene(this, 350, 250);
//
//	    stage.setTitle("DragonAlgoBall");
//	    stage.setScene(scene);
//	    stage.show();
	}
	public void dibujarTablero(){
		
		celdasLogicas = tablero.getCeldas();
		celdasGUI = new VistaCelda[altoTablero][anchoTablero];
		for (int row = 0; row < altoTablero; row++) {
	        for (int col = 0; col < anchoTablero; col++) {
	        	
	        	VistaCelda celda = new VistaCelda(celdasLogicas[row][col]);
	        	celdasGUI[row][col] = celda;
	        	
	            StackPane dibujoCelda = celda.dibujar();
	            
	            SeleccionarCeldaHandler seleccionCeldaHandler = new SeleccionarCeldaHandler(juego, celda,celdasGUI);
	            dibujoCelda.setOnMousePressed(seleccionCeldaHandler);
	            
	            VistaTablero.setRowIndex(dibujoCelda, row);
	            VistaTablero.setColumnIndex(dibujoCelda, col);

	            this.getChildren().addAll(dibujoCelda);
	        }
		}
	}

	private void agregarBotones(){
		 Button botonPasarTurno = new Button("CEDER TURNO");
	        BotonPasarTurnoEventHandler pasarTurnoEventHandler = new BotonPasarTurnoEventHandler(juego,celdasGUI);
	        botonPasarTurno.setOnAction(pasarTurnoEventHandler);
	        VistaTablero.setRowIndex(botonPasarTurno, anchoTablero + 1);
	        VistaTablero.setColumnIndex(botonPasarTurno, altoTablero + 1);
	        this.getChildren().addAll(botonPasarTurno);
	        
	}

	public void setTurno(Turno turno){
		
		
	}





}
