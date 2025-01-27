package Model_Pojos;

import java.util.ArrayList;

public class Viaje {
	private int id;
	private String nombre;
	private String descripcion;
	private String tipoViaje;
	private String fechaInicio;
	private String fechaFin;
	private double precio;

	// Relaciones
	private Empresa empresa; // N:1
	private ArrayList<Evento> eventos; // 1:N
	private Pais pais; // 1:N

	public Viaje(int id, String nombre, String descripcion, String tipoViaje, String fechaInicio, String fechaFin,
			double precio, Empresa empresa, ArrayList<Evento> eventos, Pais pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipoViaje = tipoViaje;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.precio = precio;
		this.empresa = empresa;
		this.eventos = eventos;
		this.pais = pais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public ArrayList<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Viaje [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipoViaje=" + tipoViaje
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", precio=" + precio + ", empresa="
				+ empresa + ", pais=" + pais + "]";
	}

}
