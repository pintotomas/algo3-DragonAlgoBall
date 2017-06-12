package dab.usuario;

import java.util.Scanner;

import dab.equipo.Equipo;

public class Usuario {
	private String nombreUsuario;
	private Equipo equipoUsuario;
	
	public Usuario(Equipo equipo){
		this.nombreUsuario = this.pedirNombreAlCliente();
		this.equipoUsuario = equipo;
	}
	
	private String pedirNombreAlCliente(){
		// con la interfaz grafica, abrimos ventana 
		Scanner input = new Scanner(System.in);
	    try{
	    	System.out.print("Ingrese su nombre: ");
	    	String nombreUsuario = input.next();
	    	return nombreUsuario;
	    }finally{
	    	input.close();
	    }
	}
	
	public String getNombreUsuario(){
		return this.nombreUsuario;
	}
	
	public Equipo getEquipo(){
		return this.equipoUsuario;
	}
	
	public String pedirJugadaAlCliente(){
		// con la interfaz grafica, lo cambiamos por movimientos y clicks del mouse
		Scanner input = new Scanner(System.in);
	    try{
	    	System.out.print("Ingrese su jugada: ");
	    	String jugada = input.next();
	    	return jugada;
	    }finally{
	    	input.close();
	    }
	}
		
}