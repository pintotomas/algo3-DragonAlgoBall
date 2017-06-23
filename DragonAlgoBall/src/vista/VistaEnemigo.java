package vista;

import dab.juego.Juego;
import dab.personajes.Personaje;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import vista.eventos.BotonAtaqueEspecialHandler;
import vista.eventos.BotonAtaqueNormalHandler;

public class VistaEnemigo extends VBox{
	private Personaje personaje;
	VistaTablero vistaTablero;
	Juego juego;
	public VistaEnemigo(Personaje personaje, Juego juego, VistaTablero vistaTablero){
		this.personaje = personaje;
		this.juego = juego;
		this.vistaTablero = vistaTablero;
		this.setVista();
	}
	
	private void setVista(){
		this.setSpacing(5);
        this.setPadding(new Insets(50));
        this.setStyle("-fx-background-color: #dc3c26; -fx-background-radius: 5px; "
        		+ "-fx-border-color: #9a1603; -fx-border-width: 4px; -fx-border-radius: 5px; -fx-padding: 10;");
        this.dibujar(this.personaje);
	}
	
	
	
	public void dibujar(Personaje personaje){
		if(personaje != null){
			String fuente = "Arial";
			int tamanioFuente = 26;
			String nombre = personaje.getNombre();
			double vida = personaje.getVida();
	//		int ki = personaje.getKi();
			double poderDeAtaque = personaje.getPoder();
			Label etiquetaNombre = new Label(nombre);
			etiquetaNombre.setFont(new Font(fuente,tamanioFuente));
			Label etiquetaVida = new Label("Vida: " + String.valueOf(vida));
			Label etiquetaPoderDeAtaque = new Label("Poder de ataque: " + String.valueOf(poderDeAtaque));
			//Label etiquetaKi = new Label("Ki: " + String.valueOf(ki));
			Button ataqueNormal = new Button("ATAQUE NORMAL");
			ataqueNormal.setOnMousePressed(new BotonAtaqueNormalHandler(personaje, juego, vistaTablero));
			Button ataqueEspecial = new Button("ATAQUE ESPECIAL");
				if(!juego.personajeSeleccionadoTieneAtaqueEspecialDisponible())
					ataqueEspecial.setStyle("-fx-background-color: red");
			ataqueEspecial.setOnMousePressed(new BotonAtaqueEspecialHandler(personaje, juego, vistaTablero));
			this.getChildren().addAll(etiquetaNombre,etiquetaVida,etiquetaPoderDeAtaque,ataqueNormal, ataqueEspecial);
		}else{
			this.getChildren().clear();
		}
	}
	
	public void update(Personaje personaje){
		this.getChildren().clear();
		this.dibujar(personaje);
	}
	
	public Personaje getPersonaje(){
		return this.personaje;
	}
	
	
}