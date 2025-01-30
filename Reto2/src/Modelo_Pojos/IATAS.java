package Modelo_Pojos;

public class IATAS {
	private String Aeropuerto;
	private String Codigo;
	private Pais pais;
	

	public IATAS(String aeropuerto, String codigo, Pais pais ) {
		super();
		Aeropuerto = aeropuerto;
		Codigo = codigo;
		this.pais = pais;
		
	}

	public String getAeropuerto() {
		return Aeropuerto;
	}

	public void setAeropuerto(String aeropuerto) {
		Aeropuerto = aeropuerto;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	

	@Override
	public String toString() {
		return "IATAS [Aeropuerto=" + Aeropuerto + ", Codigo=" + Codigo + ", pais=" + pais + "]";
	}

}
