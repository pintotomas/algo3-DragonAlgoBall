package dab.estados;

import dab.interfaces.IProveedorDeKi;

public abstract class Estado {
	protected double vidaMaxima;
	protected int poder;
	protected int alcance;
	protected int velocidad;
	protected String nombre;
	protected int kiParaEspecial;
	protected int kiParaTransformar;
	protected IProveedorDeKi proveedorDeKi;
	
	protected Estado(IProveedorDeKi proveedorDeKi){
		this.proveedorDeKi = proveedorDeKi;
	}
	protected Estado(){};
	public double getVidaMaxima() {
		return vidaMaxima;
	}

	public int getPoder() {
		return poder;
	}

	public int getAlcance() {
		return alcance;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public String getNombre() {
		return nombre;
	}

	public int kiParaTransformar() {
		return kiParaTransformar;
	}

	public abstract Estado transformar();

	public boolean transformarDisponible() {
		return proveedorDeKi.getKi() >= kiParaTransformar;
	}

}
