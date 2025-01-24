package Model_Pojos;

public class Viajes {
 
	private String nombre;
	private String tipoViaje;
	private String fechaInicio;
	private String fechaFin;
	private String duracion;
	private String pais;
	private String descripcion;
	private String servicios;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipoViaje;
	}
	public void setTipo(String tipo) {
		this.tipoViaje = tipo;
	}
	public String getInicio() {
		return fechaInicio;
	}
	public void setInicio(String inicio) {
		this.fechaInicio = inicio;
	}
	public String getFin() {
		return fechaFin;
	}
	public void setFin(String fin) {
		this.fechaFin = fin;
	}
	public String getDias() {
		return duracion;
	}
	public void setDias(String dias) {
		this.duracion = dias;
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

}
