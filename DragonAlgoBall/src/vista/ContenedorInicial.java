package vista;

import java.net.URL;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import vista.eventos.CambiarEscenaAlPresionarEventHandler;

public class ContenedorInicial extends StackPane {
    Stage stage;
//    private int pixelesAnchoHD;
//    private int pixelesAltoHD;
    private MediaPlayer mediaPlayer;
    
//    public ContenedorInicial(Stage stage, Scene proximaEscena, int pixelesAnchoHD, int pixelesAltoHD) {
    public ContenedorInicial(Stage stage, Scene proximaEscena) {
        this.stage = stage;
//        this.pixelesAltoHD = pixelesAltoHD;
//        this.pixelesAnchoHD = pixelesAnchoHD;
       	this.startOpening();
		
	
     	Image fondoPrincipal = new Image("vista/Imagenes/inicioDragonAlgoBall.png");

        ImageView vistaFondoPrincipal = new ImageView(fondoPrincipal);
        vistaFondoPrincipal.fitWidthProperty().bind(stage.widthProperty());
        vistaFondoPrincipal.fitHeightProperty().bind(stage.heightProperty());
      
        HBox botonJugar = new HBox();
        botonJugar.setPrefSize(50, 23);
        Image estiloBoton = new Image("vista/Imagenes/start.png");
        ImageView vistaBotonJugar = new ImageView(estiloBoton);
        botonJugar.setAlignment(Pos.BOTTOM_CENTER);
        botonJugar.getChildren().add(vistaBotonJugar);

        CambiarEscenaAlPresionarEventHandler botonJugarHandler = new CambiarEscenaAlPresionarEventHandler(stage, proximaEscena);
        botonJugar.setOnMouseClicked(botonJugarHandler);
        

        
        this.getChildren().addAll(vistaFondoPrincipal,botonJugar);
        
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