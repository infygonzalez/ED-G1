package Modelo_Pojos;

public class Otros extends Evento {

	private int id;
    private String nombre;
    private String fecha;
    private String descripcion;
    private float precio;
    private String nombreViaje;
    private Viaje viajes;
    private Evento evento;  
    
    public Otros() {
    	super("");  
    	this.id=0;
        this.nombre = "";
        this.fecha = "";
        this.descripcion = "";
        this.precio = 0;
        this.nombreViaje = "";
        this.viajes = null;
        this.evento = null;
    }

    // Constructor
    public Otros(int id,String nombre, String fecha, String descripcion, float precio, String nombreViaje, Viaje viajes, Evento evento) {
        super(evento.getTipoEvento()); 
        this.id=id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombreViaje = nombreViaje;
        this.viajes = viajes;
        this.evento = evento;  
    }

    // Getters y setters
    
    public Evento getEvento() {
        return evento;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getNombreViaje() {
        return nombreViaje;
    }

    public void setNombreViaje(String nombreViaje) {
        this.nombreViaje = nombreViaje;
    }

    public Viaje getViajes() {
        return viajes;
    }

    public void setViajes(Viaje viajes) {
        this.viajes = viajes;
    }

	@Override
	public String toString() {
		return "Otros [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", nombreViaje=" + nombreViaje + ", viajes=" + viajes + ", evento=" + evento
				+ "]";
	}

    
}
