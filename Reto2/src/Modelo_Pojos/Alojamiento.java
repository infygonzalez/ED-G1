package Modelo_Pojos;

public class Alojamiento extends Evento {

	private int id;
    private String nombreHotel;
    private String ciudad;
    private float precio;
    private String fechaEntrada;
    private String fechaSalida;
    private String tipoHabitacion;
    private Viaje viajes;
    
    public Alojamiento() {
    	super("");  
    	this.id=0;
        this.nombreHotel = "";
        this.ciudad = "";
        this.precio = 0;
        this.fechaEntrada = "";
        this.fechaSalida = "";
        this.tipoHabitacion = "";
        this.viajes = null;
    }

    // Constructor extendiendo la clase Evento
    public Alojamiento(int id,String tipoEvento, String nombreHotel, String ciudad, float precio, String fechaEntrada,
            String fechaSalida, String tipoHabitacion, Viaje viajes) {
        super(tipoEvento);  // Llamada al constructor de Evento
        this.id=id;
        this.nombreHotel = nombreHotel;
        this.ciudad = ciudad;
        this.precio = precio;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.tipoHabitacion = tipoHabitacion;
        this.viajes = viajes;
    }

    // Getters y setters
    
    public String getNombreHotel() {
        return nombreHotel;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

    public Viaje getViajes() {
        return viajes;
    }

    public void setViajes(Viaje viajes) {
        this.viajes = viajes;
    }

	@Override
	public String toString() {
		return "Alojamiento [id=" + id + ", nombreHotel=" + nombreHotel + ", ciudad=" + ciudad + ", precio=" + precio
				+ ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", tipoHabitacion="
				+ tipoHabitacion + ", viajes=" + viajes + "]";
	}

   
}
