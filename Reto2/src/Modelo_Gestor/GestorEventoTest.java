package Modelo_Gestor;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Modelo_Pojos.CompañiasAereas;
import Modelo_Pojos.IATAS;
import Modelo_Pojos.Otros;
import Modelo_Pojos.Viaje;
import Modelo_Pojos.VuelosIda;
import Modelo_Pojos.VuelosVuelta;
import Modelo_Pojos.Alojamiento;

public class GestorEventoTest {

	@Test
	public void testCrearOtro() {
		Viaje viaje = new Viaje();
		Otros otro = new Otros();

		otro.setNombre("JUNIT");
		otro.setFecha("2077-12-04");
		otro.setDescripcion("Descripcion Prueba");
		otro.setPrecio((float) 1.2);
		viaje.setId(12); // Buscado en la BBDD

		boolean resultado = GestorEvento.crearOtro(viaje, otro);

		assertFalse(resultado);
	}

	@Test
	public void testExisteOtro() {
		Otros otro = new Otros();
		otro.setNombre("prueba");
		otro.setFecha("2025-02-03");

		boolean resultado = GestorEvento.existeOtro(otro);

		assertTrue(resultado);
	}

	@Test
	public void testCrearVueloIda() {
		Viaje viaje = new Viaje();
		IATAS iatas = new IATAS(); // Instanciamos el objeto IATAS
		CompañiasAereas aerolinea = new CompañiasAereas();

		VuelosIda vuelo = new VuelosIda();
		viaje.setId(13); // ID del viaje (simulando que ya existe en la BBDD)
		vuelo.setCodigoVuelo(666);
		vuelo.setNombre("JUNIT");

		iatas.setAeropuerto("AeropuertoPrueba");
		iatas.setCodigo("AP");

		vuelo.setSalida(iatas);
		vuelo.setDestino(iatas);
		vuelo.setPrecio((float) 120.5);

		aerolinea.setNombre("AerolineaPrueba");
		aerolinea.setCodigo("AePr");

		vuelo.setFechaSalida("2025-12-31");
		vuelo.setHoraSalida("12:45");
		vuelo.setDuracion("3");

		boolean resultado = GestorEvento.crearVueloIda(viaje, vuelo);

		assertFalse(resultado); 
	}

	@Test
	public void testCrearVueloVuelta() {
		Viaje viaje = new Viaje();
		IATAS iatas = new IATAS();
		CompañiasAereas aerolinea = new CompañiasAereas();

		VuelosVuelta vueloVuelta = new VuelosVuelta();
		viaje.setId(13); 
		vueloVuelta.setCodigoVuelo(777);
		vueloVuelta.setNombre("JUNIT Vuelta");

		iatas.setAeropuerto("AeropuertoPrueba");
		iatas.setCodigo("AP");

		vueloVuelta.setSalida(iatas);
		vueloVuelta.setDestino(iatas);
		vueloVuelta.setPrecio((float) 150.5);

		aerolinea.setNombre("AerolineaPrueba");
		aerolinea.setCodigo("AePr");

		vueloVuelta.setFechaSalida("2026-01-10");
		vueloVuelta.setHoraSalida("14:30");
		vueloVuelta.setDuracion("3");
		vueloVuelta.setFechaVuelta("2026-01-15");
		vueloVuelta.setDuracionVuelta("3");

		boolean resultado = GestorEvento.crearVueloVuelta(viaje, vueloVuelta);

		assertFalse(resultado); // Cambia esto según el comportamiento esperado
	}

	@Test
	public void testObtenerAeropuerto() {
		ArrayList<IATAS> aeropuertos = GestorEvento.obtenerAeropuerto();

		assertNotNull(aeropuertos);
		assertTrue(aeropuertos.size() > 0);
	}

	@Test
	public void testObtenerCompañiaAerea() {
		ArrayList<CompañiasAereas> compañias = GestorEvento.obtenerCompañiaAerea();

		assertNotNull(compañias);
		assertTrue(compañias.size() > 0); 
	}

	@Test
	public void testObtenerAlojamiento() {
		
		Viaje viaje = new Viaje();
		Alojamiento alojamiento = new Alojamiento();

		alojamiento.setId(50);
		alojamiento.setNombreHotel("Hotel Prueba");
		alojamiento.setCiudad("Ciudad Prueba");
		alojamiento.setPrecio((float) 200.5);
		alojamiento.setFechaEntrada("2025-12-31");
		alojamiento.setFechaSalida("2026-01-10");
		alojamiento.setTipoHabitacion("Doble");

		viaje.setId(12);
		boolean resultado = GestorEvento.obtenerAlojamiento(viaje, alojamiento);

		assertTrue(resultado);
	}
}
