package Modelo_Gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo_Pojos.Agencia;
import Modelo_Pojos.Otros;
import Modelo_Pojos.Viaje;
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
                if (sentencia != null) sentencia.close();
                if (conexion != null) conexion.close();
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
                if (rs != null) rs.close();
                if (sentencia != null) sentencia.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }

        return false;
    }
}
