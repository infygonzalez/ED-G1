package Modelo_Gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo_Pojos.Agencia;
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
		    PreparedStatement sentencia = null;

		    try {
		        Class.forName(DBUtils.DRIVER);
		        conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
		        String sql = "Insert into agencias (nombre, logo, Col_Marca,Num_Emp,Tipo_Agencia, Contraseña) values ( ?, ?, ? ,? ,? ,?)";
		        sentencia = conexion.prepareStatement(sql);
		        sentencia.setString(1, agencia.getNombre());
		        sentencia.setString(2, agencia.getLogo());
		        sentencia.setString(3, agencia.getColorMarca());
		        sentencia.setString(4, agencia.getNumeroEmpleados());
		        sentencia.setString(5, agencia.getTipoAgencia());
		        sentencia.setString(6, agencia.getContraseña());

		        sentencia.executeUpdate();
		        System.out.println("Agencia registrada correctamente.");
		    } catch (SQLException sqle) {
		        System.out.println("Error con la base de datos " + sqle.getMessage());
		    } catch (Exception e) {
		        System.out.println("Error genérico " + e.getMessage());
		    } finally {
		        try {
		            if (sentencia != null) sentencia.close();
		            if (conexion != null) conexion.close();
		        } catch (Exception e) {
		            System.out.println("Error al cerrar recursos: " + e.getMessage());
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

