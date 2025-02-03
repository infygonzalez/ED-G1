package Modelo_Utils;

public class SQLQuerys {
	// SELECTS
	public static final String SELECT_COMPROBAR_AGENCIA = "SELECT * FROM Agencia WHERE Nombre = ? AND Contraseña = ?";
	public static final String SELECT_VIAJES = "SELECT v.Nom_Via, v.Tipo_Viaje, v.Duracion_Via, v.Fec_Ini, v.Fec_Fin, p.pais AS Pais "
			+ "FROM viajes v " + "JOIN codigopaises p ON v.pais = p.pais";

	public static final String SELECT_PAIS =  "SELECT pais, codigo FROM codigopaises WHERE pais = ?";
	
	public static final String SELECT_ALOJAMIENTO = "Select Nom_Hotel, Fec_Ent, Fec_Sal, Precio FROM alojamiento ";
	public static final String SELECT_OTROS = "Select Nombre,Fecha, Precio FROM otros ";
	public static final String SELECT_VUELOSIDA = "Select Nombre,Fec_Sal, Precio FROM Vuelos_Ida WHERE IdaVuelta = 'Ida' ";
	public static final String SELECT_VUELOSVUELTA = "SELECT Nombre, Fec_Sal, Precio FROM Vuelos_Ida where IdaVuelta = 'Ida y Vuelta'";

	
	// INSERTS
	public static final String INSERT_NUEVA_AGENCIA = "INSERT INTO agencia (nombre, logo, Col_Marca, Num_Emp, Tipo_Agencia, Contraseña) VALUES (?, ?, ?, ?, ?, ?)";

	public static final String END_BLOCK = "')";
	public static final String SEPARATOR = "', '";
	
	//DELETES
	
	public static final String DELETE_VIAJES = "DELETE FROM Viajes WHERE ID_Viaje = ?";


}
