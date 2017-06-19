package vista;

import dab.personajes.Personaje;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VistaCaracteristicasPersonaje extends VBox{
	private Personaje personaje;
	
	public VistaCaracteristicasPersonaje(Personaje personaje){
		this.personaje = personaje;
		this.setVista();
	}
	
	private void setVista(){
		this.setSpacing(10);
        this.setPadding(new Insets(60));
        this.setStyle("-fx-background-color: black;");
        this.dibujar(this.personaje);
	}
	
	public void dibujar(Personaje personaje){
		if(personaje != null){
			String nombre = personaje.getNombre();
			double vida = personaje.getVida();
			int ki = personaje.getKi();
			double poderDeAtaque = personaje.getPoder();
			Label etiquetaNombre = new Label("nombre: " + nombre);
			Label etiquetaVida = new Label("Vida: " + String.valueOf(vida));
			Label etiquetaPoderDeAtaque = new Label("Poder de ataque: " + String.valueOf(poderDeAtaque));
			Label etiquetaKi = new Label("Ki: " + String.valueOf(ki));
			this.getChildren().addAll(etiquetaNombre,etiquetaVida,etiquetaPoderDeAtaque,etiquetaKi);
		}else{
			this.getChildren().clear();
		}
	}
	
	public void update(Personaje personaje){
		this.dibujar(personaje);
	}
}