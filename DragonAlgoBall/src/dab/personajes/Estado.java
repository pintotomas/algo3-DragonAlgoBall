package dab.personajes;
import dab.juego.Celda;

public abstract class Estado {
	protected int vidaMaxima;
	protected int vida;
	protected int poder;
	protected int alcance;
	protected int ki;
	protected int velocidad;
	protected String nombre;
	protected int kiParaEspecial;
	
	public int getVidaMaxima() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getVida() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getPoder() {
		// TODO Auto-generated method stub
		return 0;
	}



	public int getAlcance() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getKi() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getVelocidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public Celda getPosicion() {
		// TODO Auto-generated method stub
		return null;
	}

	public void agregarKi(int i) {
		// TODO Auto-generated method stub
		
	}

	public void agregarVida(int i) {
		// TODO Auto-generated method stub
		
	}
	
	public abstract Estado transformar();
	public abstract boolean transformarDisponible();
	public abstract boolean ataqueEspecialDisponible();	
	public abstract void ataqueEspecial(Personaje enemigo);

}
