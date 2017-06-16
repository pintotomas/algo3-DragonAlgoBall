package vista;

import dab.juego.Celda;
import dab.juego.Tablero;
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
		
	    GridPane grid = new GridPane();
	 	grid.setGridLinesVisible(true);
	    int altoTablero = 15; //esto deberia obtenerlo del tablero
	    int anchoTablero = 15;
	    Celda[][] celdasLogicas = new Tablero(altoTablero, anchoTablero).getCeldas();
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
