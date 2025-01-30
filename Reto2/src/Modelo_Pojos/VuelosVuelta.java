package Modelo_Pojos;

public class VuelosVuelta extends VuelosIda {

	private String fechaVuelta;
	private String horaVuelta;
	private String duracionVuelta;

	public VuelosVuelta(int codigoVuelo, float precio, String aerolinea, String fechaSalida, String horaSalida,
			String duracion, Viaje viajes, IATAS salida, IATAS destino, String fechaVuelta, String horaVuelta,
			String duracionVuelta) {
		super(codigoVuelo, precio, aerolinea, fechaSalida, horaSalida, duracion, viajes, salida, destino);
		this.fechaVuelta = fechaVuelta;
		this.horaVuelta = horaVuelta;
		this.duracionVuelta = duracionVuelta;
	}

	public String getFechaVuelta() {
		return fechaVuelta;
	}

	public void setFechaVuelta(String fechaVuelta) {
		this.fechaVuelta = fechaVuelta;
	}

	public String getHoraVuelta() {
		return horaVuelta;
	}

	public void setHoraVuelta(String horaVuelta) {
		this.horaVuelta = horaVuelta;
	}

	public String getDuracionVuelta() {
		return duracionVuelta;
	}

	public void setDuracionVuelta(String duracionVuelta) {
		this.duracionVuelta = duracionVuelta;
	}

	@Override
	public String toString() {
		return "VuelosVuelta [fechaVuelta=" + fechaVuelta + ", horaVuelta=" + horaVuelta + ", duracionVuelta="
				+ duracionVuelta + "]";
	}

}
