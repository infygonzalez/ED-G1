package Model_Pojos;

import java.util.ArrayList;

public class Aeropuerto {

	private String nombreAeropuerto;
	private String codigo;
	private ArrayList<Aeropuerto> aeropuerto = new ArrayList<>();

	public Aeropuerto(String nombreAeropuerto, String codigo, ArrayList<Aeropuerto> aeropuerto) {
		this.nombreAeropuerto = nombreAeropuerto;
		this.codigo = codigo;
		this.aeropuerto = aeropuerto;
	}

	public String getNombreAeropuerto() {
		return nombreAeropuerto;
	}

	public void setNombreAeropuerto(String nombreAeropuerto) {
		this.nombreAeropuerto = nombreAeropuerto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Aeropuerto> getAeropuerto() {
		return aeropuerto;
	}

	public void setAeropuerto(ArrayList<Aeropuerto> aeropuerto) {
		this.aeropuerto = aeropuerto;
	}

	@Override
	public String toString() {
		return "Aeropuerto [nombreAeropuerto=" + nombreAeropuerto + ", codigo=" + codigo + ", aeropuerto=" + aeropuerto
				+ "]";
	}

}
