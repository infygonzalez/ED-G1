package Modelo_Utils;

public class SQLQuerys {
	// SELECTS
	public static final String SELECT_COMPROBAR_AGENCIA = "SELECT * FROM Agencia WHERE Nombre = ? AND Contraseña = ?";
	public static final String SELECT_VIAJES = "SELECT v.Id_viaje, v.Nom_Via, v.Tipo_Viaje, v.Duracion_Via, v.Fec_Ini, v.Fec_Fin, p.pais AS Pais "
			+ "FROM viajes v "
			+ "JOIN codigopaises p ON v.pais = p.pais"
			+ "WHERE v.id = ?;";

	public static final String SELECT_PAIS = "SELECT pais, codigo FROM codigopaises WHERE pais = ?";

	public static final String SELECT_ALOJAMIENTO = "Select * FROM alojamiento ";
	public static final String SELECT_OTROS = "Select * FROM otros ";
	public static final String SELECT_VUELOSIDA = "Select * FROM Vuelos WHERE IdaVuelta = 'Ida' ";
	public static final String SELECT_VUELOSVUELTA = "SELECT * FROM Vuelos where IdaVuelta = 'Ida y Vuelta'";

	// INSERTS
	public static final String INSERT_NUEVA_AGENCIA = "INSERT INTO agencia (nombre, logo, Col_Marca, Num_Emp, Tipo_Agencia, Contraseña) VALUES (?, ?, ?, ?, ?, ?)";

	public static final String END_BLOCK = "')";
	public static final String SEPARATOR = "', '";

	// DELETES

	public static final String DELETE_VIAJES = "DELETE FROM Viajes WHERE ID_Viaje = ?";
	public static final String DELETE_ALOJAMIENTOS = "";
	public static final String DELETE_OTROS = "";
	public static final String DELETE_VUELOS = "";

}
