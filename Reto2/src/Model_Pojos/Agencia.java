package Model_Pojos;

import java.util.ArrayList;

public class Agencia {

	private int id;
	private String nombre;
	private String logo;
	private String colorMarca;
	private String numeroEmpleados;
	private String tipoAgencia;
	private String contraseña;
	private ArrayList<Viajes> viajes;

	public Agencia() {
		this.id = 0;
		this.nombre = "";
		this.logo = "";
		this.colorMarca = "";
		this.numeroEmpleados = "";
		this.tipoAgencia = "";
		this.contraseña = "";
		this.viajes = null;

	}

	public Agencia(int id, String nombre, String logo, String colorMarca, String numeroEmpleados, String tipoAgencia,
			ArrayList<Viajes> viajes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.logo = logo;
		this.colorMarca = colorMarca;
		this.numeroEmpleados = numeroEmpleados;
		this.tipoAgencia = tipoAgencia;
		this.contraseña = contraseña;
		this.viajes = viajes;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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

	public String getNumeroEmpleados() {
		return numeroEmpleados;
	}

	public void setNumeroEmpleados(String numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	public String getTipoAgencia() {
		return tipoAgencia;
	}

	public void setTipoAgencia(String tipoAgencia) {
		this.tipoAgencia = tipoAgencia;
	}

	public ArrayList<Viajes> getViajes() {
		return viajes;
	}

	public void setViajes(ArrayList<Viajes> viajes) {
		this.viajes = viajes;
	}

	@Override
	public String toString() {
		return "Agencia [id=" + id + ", nombre=" + nombre + ", logo=" + logo + ", colorMarca=" + colorMarca
				+ ", numeroEmpleados=" + numeroEmpleados + ", tipoAgencia=" + tipoAgencia + ", contraseña=" + contraseña
				+ ", viajes=" + viajes + "]";
	}

}
