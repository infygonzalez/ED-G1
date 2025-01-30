package Modelo_Pojos;

public class Pais {

	private String pais;
	private String codigo;

	private Viaje viajes;
	private IATAS iatas;

	public Pais(String pais, String codigo, Viaje viajes, IATAS iatas) {
		super();
		this.pais = pais;
		this.codigo = codigo;
		this.viajes = viajes;
		this.iatas = iatas;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Viaje getViajes() {
		return viajes;
	}

	public void setViajes(Viaje viajes) {
		this.viajes = viajes;
	}

	public IATAS getIatas() {
		return iatas;
	}

	public void setIatas(IATAS iatas) {
		this.iatas = iatas;
	}

	@Override
	public String toString() {
		return "Pais [pais=" + pais + ", codigo=" + codigo + ", viajes=" + viajes + ", iatas=" + iatas + "]";
	}

}
