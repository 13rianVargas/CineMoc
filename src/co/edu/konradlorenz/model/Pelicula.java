package co.edu.konradlorenz.model;

import java.util.ArrayList;

public class Pelicula {
	private byte id;
	private int duracion;
	private String paisOrigen, año, tituloOriginal, idioma, sinopsis;
	private boolean subtitulos;
	private ArrayList<Realizador> listaRealizadores;
	
	public Pelicula() {
	}

	public Pelicula(byte id, int duracion, String paisOrigen, String año, String tituloOriginal, String idioma,
			String sinopsis, boolean subtitulos, ArrayList<Realizador> listaRealizadores) {
		this.id = id;
		this.duracion = duracion;
		this.paisOrigen = paisOrigen;
		this.año = año;
		this.tituloOriginal = tituloOriginal;
		this.idioma = idioma;
		this.sinopsis = sinopsis;
		this.subtitulos = subtitulos;
		this.listaRealizadores = listaRealizadores;
	}

	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public String getTituloOriginal() {
		return tituloOriginal;
	}

	public void setTituloOriginal(String tituloOriginal) {
		this.tituloOriginal = tituloOriginal;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public boolean isSubtitulos() {
		return subtitulos;
	}

	public void setSubtitulos(boolean subtitulos) {
		this.subtitulos = subtitulos;
	}

	public ArrayList<Realizador> getListaRealizadores() {
		return listaRealizadores;
	}

	public void setListaRealizadores(ArrayList<Realizador> listaRealizadores) {
		this.listaRealizadores = listaRealizadores;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", duracion=" + duracion + ", paisOrigen=" + paisOrigen + ", año=" + año
				+ ", tituloOriginal=" + tituloOriginal + ", idioma=" + idioma + ", sinopsis=" + sinopsis
				+ ", subtitulos=" + subtitulos + "]";
	}

	
	
}
