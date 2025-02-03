package Modelo_Pojos;

public class Alojamiento extends Evento {

    private String nombreHotel;
    private String ciudad;
    private float precio;
    private String fechaEntrada;
    private String fechaSalida;
    private String tipoHabitacion;
    private Viaje viajes;

    // Constructor extendiendo la clase Evento
    public Alojamiento(String tipoEvento, String nombreHotel, String ciudad, float precio, String fechaEntrada,
            String fechaSalida, String tipoHabitacion, Viaje viajes) {
        super(tipoEvento);  // Llamada al constructor de Evento
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
        return super.toString() + " | Alojamiento [nombreHotel=" + nombreHotel + ", ciudad=" + ciudad + ", precio=" + precio
                + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", tipoHabitacion=" + tipoHabitacion
                + ", viajes=" + viajes + "]";
    }
}
