package Controlador;

import java.awt.Color;
import java.util.ArrayList;

import Modelo_Gestor.Gestor;
import Modelo_Gestor.GestorEvento;
import Modelo_Gestor.GestorTablas;
import Modelo_Gestor.GestorViaje;
import Modelo_Pojos.Agencia;
import Modelo_Pojos.Alojamiento;
import Modelo_Pojos.CompañiasAereas;
import Modelo_Pojos.IATAS;
import Modelo_Pojos.Otros;
import Modelo_Pojos.Pais;
import Modelo_Pojos.Viaje;
import Modelo_Pojos.VuelosIda;
import Modelo_Pojos.VuelosVuelta;

public class Controlador {
	public static Agencia comprobarAgencias(String usuario, String contraseña) {
		return Gestor.comprobarAgencias(usuario, contraseña);
	}

	public static boolean registrarAgencia(Agencia agencia) {
		if (Gestor.existeAgencia(agencia.getNombre())) {
			return false;
		} else {
			return Gestor.crearAgencia(agencia);
		}
	}

	public static boolean existeAgencia(String nombre) {
		boolean existe = Gestor.existeAgencia(nombre);

		return existe;
	}

	public static boolean validacionColor(String color) {
		try {
			if (color.startsWith("#") && color.length() == 7) {
				Color.decode(color);
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return false;
	}

	public static boolean validarContraseña(String contraseña, String validacion) {
		if (contraseña.equals(validacion)) {
			return true;
		} else {
			return false;
		}
	}

	public static ArrayList<Viaje> obtenerViajesPorAgencia(Agencia agencia) {
		return GestorTablas.actualizarViajePorAgencia(agencia);
	}

	public static ArrayList<Alojamiento> obtenerAlojamientosPorAgencia(Viaje viaje) {
		return GestorTablas.actualizarAlojamientoPorAgencia(viaje);
	}

	public static ArrayList<VuelosIda> obtenerVuelosIdaPorAgencia(Viaje viaje) {
		return GestorTablas.actualizarVuelosIdaPorAgencia(viaje);
	}

	public static ArrayList<VuelosVuelta> obtenerVuelosVueltaPorAgencia(Viaje viaje) {
		return GestorTablas.actualizarVuelosVueltaPorAgencia(viaje);
	}

	public static ArrayList<Otros> obtenerOtrosPorAgencia(Viaje viaje) {
		return GestorTablas.actualizarOtrosPorAgencia(viaje);
	}

	public static boolean borrarViaje(int viajeID) {
		return GestorTablas.borrarViaje(viajeID);
	}

	public static boolean borrarEvento(int eventoID, String tipoEvento) {
		return GestorTablas.borrarEvento(eventoID, tipoEvento);

	}

	public static boolean borrarEventosPorViaje(int viajeId) {
		return GestorTablas.borrarEventosPorViaje(viajeId);
	}

	public static boolean crearViaje(Viaje viaje, Agencia agencia) {
		return GestorViaje.crearViaje(viaje, agencia);

	}

	public static ArrayList<Pais> obtenerPaises() {
		return GestorViaje.obtenerPais();
	}

	public static boolean crearOtro(Viaje viaje, Otros otro) {
		return GestorEvento.crearOtro(viaje, otro);
	}

	public static boolean crearVueloIda(Viaje viaje, VuelosIda vuelo) {
		if (vuelo == null || viaje == null) {
			return false;
		}
		return GestorEvento.crearVueloIda(viaje, vuelo);
	}
	public static boolean crearVueloVuelta(Viaje viaje, VuelosVuelta vuelo) {
		if (vuelo == null || viaje == null) {
			return false;
		}
		return GestorEvento.crearVueloVuelta(viaje, vuelo);
	}
	
	public static ArrayList<IATAS> obtenerAeropuerto(){
		return GestorEvento.obtenerAeropuerto();
	}

	public static ArrayList<CompañiasAereas> obtenerCompañiaAerea() {
		// TODO Auto-generated method stub
		return GestorEvento.obtenerCompañiaAerea();
	}

	public static boolean crearAlojamiento(Viaje viaje, Alojamiento alojamiento) {
		return GestorEvento.obtenerAlojamiento(viaje,alojamiento);
	}


}
