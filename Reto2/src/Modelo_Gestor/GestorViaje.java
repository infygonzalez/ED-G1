package Modelo_Gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelo_Pojos.Agencia;
import Modelo_Pojos.Pais;
import Modelo_Pojos.Viaje;
import Modelo_Utils.DBUtils;
import Modelo_Utils.SQLQuerys;

public class GestorViaje {

	public static boolean crearViaje(Viaje viaje, Agencia agencia) {
		
		  if (existeViaje(viaje)) {
		        System.out.println("El viaje ya existe.");
		        return false;
		    }
		  
		Connection conexion = null;
		PreparedStatement sentencia = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = "INSERT INTO viajes (Nom_Via, Descripcion, Tipo_Viaje, Fec_Ini, Fec_Fin, Duracion_Via, Pais, Ser_no_inc, id) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			sentencia = conexion.prepareStatement(sql);

			sentencia.setString(1, viaje.getNombreViaje());
			sentencia.setString(2, viaje.getDescripcion());
			sentencia.setString(3, viaje.getTipoViaje());
			sentencia.setString(4, viaje.getFechaInicio());
			sentencia.setString(5, viaje.getFechaFin());
			sentencia.setString(6, viaje.getDuracionViaje());
			sentencia.setString(7, viaje.getPais().getNombre()); 
			sentencia.setString(8, viaje.getServiciosNoIncluidos());
			sentencia.setInt(9, agencia.getId());

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
				if (sentencia != null) {
					sentencia.close();
				}
				if (conexion != null) {
					conexion.close();
				}
			} catch (SQLException e) {
				System.out.println("Error al cerrar los recursos: " + e.getMessage());
			}
		}

	}
	
	public static boolean existeViaje(Viaje viaje) {
	    Connection conexion = null;
	    PreparedStatement sentencia = null;
	    ResultSet rs = null;

	    try {
	        Class.forName(DBUtils.DRIVER);
	        conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

	        String sql = "SELECT COUNT(*) FROM viajes WHERE Nom_Via = ? AND Fec_Ini = ?";
	        sentencia = conexion.prepareStatement(sql);
	        sentencia.setString(1, viaje.getNombreViaje());
	        sentencia.setString(2, viaje.getFechaInicio());

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
	            if (rs != null) rs.close();
	            if (sentencia != null) sentencia.close();
	            if (conexion != null) conexion.close();
	        } catch (SQLException e) {
	            System.out.println("Error al cerrar los recursos: " + e.getMessage());
	        }
	    }

	    return false;  // Si no se encuentra, significa que no existe el viaje
	}


	public static ArrayList<Pais> obtenerPais() {
	    ArrayList<Pais> paises = new ArrayList<>();
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
	            String codigoPais = rs.getString("codigo");  
	            String nombrePais = rs.getString("pais");
	            paises.add(new Pais(nombrePais, codigoPais));  // Creamos el objeto Pais con nombre y codigo
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (sentencia != null) sentencia.close();
	            if (conexion != null) conexion.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return paises;  
	}

}
