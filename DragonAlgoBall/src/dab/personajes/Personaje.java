package dab.personajes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import dab.ataquesEspeciales.AtaqueEspecial;
import dab.consumibles.Consumible;
import dab.equipo.Equipo;
import dab.juego.Celda;

public abstract class Personaje{
	
	protected Equipo equipo; //falta agregar el equipo en todos los constructores. 
	protected Celda posicion;
	protected List <Consumible> consumibles = new LinkedList<Consumible>(); 
	private int cantidadAtaques = 0; //Lo dejo, pero no se para que está
	protected int kiParaEspecial;   //puede estar aca porque no cambia con los estados.
	protected AtaqueEspecial spec;
	protected Estado estado;
	protected List<Class<? extends Estado>> estados = new ArrayList<Class<? extends Estado>>();
	Iterator<Class<? extends Estado>> iter;
	
	



	/***************
	 * 
	 *  ATAQUE
	 * 
	 * 
	 ****************/
	
	
	
	

	public boolean puedeAtacar(Personaje personaje) {
		int maxFila = posicion.getFila() + this.getAlcance();
		int maxColumna = posicion.getColumna() + this.getAlcance();
		Celda celda = personaje.getPosicion();
		if(celda.getColumna() > maxColumna  ||  celda.getFila() > maxFila){
			return false;
		}
		if(celda.darPersonajeOcupante().getEquipo() == this.getEquipo()){
			return false;
		}
		return true;
	}
	
	public void atacarA(Personaje personaje){
		personaje.recibirAtaque(this.getPoder());
		cantidadAtaques += 1;
	}
	public boolean ataqueEspecialDisponible() {
		return estado.getKi() >= kiParaEspecial;
	}

	
	public void ataqueEspecial(Personaje enemigo) {
		spec.lanzar(enemigo);
		this.agregarKi(-1*(kiParaEspecial));
	}
	
	
	
	
	
	
	
	
	
	/**************
	 * 
	 * MOVIMIENTO
	 * 
	 * 
	 **************/
	
		
	public boolean movimientoPosible(Celda celda){
		//verifica que el movimiento se pueda hacer.
		//verifica que la celda destino este libre
		if(celda.estaOcupadaPorPersonaje()) return false; 
		
		int maxFila = posicion.getFila() + this.getVelocidad();
		int maxColumna = posicion.getColumna() + this.getVelocidad();
		//verifica que el movimiento se pueda hacer.
		if(celda.getColumna() > maxColumna  ||  celda.getFila() > maxFila){
			return false;
		}
		return true;
	}
	
	
	public void mover(Celda celda) {
		celda.colocarPersonaje(this); //si tira error que lo mande para arriba.
		posicion.quitarPersonaje();
		posicion = celda;
	}
	
	
	
	
	
	
	
	
	
	
	/**********************
	 * 
	 * AGREGAR KI Y VIDA
	 * 
	 * 
	 ***********************/
	
	
	public void agregarKi(int cantidad){
		/* Modifica el ki agregando 'cantidad'. 
		 * PRE: Cantidad es un numero entero.
		 * POST: El ki es modificado
		 */
		estado.agregarKi(this.getKi() + cantidad);
	}
	
	
	public void agregarHp(double cantidad){
		/* Modifica la vida agregando 'cantidad'. 
		 * PRE: Cantidad es un numero entero.
		 * POST: La vida es modificada
		 */
		estado.agregarVida(cantidad);
		//faltaria agregar que pasa si se muere.
	
	}
	
	
	
	
	/*****************
	 * 
	 * TRANSFORMAR Y TURNO
	 * 
	 * 
	 * 
	 ***************/
	
	

	public void convertirEnChocolate(){
		
		/*faltaria implementar para la especial de boo. 
		* teniendo en cuenta que deven pasar 3 turnos.	
		*/
	}

	public void nuevoTurno() {
		for (Consumible c: consumibles){
			c.pasoUnTurno();
			if (!c.estaActivo()){
				consumibles.remove(c);
			}
		}
		// TODO Auto-generated method stub
		//aca hacer l
		
	}	
	

	public boolean transformarDisponible() {
		return (iter.hasNext() && estado.getKi() >= estado.kiParaTransformar());
	}
	
	public void transformar(){
		try {
			estado = (iter.next()).newInstance();
		} catch (InstantiationException | IllegalAccessException e) { //despues vemos como lo manejamos, pero ni ida que son los errores.
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	/*****************
	 * 
	 *  GETERS Y SETERS
	 * 
	 *****************/
	
	
	public void setIter(Iterator<Class<? extends Estado>> iter_){
		iter = iter_;		
	}
	
	public void setEstado(Estado estado_){
		estado = estado_;
		
	}
	
	public int getVidaMaxima(){
		return estado.getVidaMaxima();
	}
	
	public int getVida() {
		return estado.getVida();
	}

	public double getPoder() {
		
		double multiplicador = 1;
		for (Consumible c: consumibles){
			multiplicador *= c.getMultiplicadorPoderDePelea();
		}
		double poderActual = estado.getPoder(); 
		return poderActual *= multiplicador;
	}

	public int getAlcance() {
		
		return estado.getAlcance();
		
	}

	public int getKi() {
		return estado.getKi();
	}

	public int getVelocidad() {
		int multiplicador = 1;
		for (Consumible c: consumibles){
			multiplicador *= c.getMultiplicadorVelocidad();
		}
		int velocidadActual = estado.getVelocidad(); //cambiarlo a double?
		return velocidadActual *= multiplicador; // *=;
	}

	public String getNombre() {
		return estado.getNombre();
	}

	public Celda getPosicion(){
		return posicion;
	}
	
	public void setPosicion(Celda celda){
		posicion = celda;
	}
	
	public Equipo getEquipo(){
		return equipo;
	}
	
	public void setEquipo(Equipo equipo_) {
		equipo = equipo_;
	}
	
	public int getNumeroAtaque(){
		return cantidadAtaques;
	}
	private void recibirAtaque(double poderEnemigo) {
		if(poderEnemigo < this.getPoder()){
			poderEnemigo = (int)(poderEnemigo * 0.8);		
		}
		this.agregarHp(-poderEnemigo);	
	}
	
	public void agregarConsumible(Consumible c){
		consumibles.add(c);
		this.agregarHp(c.getVidaExtra());
	}
}
