package co.edu.konradlorenz.model;

import java.util.ArrayList;

public class Actor extends Realizador {
	private ArrayList<String> personajesRealizados;

	public Actor() {
	}

	public Actor(String nombre, String nacioalidad, int cantPeliculas) {
		super(nombre, nacioalidad, cantPeliculas);
	}

	public Actor(String nombre, String nacioalidad, int cantPeliculas, ArrayList<String> personajesRealizados) {
		super(nombre, nacioalidad, cantPeliculas);
		this.personajesRealizados= personajesRealizados;
	}

	public ArrayList<String> getPersonajesRealizados() {
		return personajesRealizados;
	}

	public void setPersonajesRealizados(ArrayList<String> personajesRealizados) {
		this.personajesRealizados = personajesRealizados;
	}

	@Override
	public String toString() {
		return "Actor [personajesRealizados=" + personajesRealizados + "]";
	}
	
}
