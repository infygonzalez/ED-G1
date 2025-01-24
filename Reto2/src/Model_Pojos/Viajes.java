package Model_Pojos;

import java.util.ArrayList;

public class Viajes {

	private String nombre;
	private String tipoViaje;
	private String fechaInicio;
	private String fechaFin;
	private String duracion;
	private String pais;
	private String descripcion;
	private String servicios;

	private ArrayList<Viajes> viajes = new ArrayList<>();

	public Viajes(String nombre, String tipoViaje, String fechaInicio, String fechaFin, String duracion, String pais,
			String descripcion, String servicios, ArrayList<Viajes> viajes) {
		this.nombre = nombre;
		this.tipoViaje = tipoViaje;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.duracion = duracion;
		this.pais = pais;
		this.descripcion = descripcion;
		this.servicios = servicios;
		this.viajes = viajes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoViaje() {
		return tipoViaje;
	}

	public void setTipoViaje(String tipoViaje) {
		this.tipoViaje = tipoViaje;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}

	public ArrayList<Viajes> getViajes() {
		return viajes;
	}

	public void setViajes(ArrayList<Viajes> viajes) {
		this.viajes = viajes;
	}

	@Override
	public String toString() {
		return "Viajes [nombre=" + nombre + ", tipoViaje=" + tipoViaje + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", duracion=" + duracion + ", pais=" + pais + ", descripcion=" + descripcion
				+ ", servicios=" + servicios + ", viajes=" + viajes + "]";
	}

}
