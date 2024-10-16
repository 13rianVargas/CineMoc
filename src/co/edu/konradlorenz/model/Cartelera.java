package co.edu.konradlorenz.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Cartelera {
	private LocalDateTime fecha;
	private ArrayList<Funcion> listaFunciones;

	
	public Cartelera() {
	}

	public Cartelera(LocalDateTime fecha, ArrayList<Funcion> listaFunciones) {
		this.fecha = fecha;
		this.listaFunciones = listaFunciones;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Funcion> getListaFunciones() {
		return listaFunciones;
	}

	public void setListaFunciones(ArrayList<Funcion> listaFunciones) {
		this.listaFunciones = listaFunciones;
	}

	@Override
	public String toString() {
		return "Cartelera [fecha=" + fecha + "]";
	}

}
