package Modelo_Pojos;

import java.util.ArrayList;

public class Viaje {

	private String NombreViaje;
	private String Descripcion;
	private String TipoViaje;
	private String FechaInicio;
	private String FechaFin;
	private String DuracionViaje;
	private String ServiciosNoIncluidos;
	private Pais Pais;
	private Agencia agencia;
	private ArrayList<Alojamiento> alojamiento;
	private ArrayList<Otros> otros;
	private ArrayList<VuelosIda> vuelosIda;

	public Viaje() {
		NombreViaje = "";
		Descripcion = "";
		TipoViaje = "";
		FechaInicio = "";
		FechaFin = "";
		DuracionViaje = "";
		ServiciosNoIncluidos = "";
		Pais = null;
		this.agencia = null;
		this.alojamiento = null;
		this.otros = null;
		this.vuelosIda = null;
	}
	
	public Viaje(String nombreViaje, String descripcion, String tipoViaje, String fechaInicio, String fechaFin,
			String duracionViaje, String serviciosNoIncluidos, Pais pais, Agencia agencia,
			ArrayList<Alojamiento> alojamiento, ArrayList<Otros> otros, ArrayList<VuelosIda> vuelosIda) {
		super();
		NombreViaje = nombreViaje;
		Descripcion = descripcion;
		TipoViaje = tipoViaje;
		FechaInicio = fechaInicio;
		FechaFin = fechaFin;
		DuracionViaje = duracionViaje;
		ServiciosNoIncluidos = serviciosNoIncluidos;
		Pais = pais;
		this.agencia = agencia;
		this.alojamiento = alojamiento;
		this.otros = otros;
		this.vuelosIda = vuelosIda;
	}

	public String getNombreViaje() {
		return NombreViaje;
	}

	public void setNombreViaje(String nombreViaje) {
		NombreViaje = nombreViaje;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getTipoViaje() {
		return TipoViaje;
	}

	public void setTipoViaje(String tipoViaje) {
		TipoViaje = tipoViaje;
	}

	public String getFechaInicio() {
		return FechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		FechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return FechaFin;
	}

	public void setFechaFin(String fechaFin) {
		FechaFin = fechaFin;
	}

	public String getDuracionViaje() {
		return DuracionViaje;
	}

	public void setDuracionViaje(String duracionViaje) {
		DuracionViaje = duracionViaje;
	}

	public String getServiciosNoIncluidos() {
		return ServiciosNoIncluidos;
	}

	public void setServiciosNoIncluidos(String serviciosNoIncluidos) {
		ServiciosNoIncluidos = serviciosNoIncluidos;
	}

	public Pais getPais() {
		return Pais;
	}

	public void setPais(Pais pais) {
		Pais = pais;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public ArrayList<Alojamiento> getAlojamiento() {
		return alojamiento;
	}

	public void setAlojamiento(ArrayList<Alojamiento> alojamiento) {
		this.alojamiento = alojamiento;
	}

	public ArrayList<Otros> getOtros() {
		return otros;
	}

	public void setOtros(ArrayList<Otros> otros) {
		this.otros = otros;
	}

	public ArrayList<VuelosIda> getVuelosIda() {
		return vuelosIda;
	}

	public void setVuelosIda(ArrayList<VuelosIda> vuelosIda) {
		this.vuelosIda = vuelosIda;
	}

	@Override
	public String toString() {
		return "Viajes [NombreViaje=" + NombreViaje + ", Descripcion=" + Descripcion + ", TipoViaje=" + TipoViaje
				+ ", FechaInicio=" + FechaInicio + ", FechaFin=" + FechaFin + ", DuracionViaje=" + DuracionViaje
				+ ", ServiciosNoIncluidos=" + ServiciosNoIncluidos + ", Pais=" + Pais + ", agencia=" + agencia
				+ ", alojamiento=" + alojamiento + "]";
	}

}
