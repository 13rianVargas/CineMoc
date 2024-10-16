package co.edu.konradlorenz.model;

public class Funcion {
	private String hora;
	private int dia;
	protected Pelicula objPelicula;
	protected SalaCine objSalaCine;
	
	
	public Funcion() {
	}

	public Funcion(String hora, int dia, Pelicula objPelicula, SalaCine objSalaCine) {
		this.hora = hora;
		this.dia = dia;
		this.objPelicula = objPelicula;
		this.objSalaCine = objSalaCine;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public Pelicula getObjPelicula() {
		return objPelicula;
	}

	public void setObjPelicula(Pelicula objPelicula) {
		this.objPelicula = objPelicula;
	}

	public SalaCine getObjSalaCine() {
		return objSalaCine;
	}

	public void setObjSalaCine(SalaCine objSalaCine) {
		this.objSalaCine = objSalaCine;
	}

	@Override
	public String toString() {
		return "Funcion [Hora=" + hora + ", Día=" + dia + ", Sala de Cine=" + objSalaCine + "]";
	}
	
}
