package Modelo_Gestor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelo_Pojos.Alojamiento;
import Modelo_Pojos.Otros;
import Modelo_Pojos.Pais;
import Modelo_Pojos.Viaje;
import Modelo_Pojos.VuelosIda;
import Modelo_Pojos.VuelosVuelta;
import Modelo_Utils.DBUtils;
import Modelo_Utils.SQLQuerys;

public class GestorTablas {

	public static ArrayList<Viaje> actualizarViaje() {
		ArrayList<Viaje> viajes = new ArrayList<>();

		try {
			Class.forName(DBUtils.DRIVER);
			Connection conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			String sql = SQLQuerys.SELECT_VIAJES;
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			ResultSet resultSet = sentencia.executeQuery();

			while (resultSet.next()) {
				Viaje viaje = new Viaje();
				viaje.setId(resultSet.getInt("ID_Viaje"));
				viaje.setNombreViaje(resultSet.getString("Nom_Via"));
				viaje.setTipoViaje(resultSet.getString("Tipo_Viaje"));
				viaje.setDuracionViaje(resultSet.getString("Duracion_Via"));
				viaje.setFechaInicio(resultSet.getString("Fec_Ini"));
				viaje.setFechaFin(resultSet.getString("Fec_Fin"));

				String paisId = resultSet.getString("Pais");
				Pais pais = obtenerPais(paisId);
				viaje.setPais(pais);

				viajes.add(viaje);
			}

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos: " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error inesperado: " + e.getMessage());
		}

		return viajes;
	}

	private static Pais obtenerPais(String paisId) {
		Pais pais = null;
		Connection conexion = null;
		PreparedStatement sentencia = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);
			conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			String sql = SQLQuerys.SELECT_PAIS;
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, paisId);
			resultSet = sentencia.executeQuery();

			if (resultSet.next()) {
				String paisNombre = resultSet.getString("pais");
				String paisCodigo = resultSet.getString("codigo");
				pais = new Pais(paisNombre, paisCodigo);

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
		return pais;
	}

	public static ArrayList<Alojamiento> actualizarAlojamiento() {
		ArrayList<Alojamiento> alojamientos = new ArrayList<>();

		try {
			Class.forName(DBUtils.DRIVER);
			Connection conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			String sql = SQLQuerys.SELECT_ALOJAMIENTO;
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			ResultSet resultSet = sentencia.executeQuery();

			while (resultSet.next()) {
				Alojamiento alojamiento = new Alojamiento();
				alojamiento.setId(resultSet.getInt("id_alojamiento"));
				alojamiento.setNombreHotel(resultSet.getString("Nom_Hotel"));;
				alojamiento.setFechaEntrada(resultSet.getString("Fec_Ent"));
				alojamiento.setFechaSalida(resultSet.getString("Fec_Sal"));
				alojamiento.setPrecio(resultSet.getFloat("Precio"));

				alojamientos.add(alojamiento);
			}

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos: " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error inesperado: " + e.getMessage());
		}

		return alojamientos;
	}

	public static ArrayList<Otros> actualizarOtros() {
		ArrayList<Otros> otros = new ArrayList<>();

		try {
			Class.forName(DBUtils.DRIVER);
			Connection conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			String sql = SQLQuerys.SELECT_OTROS;
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			ResultSet resultSet = sentencia.executeQuery();

			while (resultSet.next()) {
				Otros otro = new Otros();
				otro.setId(resultSet.getInt("id_otro"));
				otro.setNombre(resultSet.getString("Nombre"));;
				otro.setFecha(resultSet.getString("Fecha"));
				otro.setPrecio(resultSet.getFloat("Precio"));

				otros.add(otro);
			}

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos: " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error inesperado: " + e.getMessage());
		}

		return otros;
	}

	public static ArrayList<VuelosIda> actualizarVuelosIda() {
		ArrayList<VuelosIda> vuelosIda = new ArrayList<>();

		try {
			Class.forName(DBUtils.DRIVER);
			Connection conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			String sql = SQLQuerys.SELECT_VUELOSIDA;
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			ResultSet resultSet = sentencia.executeQuery();

			while (resultSet.next()) {
				VuelosIda vueloIda = new VuelosIda();
				vueloIda.setCodigoVuelo(resultSet.getInt("codigovuelo"));
				vueloIda.setNombre(resultSet.getString("Nombre"));;
				vueloIda.setFechaSalida(resultSet.getString("Fec_Sal"));
				vueloIda.setPrecio(resultSet.getFloat("Precio"));

				vuelosIda.add(vueloIda);
			}

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos: " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error inesperado: " + e.getMessage());
		}

		return vuelosIda ;
	}

	public static ArrayList<VuelosVuelta> actualizarVuelosVuelta() {
		ArrayList<VuelosVuelta> vuelosVuelta = new ArrayList<>();

		try {
			Class.forName(DBUtils.DRIVER);
			Connection conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			String sql = SQLQuerys.SELECT_VUELOSIDA;
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			ResultSet resultSet = sentencia.executeQuery();

			while (resultSet.next()) {
				VuelosVuelta vueloVuelta = new VuelosVuelta();
				vueloVuelta.setCodigoVuelo(resultSet.getInt("codigovuelo"));
				vueloVuelta.setNombre(resultSet.getString("Nombre"));;
				vueloVuelta.setFechaSalida(resultSet.getString("Fec_Sal"));
				vueloVuelta.setPrecio(resultSet.getFloat("Precio"));

				vuelosVuelta.add(vueloVuelta);
			}

		} catch (SQLException sqle) {
			System.out.println("Error con la base de datos: " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error inesperado: " + e.getMessage());
		}

		return vuelosVuelta ;
	}

	public static boolean borrarViajes(int viajeId) {
	    try {
	        Class.forName(DBUtils.DRIVER);
	        Connection conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
	        String sql = SQLQuerys.DELETE_VIAJES;
	        PreparedStatement sentencia = conexion.prepareStatement(sql);
	        sentencia.setInt(1, viajeId);
	        int rowsAffected = sentencia.executeUpdate();
	        return rowsAffected > 0;
	        
	    } catch (SQLException sqle) {
	        System.out.println("Error con la base de datos: " + sqle.getMessage());
	        return false;
	    } catch (Exception e) {
	        System.out.println("Error inesperado: " + e.getMessage());
	        return false;
	    }
	


    }

	public static boolean borrarEventos(int eventoID) {
		  try {
		        Class.forName(DBUtils.DRIVER);
		        Connection conexion = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
		        String sql = SQLQuerys.DELETE_VIAJES;
		        PreparedStatement sentencia = conexion.prepareStatement(sql);
		        sentencia.setInt(1, eventoID);
		        int rowsAffected = sentencia.executeUpdate();
		        return rowsAffected > 0;
		        
		    } catch (SQLException sqle) {
		        System.out.println("Error con la base de datos: " + sqle.getMessage());
		        return false;
		    } catch (Exception e) {
		        System.out.println("Error inesperado: " + e.getMessage());
		        return false;
		    }
	}


	
}
