package utils;

public class Ajustes {
	
	private String nombre;
	private boolean activado;

	public Ajustes(String nombre, boolean activado){
		this.nombre = nombre;
		this.activado = activado;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public boolean estaActivo(){
		return activado;
	}
	
	public void cambiar(){
		activado = !activado;
	}

}