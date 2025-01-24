package Model_Pojos;

import java.util.ArrayList;
import java.util.ArrayList;

public class Actividad {

	private String nombreEvento;
	private String descripcion;
	private String fecha;
	private float precio;
	private ArrayList<Actividad> actividad = new ArrayList<>();;

	public Actividad(String nombreEvento, String descripcion, String fecha, float precio,
			ArrayList<Actividad> actividad) {
		this.nombreEvento = nombreEvento;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.precio = precio;
		this.actividad = actividad;
	}

	public String getNombreEvento() {
		return nombreEvento;
	}

	public void setNombreEvento(String nombreEvento) {
		this.nombreEvento = nombreEvento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public ArrayList<Actividad> getActividad() {
		return actividad;
	}

	public void setActividad(ArrayList<Actividad> actividad) {
		this.actividad = actividad;
	}

	@Override
	public String toString() {
		return "Actividad [nombreEvento=" + nombreEvento + ", descripcion=" + descripcion + ", fecha=" + fecha
				+ ", precio=" + precio + ", actividad=" + actividad + "]";
	}

}
