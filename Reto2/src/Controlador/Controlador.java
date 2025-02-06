package Controlador;

import java.awt.Color;
import java.util.ArrayList;

import Modelo_Gestor.Gestor;
import Modelo_Gestor.GestorTablas;
import Modelo_Pojos.Agencia;
import Modelo_Pojos.Alojamiento;
import Modelo_Pojos.Evento;
import Modelo_Pojos.Otros;
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

	public static ArrayList<Viaje> actualizarViajes() {
	    return GestorTablas.actualizarViaje();
	}
	
	public static ArrayList<Alojamiento> actualizarAlojamiento(){
		return GestorTablas.actualizarAlojamiento();
	}

	public static ArrayList<Otros> actualizarOtros() {
		return GestorTablas.actualizarOtros();
	}

	public static ArrayList<VuelosIda> actualizarVuelosIda() {
		return GestorTablas.actualizarVuelosIda();
	}

	public static ArrayList<VuelosVuelta> actualizarVuelosVuelta() {
		return GestorTablas.actualizarVuelosVuelta();	
	}
	
	public static boolean borrarViajes(int viajeID) {
		return GestorTablas.borrarViajes(viajeID);
	}
	
	public static boolean borrarEventos(int eventoID) {
		return GestorTablas.borrarEventos(eventoID);

	}
	
	
	
	

}
