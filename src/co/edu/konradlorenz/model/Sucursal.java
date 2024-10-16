package co.edu.konradlorenz.model;

import java.util.ArrayList;

public class Sucursal {
	private String nombre, direccion, telefono, descripcion;
	private double descuento;
	protected Cartelera objCartelera;
	private ArrayList<SalaCine> listaSalasCine= new ArrayList<>();
	
	public Sucursal() {		
	}

	public Sucursal(String nombre, String direccion, String telefono, String descripcion, double descuento,
			Cartelera objCartelera, ArrayList<SalaCine> listaSalasCine) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.descripcion = descripcion;
		this.descuento = descuento;
		this.objCartelera = objCartelera;
		this.listaSalasCine = listaSalasCine;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Cartelera getObjCartelera() {
		return objCartelera;
	}

	public void setObjCartelera(Cartelera objCartelera) {
		this.objCartelera = objCartelera;
	}

	public ArrayList<SalaCine> getListaSalasCine() {
		return listaSalasCine;
	}

	public void setListaSalasCine(ArrayList<SalaCine> listaSalasCine) {
		this.listaSalasCine = listaSalasCine;
	}

	@Override
	public String toString() {
		return "Sucursal [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", descripcion="
				+ descripcion + ", descuento=" + descuento + "]";
	}
	
	
	
}
