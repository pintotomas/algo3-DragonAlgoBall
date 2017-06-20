package vista;

import dab.personajes.Personaje;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class VistaCaracteristicasPersonaje extends VBox{
	private Personaje personaje;
	
	public VistaCaracteristicasPersonaje(Personaje personaje){
		this.personaje = personaje;
		this.setVista();
	}
	
	private void setVista(){
		this.setSpacing(5);
        this.setPadding(new Insets(50));
        this.setStyle("-fx-background-color: red;");
        this.dibujar(this.personaje);
	}
	
	public void dibujar(Personaje personaje){
		if(personaje != null){
			String fuente = "Arial";
			int tamanioFuente = 26;
			String nombre = personaje.getNombre();
			double vida = personaje.getVida();
			int ki = personaje.getKi();
			double poderDeAtaque = personaje.getPoder();
			Label etiquetaNombre = new Label(nombre);
			etiquetaNombre.setFont(new Font(fuente,tamanioFuente));
			Label etiquetaVida = new Label("Vida: " + String.valueOf(vida));
			Label etiquetaPoderDeAtaque = new Label("Poder de ataque: " + String.valueOf(poderDeAtaque));
			Label etiquetaKi = new Label("Ki: " + String.valueOf(ki));
			this.getChildren().addAll(etiquetaNombre,etiquetaVida,etiquetaPoderDeAtaque,etiquetaKi);
		}else{
			this.getChildren().clear();
		}
	}
	
	public void update(Personaje personaje){
		this.getChildren().clear();
		this.dibujar(personaje);
	}
}