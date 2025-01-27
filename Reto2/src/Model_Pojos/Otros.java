package Model_Pojos;

public class Otros {
	private String nombre;
	private String fecha;
	private String descripcion;
	private float precio;
	private Viajes viajes;

	public Otros(String nombre, String fecha, String descripcion, float precio, Viajes viajes) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.precio = precio;
		this.viajes = viajes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Viajes getViajes() {
		return viajes;
	}

	public void setViajes(Viajes viajes) {
		this.viajes = viajes;
	}

	@Override
	public String toString() {
		return "Otros [nombre=" + nombre + ", fecha=" + fecha + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", viajes=" + viajes + "]";
	}

}
