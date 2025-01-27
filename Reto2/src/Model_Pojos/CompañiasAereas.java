package Model_Pojos;

public class CompañiasAereas {

	private String nombre;
	private String codigo;
	private VuelosIda vuelosIda;

	public CompañiasAereas(String nombre, String codigo, VuelosIda vuelosIda) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.vuelosIda = vuelosIda;
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

	public VuelosIda getVuelosIda() {
		return vuelosIda;
	}

	public void setVuelosIda(VuelosIda vuelosIda) {
		this.vuelosIda = vuelosIda;
	}

	@Override
	public String toString() {
		return "CompañiasAereas [nombre=" + nombre + ", codigo=" + codigo + ", vuelosIda=" + vuelosIda + "]";
	}

}
