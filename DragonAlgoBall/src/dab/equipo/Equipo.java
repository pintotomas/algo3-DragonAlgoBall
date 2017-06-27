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
	Map<Integer, Personaje> integrantes;
	private String nombreEquipo;
	private int kiNuevoTurno = 5; //Ver si lo puede hacer turno 
	private ArrayList<Potenciador> itemsDeLosCaidos;
	
	public Equipo(String nombre){
		itemsDeLosCaidos = new ArrayList<Potenciador>();
		this.nombreEquipo = nombre;
		this.integrantes = new HashMap<Integer, Personaje>();
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
		this.integrantes.put(personaje.getIdentificador(), personaje);
		personaje.setEquipo(this);
	}
	
	public void quitarPersonaje(Personaje personaje){
		this.integrantes.remove(personaje.getIdentificador());
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
	
	public Personaje obtenerPersonaje(int identificador){ //metodo para pruebas mas que nada
		Personaje personaje = this.integrantes.get(identificador);

		if(personaje == null) throw new RuntimeException("Identificador de personaje incorrecto" + identificador);
		return personaje;
	}
	
	public double obtenerVidaDelPersonaje(int identificador){
		
		Personaje personaje = this.integrantes.get(identificador);
		return personaje.getVida();
	}

	public double obtenerPorcentajeDeVidaDelPersonaje(int identificador){
		
		try{
			Personaje personaje = this.integrantes.get(identificador);
			return personaje.getPorcentajeDeVida();
		}
		catch (NullPointerException e){
			//El personaje no estaba o ya murio
			return 0;
		}
		
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
		double vidaDelAfectado = this.obtenerVidaDelPersonaje(aPersonaje.getIdentificador());
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
