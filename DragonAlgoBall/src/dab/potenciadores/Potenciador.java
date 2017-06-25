package dab.potenciadores;

import dab.interfaces.IContenedorDeFicha;
import dab.interfaces.IFicha;
import dab.juego.Celda;

public abstract class Potenciador implements IFicha{
	
	protected String nombre;
	protected double duracionTurnos;
	protected double duracionAtaques;
	protected int multiplicadorVelocidad;
	protected double multiplicadorPoderDePelea;
	protected double vidaExtra;
	protected int multiplicadorDistanciaAtaque;
	protected int multiplicadorAlcance;
	protected int kiExtra;
	
	private int multiplicadorDefecto = 1;
	private int vidaExtraDefecto = 0;
	private int kiExtraDefecto = 0;
	
	public Potenciador(String nombre, double duracionTurnos, double duracionAtaques, int multiplicadorVelocidad, 
			double multiplicadorPoderDePelea, double vidaExtra, int multiplicadorDistanciaAtaque, int multiplicadorAlcance, int kiExtra){
		
		this.nombre = nombre;
		this.duracionTurnos = duracionTurnos;
		this.duracionAtaques = duracionAtaques;
		this.multiplicadorVelocidad = multiplicadorVelocidad;
		this.multiplicadorPoderDePelea = multiplicadorPoderDePelea;
		this.vidaExtra = vidaExtra;
		this.multiplicadorDistanciaAtaque = multiplicadorDistanciaAtaque;
		this.multiplicadorAlcance = multiplicadorAlcance;
		this.kiExtra = kiExtra;
		
	}
	
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
	
	public abstract boolean daEfectos();
	
	public double getMultiplicadorPoderDePelea(){
		if (this.daEfectos()){return multiplicadorPoderDePelea;}
		return multiplicadorDefecto;
	}
	
	public double getMultiplicadorVelocidad(){
		if (this.daEfectos()){return multiplicadorVelocidad;}
		return multiplicadorDefecto;
	}
	
	public double getVidaExtra(){
		if (this.daEfectos()){return vidaExtra;}
		return vidaExtraDefecto;
	}
	public int getMultiplicadorAlcance(){
		if (this.daEfectos()){return multiplicadorAlcance;}
		return multiplicadorDefecto;
	}
	public int getMultiplicadorDistanciaAtaque(){
		if (this.daEfectos()){return multiplicadorDistanciaAtaque;}
		return multiplicadorDefecto;
	}
	public int getKiExtra(){
		if (this.daEfectos()){return kiExtra;}
		return kiExtraDefecto;
	}
	
	
	public void pasoUnTurno() {
		duracionTurnos -= 1;
	}
	
	public void pasoUnAtaque(){
		duracionAtaques -= 1;
	}
	
	@Override
	public boolean permiteSuperposicion(){
		return true;
	}
	
	@Override
	public void interactuarAlContacto(IFicha ficha){
		
	}
	
	public void setPosicion(IContenedorDeFicha celda){
		
	}
	
	public boolean estaActivo(){
		return (duracionTurnos > 0 && duracionAtaques > 0);
	}
	
	public double getDuracionTurnos(){
		//usar solo en testing
		return duracionTurnos;
	}
	
	
}
