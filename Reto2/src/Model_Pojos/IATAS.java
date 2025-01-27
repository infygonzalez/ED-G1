package Model_Pojos;

public class IATAS {
	private String Aeropuerto;
	private String Codigo;
	private Pais pais;
	private VuelosIda salida;
	private VuelosIda destino;

	public IATAS(String aeropuerto, String codigo, Pais pais, VuelosIda salida, VuelosIda destino) {
		super();
		Aeropuerto = aeropuerto;
		Codigo = codigo;
		this.pais = pais;
		this.salida = salida;
		this.destino = destino;
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

	public VuelosIda getSalida() {
		return salida;
	}

	public void setSalida(VuelosIda salida) {
		this.salida = salida;
	}

	public VuelosIda getDestino() {
		return destino;
	}

	public void setDestino(VuelosIda destino) {
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "IATAS [Aeropuerto=" + Aeropuerto + ", Codigo=" + Codigo + ", pais=" + pais + "]";
	}

}
