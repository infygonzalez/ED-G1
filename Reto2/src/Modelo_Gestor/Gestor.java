package Modelo_Gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelo_Pojos.Agencia;
import Modelo_Pojos.Alojamiento;
import Modelo_Pojos.Evento;
import Modelo_Pojos.Otros;
import Modelo_Pojos.Pais;
import Modelo_Pojos.Viaje;
import Modelo_Pojos.VuelosIda;
import Modelo_Pojos.VuelosVuelta;
import Modelo_Utils.DBUtils;
import Modelo_Utils.SQLQuerys;

public class Gestor {

	public static Agencia comprobarAgencias(String nombre, String contraseña) {
		Agencia ret = null;
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;
		try {

			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			String sql = SQLQuerys.SELECT_COMPROBAR_AGENCIA;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, nombre);
			sentencia.setString(2, contraseña);
			
			resultSet = sentencia.executeQuery();

			if (resultSet.next()) {
				ret = new Agencia();
				ret.setId(resultSet.getInt("id"));
				ret.setLogo(resultSet.getString("Logo"));
				ret.setNombre(resultSet.getString("nombre"));
				ret.setColorMarca(resultSet.getString("Col_marca"));
				ret.setContraseña(resultSet.getString("contraseña"));
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos: " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error inesperado: " + e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (sentencia != null) {
					sentencia.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (Exception e) {
				System.out.println("Error al cerrar recursos: " + e.getMessage());
			}
		}
		return ret;
	}

	public static boolean crearAgencia(Agencia agencia) {
		Connection conexion = null;
		PreparedStatement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = SQLQuerys.INSERT_NUEVA_AGENCIA;
			sentencia = conexion.prepareStatement(sql);

			sentencia.setString(1, agencia.getNombre());
			sentencia.setString(2, agencia.getLogo());
			sentencia.setString(3, agencia.getColorMarca());
			sentencia.setString(4, agencia.getNumeroEmpleados());
			sentencia.setString(5, agencia.getTipoAgencia());
			sentencia.setString(6, agencia.getContraseña());

			int filasAfectadas = sentencia.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("Agencia registrada correctamente.");
				return true;
			} else {
				System.out.println("Error al insertar la agencia.");
				return false;
			}
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
			} catch (Exception e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
		}
	}

	public static boolean existeAgencia(String nombre) {
		boolean existe = false;
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			String sql = "SELECT COUNT(*) FROM agencia WHERE nombre = ?";
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, nombre);
			resultSet = sentencia.executeQuery();

			if (resultSet.next() && resultSet.getInt(1) > 0) {
				existe = true;
			}
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos: " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error inesperado: " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (sentencia != null)
					sentencia.close();
				if (conexion != null)
					conexion.close();
			} catch (Exception e) {
				System.out.println("Error al cerrar recursos: " + e.getMessage());
			}
		}
		return existe;
	}

	

}
