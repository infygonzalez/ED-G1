package Modelo_Utils;

public class SQLQuerys {
	// SELECTS
	public static final String SELECT_COMPROBAR_AGENCIA = "SELECT * FROM agencias WHERE nombre = ? AND contraseña = ?";
	// INSERTS
	public static final String INSERT_NUEVA_AGENCIA = "Insert into agencias (nombre, logo, Col_Marca,Num_Emp,Tipo_Agencia, Contraseña) values ('";

	public static final String END_BLOCK = "')";
	public static final String SEPARATOR = "', '";

}
