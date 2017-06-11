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
	protected int kiParaTransformar;
	public int getVidaMaxima() {
		return vidaMaxima;
	}

	public int getVida() {
		return vida;
	}

	public int getPoder() {
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

	public void agregarKi(int aumento) {
		ki = ki + aumento;
	}

	public void agregarVida(int aumento) {
		if(vida + aumento > this.getVidaMaxima()){
			vida = this.getVidaMaxima();
		}else{
			vida += aumento;
		}
	}
	

	public abstract boolean ataqueEspecialDisponible();	
	public abstract void ataqueEspecial(Personaje enemigo);

	public int kiParaTransformar() {
		return kiParaTransformar;
	}

}
