package vista;

import dab.equipo.Equipo;
import dab.juego.Celda;
import dab.juego.Tablero;
import dab.personajes.Freezer.Freezer;
import dab.personajes.Gohan.Gohan;
import dab.personajes.Goku.Goku;
import dab.personajes.Piccolo.Piccolo;
import dab.personajes.cell.Cell;
import dab.personajes.majinBoo.MajinBoo;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class VistaTablero extends Application{
	
	public static void main(String[] args){
	        launch(args);
	    }
	
	public void start(Stage primaryStage) {
		
		Equipo guerrerosZ, enemigosDeLaTierra;
		guerrerosZ = new Equipo("Guerreros Z");
		enemigosDeLaTierra = new Equipo("Enemigos de la tierra");
		
		guerrerosZ.agregarPersonaje(new Goku());
		guerrerosZ.agregarPersonaje(new Gohan());
		guerrerosZ.agregarPersonaje(new Piccolo());
		
		
		enemigosDeLaTierra.agregarPersonaje(new Cell());
		enemigosDeLaTierra.agregarPersonaje(new Freezer());
		enemigosDeLaTierra.agregarPersonaje(new MajinBoo());
		
	    GridPane grid = new GridPane();
	 	grid.setGridLinesVisible(true);
	    int altoTablero = 10; 
	    int anchoTablero = 10;
	    Celda[][] celdasLogicas = new Tablero(guerrerosZ, enemigosDeLaTierra, altoTablero, anchoTablero).getCeldas();
	    VistaCelda[][] celdasGUI = new VistaCelda[altoTablero][anchoTablero];
	    
	    for (int row = 0; row < anchoTablero; row++) {
	        for (int col = 0; col < altoTablero; col++) {
	        	
	        	VistaCelda celda = new VistaCelda(celdasLogicas[row][col]);
	        	celdasGUI[row][col] = celda;
	        	
	            StackPane dibujoCelda = celda.dibujar();
	            GridPane.setRowIndex(dibujoCelda, row);
	            GridPane.setColumnIndex(dibujoCelda, col);

	            grid.getChildren().addAll(dibujoCelda);
	            
	        }
	    }

	    Scene scene = new Scene(grid, 350, 250);

	    primaryStage.setTitle("Grid");
	    primaryStage.setScene(scene);
	    primaryStage.show();
	}
}
