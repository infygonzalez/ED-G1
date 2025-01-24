package Model_Pojos;

import java.util.ArrayList;

public class Aerolinea {
	private String nombre;
	private String codigo;
	private ArrayList<Aerolinea> aerolinea = new ArrayList<>();

	public Aerolinea(String nombre, String codigo, ArrayList<Aerolinea> aerolinea) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.aerolinea = aerolinea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Aerolinea> getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(ArrayList<Aerolinea> aerolinea) {
		this.aerolinea = aerolinea;
	}

	@Override
	public String toString() {
		return "Aerolinea [nombre=" + nombre + ", codigo=" + codigo + ", aerolinea=" + aerolinea + "]";
	}

}
