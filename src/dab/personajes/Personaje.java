package dab.personajes;

public abstract class Personaje { //Interfaz?
	
	private String nombre;
	private int vida;
	private int poder;
	private int alcance;
	private int velocidad;
	private int ki;
	//Agregar un atributo modo?
	
	public Personaje (String nombre, int hp, int pp, int alcance, int vel, int ki){
		this.nombre = nombre;
		vida = hp;
		poder = pp;
		this.alcance = alcance;
		velocidad = vel;
		this.ki = ki;
	}
	
	public String getNombre(){ //Necesario para mostrar en el talbero
		return nombre;
	}
	
	public int getAlcance(){ //Necesario para mostrar en la interfaz a cuanto puede atacar
		return alcance;
	}
	
	public int getVelocidad(){ //Necesario p/saber cuantos casilleros podra desplazarse c/personaje
		return velocidad;
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
}