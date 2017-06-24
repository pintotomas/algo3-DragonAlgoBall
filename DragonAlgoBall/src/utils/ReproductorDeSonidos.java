package utils;

import java.net.URL;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.net.URL;
import vista.ContenedorInicial;

public class ReproductorDeSonidos {

	
    private MediaPlayer mediaPlayer = new MediaPlayer(null);
	
    public ReproductorDeSonidos(String listaDeReproduccion[]){
    	startOpening();
    }
    
    public ReproductorDeSonidos(){
    	
    }

	private void startOpening(){
		// TODO Auto-generated method stub
		  URL resource = ContenedorInicial.class.getResource("/vista/sonidos/opening/DBZOpening.mp3");
//		  String path_opening = url.getPath();
//	      Media media = new Media(new File(path_opening).toURI().toString());
		  Media media = new Media(resource.toString());
	      this.mediaPlayer = new MediaPlayer(media);
	      this.mediaPlayer.play();
	}
}
