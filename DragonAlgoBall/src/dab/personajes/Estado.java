package dab.personajes;

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
		return vidaMaxima;
	}

	public int getVida() {
		// TODO Auto-generated method stub
		return vida;
	}

	public int getPoder() {
		// TODO Auto-generated method stub
		return poder;
	}

	public int getAlcance() {
		// TODO Auto-generated method stub
		return alcance;
	}

	public int getKi() {
		// TODO Auto-generated method stub
		return ki;
	}

	public int getVelocidad() {
		// TODO Auto-generated method stub
		return velocidad;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	public void agregarKi(int aumento) {
		// TODO Auto-generated method stub
		ki = ki + aumento;
	}

	public void agregarVida(int aumento) {
		// TODO Auto-generated method stub
		vida = vida + aumento;
	}
	
	public abstract Estado transformar();
	public abstract boolean transformarDisponible();
	public abstract boolean ataqueEspecialDisponible();	
	public abstract void ataqueEspecial(Personaje enemigo);

}
