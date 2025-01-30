package Controlador;

import java.awt.Color;

import Modelo_Gestor.Gestor;
import Modelo_Pojos.Agencia;

public class Controlador {
	public static Agencia comprobarAgencias(String usuario, String contraseña) {
		return Gestor.comprobarAgencias(usuario, contraseña);
	}

	public static boolean registrarAgencia(Agencia agencia) {
		if (Gestor.existeAgencia(agencia.getNombre())) {
			System.out.println("Error: La agencia ya está registrada.");
			return false;
		}
		Gestor.crearAgencia(agencia);
		System.out.println("Agencia registrada correctamente.");
		return true;
	}

	public static boolean existeAgencia(String nombre) {
		boolean existe = Gestor.existeAgencia(nombre);
		if (existe) {
			System.out.println("La agencia con el nombre " + nombre + " ya existe.");
		} else {
			System.out.println("No se encontró una agencia con el nombre " + nombre);
		}
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

}
