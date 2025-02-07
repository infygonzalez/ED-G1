package Modelo_Utils;

public class SQLQuerys {
	// SELECTS
	public static final String SELECT_COMPROBAR_AGENCIA = "SELECT id,logo, Nombre, Contraseña FROM Agencia WHERE Nombre = ? AND Contraseña = ?";
	public static final String SELECT_VIAJES = "SELECT * FROM Viajes WHERE id = ?";
	public static final String SELECT_PAIS = "SELECT pais, codigo FROM codigopaises WHERE pais = ?";

	public static final String SELECT_ALOJAMIENTO = "SELECT * FROM alojamiento JOIN agencia a WHERE id = ?";

	public static final String SELECT_OTROS = "SELECT * FROM otros WHERE id_viaje = ?";
	public static final String SELECT_VUELOSIDA = "SELECT * FROM Vuelos WHERE IdaVuelta = 'ida' AND id_viaje = ?";
	public static final String SELECT_VUELOSVUELTA = "SELECT * FROM Vuelos WHERE IdaVuelta = 'ida y vuelta' AND id_viaje = ?";

	// INSERTS
	public static final String INSERT_NUEVA_AGENCIA = "INSERT INTO agencia (nombre, logo, Col_Marca, Num_Emp, Tipo_Agencia, Contraseña) VALUES (?, ?, ?, ?, ?, ?)";
	public static final String INSERT_NUEVO_VIAJE = "";


	public static final String END_BLOCK = "')";
	public static final String SEPARATOR = "', '";

	// DELETES

	public static final String DELETE_VIAJES = "DELETE FROM Viajes WHERE id_viaje = ?";
	public static final String DELETE_ALOJAMIENTOS = "DELETE FROM Alojamiento WHERE id_alojamiento = ?";
	public static final String DELETE_VUELOS = "DELETE FROM Vuelos WHERE codigovuelo = ?";
	public static final String DELETE_OTROS = "DELETE FROM Otros WHERE id_otro = ?";

}
