package dab.personajes;

public abstract class Personaje {

	int vida;
	int poder;
	int alcance;
	int ki;
	int velocidad;
	String nombre;
	
	public Personaje(int hp,int pp,int alcance,int ki,int vel,String nombre){
		vida = hp;
		pp = poder;
		this.alcance = alcance;
		this.ki = ki;
		velocidad = vel;
		this.nombre = nombre;
	}
	

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

	public String nombre() {
		return nombre;
	}
	
	
	public void modificarKi(int cantidad){
		/* Modifica el ki agregando 'cantidad'. 
		 * PRE: Cantidad es un numero entero.
		 * POST: El ki es modificado
		 */
		ki = ki + cantidad;	
	}
	
	public void modificarHp(int cantidad){
		/* Modifica la vida agregando 'cantidad'. 
		 * PRE: Cantidad es un numero entero.
		 * POST: La vida es modificada
		 */
		vida = vida + cantidad;
	}
	
	public void modificarPp(int cantidad){
		/* Modifica el poder de pelea agregando 'cantidad'. 
		 * PRE: Cantidad es un numero entero.
		 * POST: El poder de pelea es modificado
		 */
		poder = poder + cantidad;
	}
	
	public void modificarAlcance(int cantidad){
		/* Modifica el alcance agregando 'cantidad'. 
		 * PRE: Cantidad es un numero entero.
		 * POST: El alcance es modificado
		 */
		alcance = alcance + cantidad;
	}
	
	public void modificarNombre(String nombre){
		/* Modifica el nombre por un nuevo nombre 
		 * PRE: nombre es un String
		 * POST: El nombre es cambiado
		 */
		this.nombre = nombre;
	}
	
	public abstract boolean transformacionDisponible();
	public abstract Personaje transformar();
	public abstract boolean ataqueEspecialDisponible();
	public abstract void ataqueEspecial(Personaje enemigo);
}
