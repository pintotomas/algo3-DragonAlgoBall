package dab.personajes;

import java.util.List;
import dab.consumibles.Consumible;
import dab.equipos.Equipo;
import dab.juego.Celda;

public class Personaje{
	
	protected Equipo equipo; //falta agregar el equipo en todos los constructores. 
	protected Celda posicion;
	List <Consumible> efectos; 
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

	public int getPoder() {
		return estado.getPoder();
	}

	public int getAlcance() {

		double multiplicador = 1;
		for (Consumible efecto: efectos){
			multiplicador *= efecto.getMultiplicadorAlcance();
		}
		int alcanceActual = estado.getAlcance();
		return alcanceActual *= multiplicador;

	}

	public int getKi() {
		return estado.getKi();
	}

	public double getVelocidad() {
		double multiplicador = 1;
		for (Consumible efecto: efectos){
			multiplicador *= efecto.getMultiplicadorVelocidad();
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
	
	public void agregarHp(int cantidad){
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
		if(consumibleActivo != null){
			
		}
	}
	
	public void setConsumibleActivo(Consumible consumible){
		consumibleActivo = consumible;
	}
	
	public int getNumeroAtaque(){
		return cantidadAtaques;
	}
	private void recibirAtaque(int pp) {
		if(pp < this.getPoder()){
			pp = (int)(pp * 0.8);		
		}
		this.agregarHp(-pp);	
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
		for (Consumible efecto: efectos){
			efecto.pasoUnTurno();
			if (!efecto.estaActivo()){
				efectos.remove(efecto);
			}
		}
		// TODO Auto-generated method stub
		//aca hacer l
		
	}	
}
