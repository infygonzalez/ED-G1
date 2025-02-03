package Modelo_Pojos;

public class Evento {

	private String tipoEvento;

	public Evento() {
		super();
		this.tipoEvento = "";
	}

	public Evento(String tipoEvento) {
		super();
		this.tipoEvento = tipoEvento;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	@Override
	public String toString() {
		return "Evento [tipoEvento=" + tipoEvento + "]";
	}

}
