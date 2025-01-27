package Model_Pojos;

public class Pais {

	private String codigo;
	private String nombre;

	// Relaciones
	private CodigoIATA codigoIATA;

	public Pais(String codigo, String nombre, CodigoIATA codigoIATA) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.codigoIATA = codigoIATA;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CodigoIATA getCodigoIATA() {
		return codigoIATA;
	}

	public void setCodigoIATA(CodigoIATA codigoIATA) {
		this.codigoIATA = codigoIATA;
	}

	@Override
	public String toString() {
		return "Pais [codigo=" + codigo + ", nombre=" + nombre + "]";
	}

}
