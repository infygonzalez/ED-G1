package Model_Pojos;

import java.util.ArrayList;

public class Pais {

	private String codigo;
	private String descripcion;
	private ArrayList<Pais> pais = new ArrayList<>();

	public Pais(String codigo, String descripcion, ArrayList<Pais> pais) {
		
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.pais = pais;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ArrayList<Pais> getPais() {
		return pais;
	}

	public void setPais(ArrayList<Pais> pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Pais [codigo=" + codigo + ", descripcion=" + descripcion + ", pais=" + pais + "]";
	}

}
