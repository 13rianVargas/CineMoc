package co.edu.konradlorenz.model;

public class SalaCine {
	private String numero, nombre;
	private int cantSillas;
	
	public SalaCine() {
	}

	public SalaCine(String numero, String nombre, int cantSillas) {
		this.numero = numero;
		this.nombre = nombre;
		this.cantSillas = cantSillas;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantSillas() {
		return cantSillas;
	}

	public void setCantSillas(int cantSillas) {
		this.cantSillas = cantSillas;
	}

	@Override
	public String toString() {
		return "SalaCine [numero=" + numero + ", nombre=" + nombre + ", cantSillas=" + cantSillas + "]";
	}
	
	
	
}
