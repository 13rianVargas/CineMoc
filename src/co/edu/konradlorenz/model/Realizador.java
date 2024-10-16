package co.edu.konradlorenz.model;

public abstract class Realizador {
	private String nombre, nacioalidad;
	private int cantPeliculas;
	
	public Realizador() {
		super();
	}

	public Realizador(String nombre, String nacioalidad, int cantPeliculas) {
		super();
		this.nombre = nombre;
		this.nacioalidad = nacioalidad;
		this.cantPeliculas = cantPeliculas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacioalidad() {
		return nacioalidad;
	}

	public void setNacioalidad(String nacioalidad) {
		this.nacioalidad = nacioalidad;
	}

	public int getCantPeliculas() {
		return cantPeliculas;
	}

	public void setCantPeliculas(int cantPeliculas) {
		this.cantPeliculas = cantPeliculas;
	}

	@Override
	public String toString() {
		return "Realizador [nombre=" + nombre + ", nacioalidad=" + nacioalidad + ", cantPeliculas=" + cantPeliculas
				+ "]";
	}
	
}
