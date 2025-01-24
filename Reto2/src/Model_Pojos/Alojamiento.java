package Model_Pojos;

import java.util.ArrayList;

public class Alojamiento {
	
	private String nombreHotel;
	private String ciudad;
	private float precio;
	private String fechaEntrada;
	private String fechaSalida;
	private String tipoHabitacion;
	private ArrayList <Alojamiento> alojamiento = new ArrayList<>();
	
	
	
	
	public Alojamiento(String nombreHotel, String ciudad, float precio, String fechaEntrada, String fechaSalida,
			String tipoHabitacion, ArrayList<Alojamiento> alojamiento) {
		this.nombreHotel = nombreHotel;
		this.ciudad = ciudad;
		this.precio = precio;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.tipoHabitacion = tipoHabitacion;
		this.alojamiento = alojamiento;
	}
	
	
	public String getNombreHotel() {
		return nombreHotel;
	}
	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getTipoHabitacion() {
		return tipoHabitacion;
	}
	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	public ArrayList<Alojamiento> getAlojamiento() {
		return alojamiento;
	}
	public void setAlojamiento(ArrayList<Alojamiento> alojamiento) {
		this.alojamiento = alojamiento;
	}


	@Override
	public String toString() {
		return "Alojamiento [nombreHotel=" + nombreHotel + ", ciudad=" + ciudad + ", precio=" + precio
				+ ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", tipoHabitacion="
				+ tipoHabitacion + ", alojamiento=" + alojamiento + "]";
	}
	
	
	
	
}
