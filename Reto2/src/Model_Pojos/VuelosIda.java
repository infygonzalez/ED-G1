package Model_Pojos;

public class VuelosIda {

	private int codigoVuelo;
	private float precio;
	private String aerolinea;
	private String fechaSalida;
	private String horaSalida;
	private String duracion;
	private Viajes viajes;
	private IATAS salida;
	private IATAS destino;

	public VuelosIda(int codigoVuelo, float precio, String aerolinea, String fechaSalida, String horaSalida,
			String duracion, Viajes viajes, IATAS salida, IATAS destino) {
		super();
		this.codigoVuelo = codigoVuelo;
		this.precio = precio;
		this.aerolinea = aerolinea;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.duracion = duracion;
		this.viajes = viajes;
		this.salida = salida;
		this.destino = destino;
	}

	public int getCodigoVuelo() {
		return codigoVuelo;
	}

	public void setCodigoVuelo(int codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public Viajes getViajes() {
		return viajes;
	}

	public void setViajes(Viajes viajes) {
		this.viajes = viajes;
	}

	public IATAS getSalida() {
		return salida;
	}

	public void setSalida(IATAS salida) {
		this.salida = salida;
	}

	public IATAS getDestino() {
		return destino;
	}

	public void setDestino(IATAS destino) {
		this.destino = destino;
	}

	@Override
	public String toString() {
		return "VuelosIda [codigoVuelo=" + codigoVuelo + ", precio=" + precio + ", aerolinea=" + aerolinea
				+ ", fechaSalida=" + fechaSalida + ", horaSalida=" + horaSalida + ", duracion=" + duracion + ", viajes="
				+ viajes + ", salida=" + salida + ", destino=" + destino + "]";
	}

}
