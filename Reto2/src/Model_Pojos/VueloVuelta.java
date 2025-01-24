package Model_Pojos;

import java.util.ArrayList;

public class VueloVuelta {

	private String aeropuertoOrigen;
	private String codigoAeroOrigen;
	private String aeropuertoDestino;
	private String codigoAeroDestino;
	private int codigoVuelo;
	private String aerolinea;
	private float precio;
	private String fechaSalida;
	private String horarioSalida;
	private String duracionViaje;
	private String fechaVuelta;
	private String horaVuelta;
	private String duracionVuelta;
	private ArrayList<VueloVuelta> vueloVuelta = new ArrayList<>();

	public VueloVuelta(String aeropuertoOrigen, String codigoAeroOrigen, String aeropuertoDestino,
			String codigoAeroDestino, int codigoVuelo, String aerolinea, float precio, String fechaSalida,
			String horarioSalida, String duracionViaje, String fechaVuelta, String horaVuelta, String duracionVuelta,
			ArrayList<VueloVuelta> vueloVuelta) {
		super();
		this.aeropuertoOrigen = aeropuertoOrigen;
		this.codigoAeroOrigen = codigoAeroOrigen;
		this.aeropuertoDestino = aeropuertoDestino;
		this.codigoAeroDestino = codigoAeroDestino;
		this.codigoVuelo = codigoVuelo;
		this.aerolinea = aerolinea;
		this.precio = precio;
		this.fechaSalida = fechaSalida;
		this.horarioSalida = horarioSalida;
		this.duracionViaje = duracionViaje;
		this.fechaVuelta = fechaVuelta;
		this.horaVuelta = horaVuelta;
		this.duracionVuelta = duracionVuelta;
		this.vueloVuelta = vueloVuelta;
	}

	public String getAeropuertoOrigen() {
		return aeropuertoOrigen;
	}

	public void setAeropuertoOrigen(String aeropuertoOrigen) {
		this.aeropuertoOrigen = aeropuertoOrigen;
	}

	public String getCodigoAeroOrigen() {
		return codigoAeroOrigen;
	}

	public void setCodigoAeroOrigen(String codigoAeroOrigen) {
		this.codigoAeroOrigen = codigoAeroOrigen;
	}

	public String getAeropuertoDestino() {
		return aeropuertoDestino;
	}

	public void setAeropuertoDestino(String aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}

	public String getCodigoAeroDestino() {
		return codigoAeroDestino;
	}

	public void setCodigoAeroDestino(String codigoAeroDestino) {
		this.codigoAeroDestino = codigoAeroDestino;
	}

	public int getCodigoVuelo() {
		return codigoVuelo;
	}

	public void setCodigoVuelo(int codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getHorarioSalida() {
		return horarioSalida;
	}

	public void setHorarioSalida(String horarioSalida) {
		this.horarioSalida = horarioSalida;
	}

	public String getDuracionViaje() {
		return duracionViaje;
	}

	public void setDuracionViaje(String duracionViaje) {
		this.duracionViaje = duracionViaje;
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

	public ArrayList<VueloVuelta> getVueloVuelta() {
		return vueloVuelta;
	}

	public void setVueloVuelta(ArrayList<VueloVuelta> vueloVuelta) {
		this.vueloVuelta = vueloVuelta;
	}

	@Override
	public String toString() {
		return "VueloVuelta [aeropuertoOrigen=" + aeropuertoOrigen + ", codigoAeroOrigen=" + codigoAeroOrigen
				+ ", aeropuertoDestino=" + aeropuertoDestino + ", codigoAeroDestino=" + codigoAeroDestino
				+ ", codigoVuelo=" + codigoVuelo + ", aerolinea=" + aerolinea + ", precio=" + precio + ", fechaSalida="
				+ fechaSalida + ", horarioSalida=" + horarioSalida + ", duracionViaje=" + duracionViaje
				+ ", fechaVuelta=" + fechaVuelta + ", horaVuelta=" + horaVuelta + ", duracionVuelta=" + duracionVuelta
				+ ", vueloVuelta=" + vueloVuelta + "]";
	}

}
