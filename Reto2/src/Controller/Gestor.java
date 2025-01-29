package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model_Pojos.Agencia;
import Model_utils.DBUtils;
import Model_utils.SQLQuerys;

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
				ret.setNombre(resultSet.getString("nombre"));
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

	public static void crearAgencia(Agencia agencia) {
		Connection conexion = null;
		Statement sentencia = null;
		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			sentencia = conexion.createStatement();
			String sql = SQLQuerys.INSERT_NUEVA_AGENCIA +  agencia.getNombre()+ SQLQuerys.SEPARATOR + agencia.getLogo() + SQLQuerys.SEPARATOR 
					+ agencia.getColorMarca() + SQLQuerys.SEPARATOR + agencia.getNumeroEmpleados() + SQLQuerys.SEPARATOR + agencia.getTipoAgencia() 
					+ SQLQuerys.SEPARATOR + agencia.getContraseña() + SQLQuerys.END_BLOCK;
			sentencia.executeUpdate(sql);
		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error genérico " + e.getMessage());
		}
		try {
			if (sentencia != null) {
				sentencia.close();
			}
		} catch (Exception e) {
			System.out.println("Sentencia nula");
		}
		try {
			if (conexion != null) {
				conexion.close();
			}
		} catch (Exception e) {
			System.out.println("Conexión nula");
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
	        String sql = "SELECT COUNT(*) FROM agencias WHERE nombre = ?";
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
	            if (resultSet != null) resultSet.close();
	            if (sentencia != null) sentencia.close();
	            if (conexion != null) conexion.close();
	        } catch (Exception e) {
	            System.out.println("Error al cerrar recursos: " + e.getMessage());
	        }
	    }
	    return existe;
	}

}
