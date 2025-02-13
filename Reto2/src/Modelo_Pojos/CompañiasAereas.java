package Modelo_Pojos;

public class CompañiasAereas {

	private String nombre;
	private String codigo;


	public CompañiasAereas() {
		super();
		this.nombre = "";
		this.codigo = "";
		
	}
	
	public CompañiasAereas(String nombre, String codigo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		
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

	@Override
	public String toString() {
		return "CompañiasAereas [nombre=" + nombre + ", codigo=" + codigo + "]";
	}

	
}
