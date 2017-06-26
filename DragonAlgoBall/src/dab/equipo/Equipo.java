package dab.equipo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import dab.interfaces.IProveedorDeVidaDePersonajes;
import dab.juego.Celda;
import dab.personajes.Personaje;
import dab.potenciadores.Potenciador;

public class Equipo implements IProveedorDeVidaDePersonajes{
	/*contiene a los personajes, y a su vez,  podria ser que los personajes contengan al equipo.
	 * asi por ejemplo para la habilidad de picollo y gohan podemos acceder a los personajes del equipo de
	 * forma rapida
	 */
	Map<String, Personaje> integrantes;
	private String nombreEquipo;
	private int kiNuevoTurno = 5; //Ver si lo puede hacer turno 
	private ArrayList<Potenciador> itemsDeLosCaidos;
	
	public Equipo(String nombre){
		itemsDeLosCaidos = new ArrayList<Potenciador>();
		this.nombreEquipo = nombre;
		this.integrantes = new HashMap<String, Personaje>();
	}
	
	public Equipo(String nombre, Personaje...personaje){
		this(nombre);
		for (Personaje pj: personaje){
			this.agregarPersonaje(pj);
		}
	}
	
	public String getNombre(){
		return this.nombreEquipo;
	}
	
	public int cantidadParticipantes(){
		return this.integrantes.size();
	}
	
	public void agregarPersonaje(Personaje personaje){
		this.integrantes.put(personaje.getNombre(), personaje);
		personaje.setEquipo(this);
	}
	
	public void quitarPersonaje(Personaje personaje){
		this.integrantes.remove(personaje.getNombre());
		Celda celdaPersonajeMuerto = (Celda) personaje.getPosicion();
		//Esto lo deberia hacer el juego. 
		celdaPersonajeMuerto.quitarFichaMovible();
	}
	
	public int cantidadItemsParaGanar(){
		int cantidadItemsParaGanar = 0;
		for (Personaje pj: integrantes.values()){
			cantidadItemsParaGanar += pj.cantidadItemsParaGanar(); 
		}
		return cantidadItemsParaGanar;
	}
	
	public void agregarPersonajes(Collection<Personaje> personajes){
		for(Personaje p: personajes){
			this.agregarPersonaje(p);
		}
	}
	
	public Collection<Personaje> obtenerPersonajes(){
		return this.integrantes.values();
	}
	
	public boolean existePersonajeEnEquipo(Personaje personaje){
		return this.integrantes.containsValue(personaje);
	}
	
	public Personaje obtenerPersonaje(String nombre){ //metodo para pruebas mas que nada
		Personaje personaje = this.integrantes.get(nombre);
		if(personaje == null) throw new RuntimeException("nombre incorrecto en obtener personaje" + nombre);
		return personaje;
	}
	
	public double obtenerVidaDelPersonaje(String nombre){
		System.out.println("Se quiere saber de la vida de "+nombre+" en el equipo "+this.nombreEquipo);
		Personaje personaje = this.integrantes.get(nombre);
		return personaje.getVida();
	}

	public double obtenerPorcentajeDeVidaDelPersonaje(String nombre){
		Personaje personaje = this.integrantes.get(nombre);
		return personaje.getPorcentajeDeVida();
	}
	public void otorgarKi(int cantidad){
		Collection<Personaje> personajesEquipo = this.integrantes.values();
		for (Personaje p: personajesEquipo){
			p.modificarKi(cantidad);
		}
	}

	public void nuevoTurno(){
		this.otorgarKi(kiNuevoTurno);
		this.notificarNuevoTurnoAPersonajes();
	}
	

	private void notificarNuevoTurnoAPersonajes(){
		Collection<Personaje> personajesEquipo = this.integrantes.values();
		for (Personaje p: personajesEquipo){
			p.nuevoTurno();
		}
	}

	public void notificarAtaqueHacia(Personaje aPersonaje) {
		double vidaDelAfectado = this.obtenerVidaDelPersonaje(aPersonaje.getNombre());
		if (vidaDelAfectado <= 0){
			this.quitarObjetosAlPersonaje(aPersonaje);
			this.quitarPersonaje(aPersonaje);
		}
	}
	
	private void quitarObjetosAlPersonaje(Personaje aPersonaje){
		Collection<Potenciador> potenciadores = aPersonaje.getPotenciadores();
		itemsDeLosCaidos.clear();
		itemsDeLosCaidos.addAll(potenciadores);
 	}

	public ArrayList<Potenciador> ultimosObjetosPerdidos() {
		// TODO Auto-generated method stub
		return itemsDeLosCaidos;
	}

}
