package dab.personajes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import dab.ataquesEspeciales.AtaqueEspecial;
import dab.equipo.Equipo;
import dab.estados.Estado;
import dab.interfaces.IContenedorDeFicha;
import dab.interfaces.IFicha;
import dab.interfaces.IFichaMovible;
import dab.interfaces.IProveedorDeKi;
import dab.potenciadores.Potenciador;

public abstract class Personaje implements IFichaMovible,IProveedorDeKi{
	
	protected Equipo equipo; 
	protected IContenedorDeFicha coordenadas;
	protected List <Potenciador> potenciadoresActivos = new LinkedList<Potenciador>(); 
	protected int kiParaEspecial;  //puede estar aca porque no cambia con los estados.
	protected AtaqueEspecial ataqueEspecial;
	protected Estado estado;
	protected double vida;
	protected int ki = 0;
	protected int kiParaTransformar;

	/**********************************************************
							ATAQUE
	 **********************************************************/
	
	public boolean puedeAtacar(Personaje personaje) {
		//Ver si esto se puede chequear en otro lado como juego. falta chequear trayectoriaValida
		int maxFila = coordenadas.getFila() + this.getAlcance();
		int maxColumna = coordenadas.getColumna() + this.getAlcance();
		int minFila = coordenadas.getFila() - this.getAlcance();
		int minColumna = coordenadas.getColumna() - this.getAlcance();
		IContenedorDeFicha coordenadasEnemigo = personaje.getPosicion();
		if(coordenadasEnemigo.getColumna() > maxColumna  ||  coordenadasEnemigo.getFila() > maxFila || coordenadasEnemigo.getColumna() < minColumna  ||  coordenadasEnemigo.getFila() < minFila ){
			return false;
		}
		if(personaje.getEquipo() == this.getEquipo()){
			return false;
		}
		if(personaje.getVida() <= 0){
			return false;
		}
		return true;
	}
	
	public void atacarA(Personaje personajeEnemigo){
		personajeEnemigo.recibirAtaque(this.getPoder());
		this.notificarAtaqueAPotenciadores();
	}
	
	private void notificarAtaqueAPotenciadores(){
		Iterator<Potenciador> iteradorPotenciadoresActivos = potenciadoresActivos.iterator();
		while(iteradorPotenciadoresActivos.hasNext()){
			Potenciador potenciador = iteradorPotenciadoresActivos.next();
			potenciador.pasoUnAtaque();
			
			if (!potenciador.estaActivo()){
				potenciadoresActivos.remove(potenciador);
			}
		}
	}
	
	public boolean ataqueEspecialDisponible() {
		return this.getKi() >= kiParaEspecial;
	}
	
	public void ataqueEspecial(Personaje enemigo) {
		ataqueEspecial.lanzar(enemigo);
		this.modificarKi(-1*(kiParaEspecial));
	}
	
	private void recibirAtaque(double poderEnemigo) {
		if(poderEnemigo < this.getPoder()){
			poderEnemigo = (int)(poderEnemigo * 0.8);		
		}
		this.modificarVida(-poderEnemigo);	
	}

	/********************************************************
							MOVIMIENTO
	 ********************************************************/
		
	public boolean movimientoPosible(IContenedorDeFicha coordenadasDestino){
		//verifica que el movimiento se pueda hacer.
		int maxFila = coordenadas.getFila() + this.getVelocidad();
		int maxColumna = coordenadas.getColumna() + this.getVelocidad();
		//verifica que el movimiento se pueda hacer.
		if(coordenadasDestino.getColumna() > maxColumna  ||  coordenadasDestino.getFila() > maxFila){
			return false;
		}
		return true;
	}
		
	
	/**********************************************************
 						AGREGAR KI Y VIDA
	 **********************************************************/
	
	public void modificarKi(int aumento) {
		ki = ki + aumento;
	}

	public void modificarVida(double cantidad) {
		if(vida + cantidad > this.getVidaMaxima()){
			vida = this.getVidaMaxima();
		}else{
			vida += cantidad;
		}
		//Parche para que corran las pruebas: o cambiar las pruebas, o 
		//hacer funcionn
		if (estoyMuerto() && equipo != null){
			equipo.quitarPersonaje(this);
		}
	}
	
	private boolean estoyMuerto(){
		return vida <= 0;
	}
	
	/**********************************************************
	    			TRANSFORMAR, TURNO 
	***********************************************************/
	public void transformar(){
		this.estado = estado.transformar();
	}

	public boolean transformarDisponible(){
		return estado.transformarDisponible();
	}
	
	public void nuevoTurno(){
		Iterator<Potenciador> iteradorPotenciadoresActivos = potenciadoresActivos.iterator();
		while(iteradorPotenciadoresActivos.hasNext()){
			Potenciador potenciador = iteradorPotenciadoresActivos.next();
			potenciador.pasoUnTurno();
			this.modificarKi(potenciador.getKiExtra());
			if (!potenciador.estaActivo()){
				iteradorPotenciadoresActivos.remove();
			}
		}
	}	
	
	/**********************************************************
						GETERS Y SETERS
	 **********************************************************/
	
	public double getVidaMaxima(){
		return estado.getVidaMaxima();
	}
	
	public double getPorcentajeDeVida(){
		//Devuelve el porcentaje de vida respecto del total
		return (this.getVida() / this.getVidaMaxima()) * 100;
	}

	public double getPoder() {
		
		double multiplicador = 1;
		for (Potenciador potenciador: potenciadoresActivos){
			multiplicador *= potenciador.getMultiplicadorPoderDePelea();
		}
		double poderActual = estado.getPoder(); 
		return poderActual *= multiplicador;
	}

	public int getAlcance() {
		double multiplicador = 1;
		for (Potenciador potenciador: potenciadoresActivos){
			multiplicador *= potenciador.getMultiplicadorAlcance();
		}
		int alcanceActual = estado.getAlcance();
		return (int) (alcanceActual*multiplicador);
	}

	public double getVida() {
		return vida;
	}
	
	public int getKi() {
		return ki;
	}
	
	public int getVelocidad() {
		int multiplicador = 1;
		for (Potenciador potenciador: potenciadoresActivos){
			multiplicador *= potenciador.getMultiplicadorVelocidad();
		}
		int velocidadActual = estado.getVelocidad();
		return velocidadActual *= multiplicador; 
	}

	public String getNombre() {
		return estado.getNombre();
	}

	public IContenedorDeFicha getPosicion(){
		return coordenadas;
	}

	@Override
	public void setPosicion(IContenedorDeFicha coordenadas){
		this.coordenadas = coordenadas;
	}
	
	public Equipo getEquipo(){
		return equipo;
	}
	
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	
	@Override
	public boolean permiteSuperposicion(){
		return false;
	}
	
	public void interactuarAlContacto(IFicha ficha){
		Potenciador potenciador = (Potenciador) ficha;
		potenciadoresActivos.add(potenciador);
		this.modificarVida(potenciador.getVidaExtra());
	}

	public String getNombreAtaqueEspecial() {
		// TODO Auto-generated method stub
		return ataqueEspecial.nombre;
	}
}
