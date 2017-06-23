package vista;

import java.net.URL;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import vista.eventos.BotonJugarEventHandler;

public class ContenedorInicial extends Pane {
    Stage stage;
    private int pixelesAnchoHD;
    private int pixelesAltoHD;
    public ContenedorInicial(Stage stage, Scene proximaEscena, int pixelesAnchoHD, int pixelesAltoHD) {

    		 
        this.stage = stage;
        this.pixelesAltoHD = pixelesAltoHD;
        this.pixelesAnchoHD = pixelesAnchoHD;
       	this.startOpening();
		
	
       	Image imagen = new Image("vista/Imagenes/inicioDragonAlgoBall.png", this.getWidth(), this.getHeight(), true, false);
        ImageView img = new ImageView(imagen);
        img.fitWidthProperty().bind(stage.widthProperty());
        img.fitHeightProperty().bind(stage.heightProperty());

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.setTranslateX(700);
        botonJugar.setTranslateY(550);

        BotonJugarEventHandler botonJugarHandler = new BotonJugarEventHandler(stage, proximaEscena);
        botonJugar.setOnAction(botonJugarHandler);
		
        this.getChildren().addAll(img,botonJugar);
    }
	private void startOpening(){
		// TODO Auto-generated method stub
		  URL resource = ContenedorInicial.class.getResource("/vista/sonidos/opening/DBZOpening.mp3");
//		  String path_opening = url.getPath();
//	      Media media = new Media(new File(path_opening).toURI().toString());
		  Media media = new Media(resource.toString());
	      MediaPlayer mediaPlayer = new MediaPlayer(media);
	      mediaPlayer.play();
	}
}