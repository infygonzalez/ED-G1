package Model_Pojos;

public class Otros extends Evento {
	private String detalles;

	public Otros(int id, String nombre, String descripcion, String detalles) {
		super(id, nombre, descripcion);
		this.detalles = detalles;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Otros [detalles=" + detalles + "]";
	}

}
