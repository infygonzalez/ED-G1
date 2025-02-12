package Modelo_Pojos;

public class IATAS {
	private String Aeropuerto;
	private String Codigo;
	
	
	public IATAS(String aeropuerto) {
		Aeropuerto = aeropuerto;
		Codigo = "";
	}

	public IATAS(String aeropuerto, String codigo) {
		super();
		Aeropuerto = aeropuerto;
		Codigo = codigo;
		
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

	

	

	@Override
	public String toString() {
		return "IATAS [Aeropuerto=" + Aeropuerto + ", Codigo=" + Codigo + "]";
	}

}
