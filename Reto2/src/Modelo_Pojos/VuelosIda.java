package Modelo_Pojos;

public class VuelosIda extends Evento {

    private int codigoVuelo;
    private float precio;
    private String aerolinea;
    private String fechaSalida;
    private String horaSalida;
    private String duracion;
    private Viaje viajes;
    private IATAS salida;
    private IATAS destino;
    private String nombre;

    public VuelosIda() {
    	super("");
    	 this.codigoVuelo = 0;
         this.precio = 0;
         this.aerolinea = null;
         this.fechaSalida = null;
         this.horaSalida = null;
         this.duracion = null;
         this.viajes = null;
         this.salida = null;
         this.destino = null;
         this.nombre=null;
    }
    
    
    // Constructor extendiendo la clase Evento
    public VuelosIda(String tipoEvento, int codigoVuelo, float precio, String aerolinea, String fechaSalida, String horaSalida,
                     String duracion, Viaje viajes, IATAS salida, IATAS destino, String nombre) {
        super(tipoEvento);  // Llamada al constructor de Evento con tipoEvento
        this.codigoVuelo = codigoVuelo;
        this.precio = precio;
        this.aerolinea = aerolinea;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.duracion = duracion;
        this.viajes = viajes;
        this.salida = salida;
        this.destino = destino;
        this.nombre=nombre;
    }

    
    // Getters y setters
    
    
    public int getCodigoVuelo() {
        return codigoVuelo;
    }

    public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
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

    public Viaje getViajes() {
        return viajes;
    }

    public void setViajes(Viaje viajes) {
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
        return super.toString() + " | VuelosIda [codigoVuelo=" + codigoVuelo + ", precio=" + precio + ", aerolinea=" + aerolinea
                + ", fechaSalida=" + fechaSalida + ", horaSalida=" + horaSalida + ", duracion=" + duracion + ", viajes=" + viajes
                + ", salida=" + salida + ", destino=" + destino + "]";
    }
}
