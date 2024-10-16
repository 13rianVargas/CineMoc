package co.edu.konradlorenz.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cartelera {
	private LocalDateTime fecha;
	private ArrayList<Pelicula> listaPeliculas;

	
	public Cartelera() {
	}

	public Cartelera(LocalDateTime fecha, ArrayList<Pelicula> listaPeliculas) {
		this.fecha = fecha;
		this.listaPeliculas = new ArrayList<>();
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	public void setListaPeliculas(ArrayList<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}

	@Override
	public String toString() {
		return "Cartelera [fecha=" + fecha + "]";
	}

}
