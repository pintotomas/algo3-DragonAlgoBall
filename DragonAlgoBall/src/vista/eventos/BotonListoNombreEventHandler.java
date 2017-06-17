package vista.eventos;

import dab.juego.Juego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BotonListoNombreEventHandler implements EventHandler<ActionEvent>{
	private Button botonListoNombre;
	private Juego juego;
	private TextField campoTexto;
	private String equipoUsuario;
	
	public BotonListoNombreEventHandler(Button boton,Juego juegoDAB, TextField campoNombreUsuario,String equipoUsuario){
		this.botonListoNombre = boton;
		this.juego = juegoDAB;
		this.campoTexto = campoNombreUsuario;
		this.equipoUsuario = equipoUsuario;
	}
	
	@Override
	public void handle(ActionEvent event) {
		this.botonListoNombre.setDisable(true);
		this.agregarNombreUsuario();
		this.botonListoNombre.setText("Esperando al enemigo..");
	}
	
	private void agregarNombreUsuario(){
		if (equipoUsuario.contains("Guerreros Z")){
			this.juego.setNombreUsuarioGuerrerosZ(this.campoTexto.getText());
		}else{
			this.juego.setNombreUsuarioEnemigosDeLaTierra(this.campoTexto.getText());
		}
	}
}
