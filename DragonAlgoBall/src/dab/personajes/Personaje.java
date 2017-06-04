package dab.personajes;

import dab.equipos.Equipo;
import dab.juego.Celda;

public abstract class Personaje {
	
	
	protected Equipo equipo; //falta agregar el equipo en todos los constructores. 
	protected int vidaMaxima;
	protected int vida;
	protected int poder;
	protected int alcance;
	protected int ki;
	protected int velocidad;
	protected String nombre;
	protected int kiParaEspecial;
	protected boolean semillaDelHermitano, nubeVoladora, esferaDelDragon;
	protected Celda posicion;
	
	
	
	public int getVidaMaxima(){
		return vidaMaxima;
	}
	
	public int getVida() {
		return vida;
	}

	public int getPp() {
		if(esferaDelDragon)
			return (int)(poder * 1.25);
		return poder;
	}

	public int getAlcance() {
		if(nubeVoladora)
			return alcance * 2;
		return alcance;
	}

	public int getKi() {
		return ki;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public String getNombre() {
		return nombre;
	}

	public Celda getPosicion(){
		return posicion;
	}
	
	public void setPosicion(Celda celda){
		posicion = celda;
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
	
	
	public void agregarKi(int cantidad){
		/* Modifica el ki agregando 'cantidad'. 
		 * PRE: Cantidad es un numero entero.
		 * POST: El ki es modificado
		 */
		this.ki = ki + cantidad;
	}
	
	public void agregarHp(int cantidad){
		/* Modifica la vida agregando 'cantidad'. 
		 * PRE: Cantidad es un numero entero.
		 * POST: La vida es modificada
		 */
		vida = vida + cantidad;
	}
	
	public void agarroSemillaDelHermitanio(){
		this.agregarHp(100);
		if(vida > vidaMaxima)
			vida = vidaMaxima;	
	}
	
	
	
	public abstract Personaje transformar();
	public abstract boolean transformarDisponible();
	public abstract boolean ataqueEspecialDisponible();	
	public abstract void ataqueEspecial(Personaje enemigo);

	public void convertirEnChocolate(){
		
		/*faltaria implementar para la especial de boo. 
		* teniendo en cuenta que deven pasar 3 turnos.	
		*/
	}
	
}
