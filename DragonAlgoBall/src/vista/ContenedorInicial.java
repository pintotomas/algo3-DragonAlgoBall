package vista;

import java.net.URL;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import vista.eventos.BotonJugarEventHandler;

public class ContenedorInicial extends StackPane {
    Stage stage;
    private int pixelesAnchoHD;
    private int pixelesAltoHD;
    public ContenedorInicial(Stage stage, Scene proximaEscena, int pixelesAnchoHD, int pixelesAltoHD) {

        this.stage = stage;
        this.pixelesAltoHD = pixelesAltoHD;
        this.pixelesAnchoHD = pixelesAnchoHD;
       	this.startOpening();
		
		
      
//        String imagen = "vista/Imagenes/inicioDragonAlgoBall.png";
        ImageView imagen = new ImageView(new Image("vista/Imagenes/inicioDragonAlgoBall.png", stage.getWidth(), stage.getHeight(), true, false));
//        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
//        		 new BackgroundSize(stage.getWidth(), stage.getHeight(), true, true, true, true));
//        
        
//        this.setStyle("-fx-background-image: url('" + imagen + "'); " +
//           "-fx-background-position: center center; " +
//           "-fx-background-repeat: stretch;");
//        
        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        
        BotonJugarEventHandler botonJugarHandler = new BotonJugarEventHandler(stage, proximaEscena);
        botonJugar.setOnAction(botonJugarHandler);
		
        this.getChildren().addAll(imagen, botonJugar);
    }
	private void startOpening(){
	/*	// TODO Auto-generated method stub
		  URL resource = ContenedorInicial.class.getResource("/vista/sonidos/opening/DBZOpening.mp3");
//		  String path_opening = url.getPath();
//	      Media media = new Media(new File(path_opening).toURI().toString());
		  Media media = new Media(resource.toString());
	      MediaPlayer mediaPlayer = new MediaPlayer(media);
	      mediaPlayer.play();*/
	}
}