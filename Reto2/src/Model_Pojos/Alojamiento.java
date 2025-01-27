package Model_Pojos;

public class Alojamiento extends Evento {

	private String nombreHotel;
	private double precio;

	public Alojamiento(int id, String nombre, String descripcion, String nombreHotel, double precio) {
		super(id, nombre, descripcion);
		this.nombreHotel = nombreHotel;
		this.precio = precio;
	}

	public String getNombreHotel() {
		return nombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Alojamiento [nombreHotel=" + nombreHotel + ", precio=" + precio + "]";
	}

}
