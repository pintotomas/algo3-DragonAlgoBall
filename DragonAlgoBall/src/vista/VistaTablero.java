package vista;

import dab.equipo.Equipo;
import dab.juego.Celda;
import dab.juego.Tablero;
import dab.juego.Turno;
import dab.personajes.Freezer.Freezer;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Goku.Goku;
import dab.personajes.Piccolo.Piccolo;
import dab.personajes.cell.Cell;
import dab.personajes.majinBoo.MajinBoo;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import vista.eventos.SeleccionarCeldaHandler;

public class VistaTablero extends GridPane{
	
	Stage stage;
	int altoTablero = 10; 
    int anchoTablero = 10;
	public VistaTablero(Stage stage) {
		this.stage = stage;
		Equipo guerrerosZ, enemigosDeLaTierra;
		Tablero tablero;
		Turno turno;
		guerrerosZ = new Equipo("Guerreros Z");
		enemigosDeLaTierra = new Equipo("Enemigos de la tierra");
		
		guerrerosZ.agregarPersonaje(new Goku());
		guerrerosZ.agregarPersonaje(new Gohan());
		guerrerosZ.agregarPersonaje(new Piccolo());
		
		
		enemigosDeLaTierra.agregarPersonaje(new Cell());
		enemigosDeLaTierra.agregarPersonaje(new Freezer());
		enemigosDeLaTierra.agregarPersonaje(new MajinBoo());
		
		tablero = new Tablero(altoTablero, anchoTablero, guerrerosZ, enemigosDeLaTierra);
		turno = new Turno(guerrerosZ, tablero);
	
	 	this.setGridLinesVisible(true);
	 	
	    
	    Tablero tableroJuego = new Tablero(altoTablero, anchoTablero, guerrerosZ, enemigosDeLaTierra);
	    Celda[][] celdasLogicas = tableroJuego.getCeldas();
	    VistaCelda[][] celdasGUI = new VistaCelda[altoTablero][anchoTablero];
	    
	    for (int row = 0; row < anchoTablero; row++) {
	        for (int col = 0; col < altoTablero; col++) {
	        	
	        	VistaCelda celda = new VistaCelda(celdasLogicas[row][col]);
	        	celdasGUI[row][col] = celda;
	        	
	            StackPane dibujoCelda = celda.dibujar();
	            
	            SeleccionarCeldaHandler seleccionCeldaHandler = new SeleccionarCeldaHandler(celda, tableroJuego, celdasGUI, turno);
	            dibujoCelda.setOnMousePressed(seleccionCeldaHandler);
	            
	            VistaTablero.setRowIndex(dibujoCelda, row);
	            VistaTablero.setColumnIndex(dibujoCelda, col);

	            this.getChildren().addAll(dibujoCelda);
	            
	        }
	    }
	    
	    stage.setTitle("DragonAlgoBall");

//	    Scene scene = new Scene(this, 350, 250);
//
//	    stage.setTitle("DragonAlgoBall");
//	    stage.setScene(scene);
//	    stage.show();
	}
}
