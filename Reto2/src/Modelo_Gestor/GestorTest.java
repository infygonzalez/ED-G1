package Modelo_Gestor;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo_Pojos.Agencia;

public class GestorTest {

	@Test
	public void testComprobarAgencia() {
		String nombre = "admin";
		String contraseña = "admin";

		Agencia resultado = Gestor.comprobarAgencias(nombre, contraseña);

		assertEquals("El nombre de la agencia debería ser 'admin'", "admin",
				resultado.getNombre());
		assertEquals("El nombre de la agencia debería ser 'admin'", "admin",
				resultado.getContraseña());

	}

	@Test
	public void testCrearAgencia() {
		Agencia agencia = new Agencia();
		agencia.setNombre("prueba");
		agencia.setLogo("https://upload.wikimedia.org/wikipedia/commons/6/6b/JHDeLaCruz.jpg");
		agencia.setColorMarca("#192FF0") ;
		agencia.setNumeroEmpleados( "Entre 2 y 5 empleados");
		agencia.setTipoAgencia("Mayorista")  ;
		agencia.setContraseña("prueba") ;
		
		boolean resultado = Gestor.crearAgencia(agencia);
		
		assertTrue(resultado);
	
	}

	@Test
	public void testExisteAgencia() {
		String nombreTrue = "admin";
		String nombreFalse = "asdasdasdas";
		
		boolean resultadoTrue = Gestor.existeAgencia(nombreTrue);
		boolean resultadoFalse = Gestor.existeAgencia(nombreFalse);
		
		assertTrue(resultadoTrue);
		assertFalse(resultadoFalse);
	}

}
