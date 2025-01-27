package Model_Pojos;

public class CodigoIATA {

	private String codigo;

	public CodigoIATA(String codigo) {
		super();
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "CodigoIATA [codigo=" + codigo + "]";
	}

}
