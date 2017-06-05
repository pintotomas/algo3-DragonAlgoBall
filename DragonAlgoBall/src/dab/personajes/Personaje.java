package dab.personajes;

import dab.equipos.Equipo;
import dab.juego.Celda;

public class Personaje {
	
	
	protected Equipo equipo; //falta agregar el equipo en todos los constructores. 
	private Estado estado;
	protected boolean semillaDelHermitano, nubeVoladora, esferaDelDragon;
	protected Celda posicion;
	
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
		if(esferaDelDragon)
			return (int)(estado.getPoder() * 1.25);
		return estado.getPoder();
	}

	public int getAlcance() {
		if(nubeVoladora)
			return estado.getAlcance() * 2;
		return estado.getAlcance();
	}

	public int getKi() {
		return estado.getKi();
	}

	public int getVelocidad() {
		return estado.getVelocidad();
	}

	public String getNombre() {
		return estado.getNombre();
	}

	public Celda getPosicion(){
		return estado.getPosicion();
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
		if(celda.estaOcupada()) return false; 
		
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
		estado.agregarVida(this.getVida() + cantidad);
		//faltaria agregar que pasa si se muere.
	
	}
	
	public void agarroSemillaDelHermitanio(){
		this.agregarHp(100);
		if(this.getVida() > this.getVidaMaxima())
			this.agregarHp(this.getVidaMaxima());	
	}
	
	public boolean puedeAtacar(Personaje personaje) {
		int maxFila = posicion.getFila() + this.getAlcance();
		int maxColumna = posicion.getColumna() + this.getAlcance();
		Celda celda = personaje.getPosicion();
		if(celda.getColumna() > maxColumna  ||  celda.getFila() > maxFila){
			return false;
		}
		if(celda.darOcupante().getEquipo() == this.getEquipo()){
			return false;
		}
		return true;
	}
	
	public void atacarA(Personaje personaje){
		personaje.recibirAtaque(this.getPoder());
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
		estado.transformar();
	}
	
	public void convertirEnChocolate(){
		
		/*faltaria implementar para la especial de boo. 
		* teniendo en cuenta que deven pasar 3 turnos.	
		*/
	}	
}
