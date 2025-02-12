package Modelo_Gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelo_Pojos.Agencia;
import Modelo_Pojos.Alojamiento;
import Modelo_Pojos.CompañiasAereas;
import Modelo_Pojos.IATAS;
import Modelo_Pojos.Otros;
import Modelo_Pojos.Pais;
import Modelo_Pojos.Viaje;
import Modelo_Pojos.VuelosIda;
import Modelo_Pojos.VuelosVuelta;
import Modelo_Utils.DBUtils;

public class GestorEvento {

	public static boolean crearOtro(Viaje viaje, Otros otro) {

		if (existeOtro(otro)) {
			System.out.println("El Evento ya existe.");
			return false;
		}

		Connection conexion = null;
		PreparedStatement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "INSERT INTO otros (Nombre, Fecha, Descripcion, Precio, id_viaje) VALUES (?, ?, ?, ?, ?)";

			sentencia = conexion.prepareStatement(sql);

			sentencia.setString(1, otro.getNombre());
			sentencia.setString(2, otro.getFecha());
			sentencia.setString(3, otro.getDescripcion());
			sentencia.setDouble(4, otro.getPrecio());
			sentencia.setInt(5, viaje.getId());

			int filasAfectadas = sentencia.executeUpdate();
			return filasAfectadas > 0;

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos: " + sqle.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println("Error inesperado: " + e.getMessage());
			return false;
		} finally {
			try {
				if (sentencia != null)
					sentencia.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
		}
	}

	public static boolean existeOtro(Otros otro) {
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet rs = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "SELECT COUNT(*) FROM otros WHERE Nombre = ? AND Fecha = ?";
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, otro.getNombre());
			sentencia.setDate(2, java.sql.Date.valueOf(otro.getFecha()));

			rs = sentencia.executeQuery();

			if (rs.next()) {
				return rs.getInt(1) > 0;
			}

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos: " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error inesperado: " + e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (sentencia != null)
					sentencia.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
		}

		return false;
	}

	public static boolean crearVueloIda(Viaje viaje, VuelosIda vuelo) {
		Connection conexion = null;
		PreparedStatement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "INSERT INTO Vuelos (CodigoVuelo, Nombre, Origen, Destino, Precio, Aerolinea, Fec_Sal, Hora_Sal, Duracion, IdaVuelta, ID_Viaje)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			sentencia = conexion.prepareStatement(sql);

			sentencia.setInt(1, vuelo.getCodigoVuelo());
			sentencia.setString(2, vuelo.getNombre());
			sentencia.setString(3, vuelo.getSalida().getAeropuerto());
			sentencia.setString(4, vuelo.getDestino().getAeropuerto());
			sentencia.setFloat(5, vuelo.getPrecio());
			sentencia.setString(6, vuelo.getAerolinea());
			sentencia.setString(7, vuelo.getFechaSalida());
			sentencia.setString(8, vuelo.getHoraSalida());
			sentencia.setString(9, vuelo.getDuracion());
			sentencia.setString(10, "Ida");
			sentencia.setInt(11, viaje.getId());

			int filasAfectadas = sentencia.executeUpdate();
			return filasAfectadas > 0;

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos: " + sqle.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println("Error inesperado: " + e.getMessage());
			return false;
		} finally {
			try {
				if (sentencia != null)
					sentencia.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
		}
	}

	public static boolean crearVueloVuelta(Viaje viaje, VuelosVuelta vuelo) {
		Connection conexion = null;
		PreparedStatement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "INSERT INTO Vuelos (CodigoVuelo, Nombre, Origen, Destino, Precio, Aerolinea, Fec_Sal, Hora_Sal, Duracion, IdaVuelta, Fec_Vuelta, Dur_Vuelta, ID_Viaje)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

			sentencia = conexion.prepareStatement(sql);

			sentencia.setInt(1, vuelo.getCodigoVuelo());
			sentencia.setString(2, vuelo.getNombre());
			sentencia.setString(3, vuelo.getSalida().getAeropuerto());
			sentencia.setString(4, vuelo.getDestino().getAeropuerto());
			sentencia.setFloat(5, vuelo.getPrecio());
			sentencia.setString(6, vuelo.getAerolinea());
			sentencia.setString(7, vuelo.getFechaSalida());
			sentencia.setString(8, vuelo.getHoraSalida());
			sentencia.setString(9, vuelo.getDuracion());
			sentencia.setString(10, "Ida y vuelta");
			sentencia.setString(11, vuelo.getFechaVuelta());
			sentencia.setString(12, vuelo.getDuracionVuelta());
			sentencia.setInt(13, viaje.getId());

			int filasAfectadas = sentencia.executeUpdate();
			return filasAfectadas > 0;

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos: " + sqle.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println("Error inesperado: " + e.getMessage());
			return false;
		} finally {
			try {
				if (sentencia != null)
					sentencia.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
		}
	}

	public static ArrayList<IATAS> obtenerAeropuerto() {
		ArrayList<IATAS> aeropuertos = new ArrayList<>();
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet rs = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			// Seleccionamos tanto el nombre como el codigo del país
			String sql = "SELECT codigo, pais FROM codigopaises";

			sentencia = conexion.prepareStatement(sql);
			rs = sentencia.executeQuery();

			while (rs.next()) {
				String codigoAeropuerto = rs.getString("codigo");
				String nombreAeropuerto = rs.getString("pais");
				aeropuertos.add(new IATAS(codigoAeropuerto, nombreAeropuerto));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (sentencia != null)
					sentencia.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return aeropuertos;
	}

	public static ArrayList<CompañiasAereas> obtenerCompañiaAerea() {
		ArrayList<CompañiasAereas> compañias = new ArrayList<>();
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet rs = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			// Seleccionamos tanto el nombre como el codigo del país
			String sql = "SELECT codigo, nombre FROM codigocompañiasaereas";

			sentencia = conexion.prepareStatement(sql);
			rs = sentencia.executeQuery();

			while (rs.next()) {
				String codigo = rs.getString("codigo");
				String nombre = rs.getString("nombre");
				compañias.add(new CompañiasAereas(codigo, nombre));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (sentencia != null)
					sentencia.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return compañias;
	}

	public static boolean obtenerAlojamiento(Viaje viaje, Alojamiento alojamiento) {
		Connection conexion = null;
        PreparedStatement sentencia = null;

        try {
            Class.forName(DBUtils.DRIVER);
            conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

            String sql = "INSERT INTO Alojamiento (ID_Alojamiento, Nom_Hotel, Ciudad, Precio, Fec_Ent, Fec_Sal, Tip_Hab, Id_Viaje) VALUES (?,?,?,?,?,?,?,?)";
        

            sentencia = conexion.prepareStatement(sql);

            sentencia.setInt(1, alojamiento.getId());
            sentencia.setString(2, alojamiento.getNombreHotel());
            sentencia.setString(3, alojamiento.getCiudad());
            sentencia.setFloat(4, alojamiento.getPrecio());
            sentencia.setString(5, alojamiento.getFechaEntrada());
            sentencia.setString(6, alojamiento.getFechaSalida());
            sentencia.setString(7, alojamiento.getTipoHabitacion());
            sentencia.setInt(8, viaje.getId());
            

            int filasAfectadas = sentencia.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException sqle) {
            System.out.println("Error con la base de datos: " + sqle.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
            return false;
        } finally {
            try {
                if (sentencia != null) sentencia.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }

	}

}
