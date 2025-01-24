package Model_Pojos;

import java.util.ArrayList;

public class Agencias {
	private String nombre;
	private String color;
	private int empleados;
	private String tipo;
	private String logo;
	private ArrayList<Agencias> agencias = new ArrayList<>();

	public Agencias(String nombre, String color, int empleados, String tipo, String logo,
			ArrayList<Agencias> agencias) {
		this.nombre = nombre;
		this.color = color;
		this.empleados = empleados;
		this.tipo = tipo;
		this.logo = logo;
		this.agencias = agencias;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getEmpleados() {
		return empleados;
	}

	public void setEmpleados(int empleados) {
		this.empleados = empleados;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public ArrayList<Agencias> getAgencias() {
		return agencias;
	}

	public void setAgencias(ArrayList<Agencias> agencias) {
		this.agencias = agencias;
	}

	@Override
	public String toString() {
		return "Agencias [nombre=" + nombre + ", color=" + color + ", empleados=" + empleados + ", tipo=" + tipo
				+ ", logo=" + logo + ", agencias=" + agencias + "]";
	}

}