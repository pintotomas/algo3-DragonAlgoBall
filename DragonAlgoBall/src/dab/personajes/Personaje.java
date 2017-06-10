package dab.personajes;

import java.util.List;
import dab.consumibles.Consumible;
import dab.equipos.Equipo;
import dab.juego.Celda;

public class Personaje{
	
	protected Equipo equipo; //falta agregar el equipo en todos los constructores. 
	protected Celda posicion;
	List <Consumible> consumibles; 
	private int cantidadAtaques = 0; //Lo dejo, pero no se para que está
	private Estado estado;

	public Personaje(Estado estado){
		this.estado = estado;
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

	public int getNumeroAtaque(){ //para que se necesita?
		return cantidadAtaques;
	}
	
	private void recibirAtaque(double dano) { 
		if(dano < this.getPoder()){
			dano = dano * 0.8;		
		}
		this.agregarHp(-dano);	
	}
	
	public boolean transformarDisponible(){
		return estado.transformarDisponible();
	}
	
	public void transformar(){
		estado = estado.transformar();
	}
	
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
	
	public void agregarConsumible(Consumible c){
		consumibles.add(c);
		this.agregarHp(c.getVidaExtra());
	}
}
