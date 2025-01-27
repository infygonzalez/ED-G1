package Model_Pojos;

public class Empresa {

	private int id;
	private String nombre;
	private String logo;
	private String colorMarca;
	private String numeroEmpresa;
	private String tipoAgencia;
	
	public Empresa(int id, String nombre, String logo, String colorMarca, String numeroEmpresa, String tipoAgencia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.logo = logo;
		this.colorMarca = colorMarca;
		this.numeroEmpresa = numeroEmpresa;
		this.tipoAgencia = tipoAgencia;
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getColorMarca() {
		return colorMarca;
	}

	public void setColorMarca(String colorMarca) {
		this.colorMarca = colorMarca;
	}

	public String getNumeroEmpresa() {
		return numeroEmpresa;
	}

	public void setNumeroEmpresa(String numeroEmpresa) {
		this.numeroEmpresa = numeroEmpresa;
	}

	public String getTipoAgencia() {
		return tipoAgencia;
	}

	public void setTipoAgencia(String tipoAgencia) {
		this.tipoAgencia = tipoAgencia;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nombre=" + nombre + ", logo=" + logo + ", colorMarca=" + colorMarca
				+ ", numeroEmpresa=" + numeroEmpresa + ", tipoAgencia=" + tipoAgencia + "]";
	}
	
	

}
