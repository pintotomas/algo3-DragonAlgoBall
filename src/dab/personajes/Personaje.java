package dab.personajes;

public abstract class Personaje {
	
	protected int vida;
	protected int poder;
	protected int alcance;
	protected int ki;
	protected int velocidad;
	protected String nombre;
	protected int kiParaEspecial;
	
	public int getVida() {
		return vida;
	}

	public int getPp() {
		return poder;
	}

	public int getAlcance() {
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
	
	public abstract Personaje transformar();
	public abstract boolean transformarDisponible();
	public abstract boolean ataqueEspecialDisponible();	
	public abstract void ataqueEspecial(Personaje enemigo);
	
}
