package Model_Pojos;

public class VueloIda {
	private String origen;
	private String destino;
	private String aerolinea;

	public VueloIda(String origen, String destino, String aerolinea) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.aerolinea = aerolinea;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	@Override
	public String toString() {
		return "VueloIda [origen=" + origen + ", destino=" + destino + ", aerolinea=" + aerolinea + "]";
	}

}
