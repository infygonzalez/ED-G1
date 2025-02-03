package Controlador;

import java.awt.Color;
import java.util.ArrayList;

import Modelo_Gestor.Gestor;
import Modelo_Pojos.Agencia;
import Modelo_Pojos.Evento;
import Modelo_Pojos.Viaje;


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
	    return Gestor.actualizarViaje();
	}
	
	public static ArrayList<Evento> actualizarEvento(){
		return Gestor.actualizarEvento();
	}
	
	
	

}
