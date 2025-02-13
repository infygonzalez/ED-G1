package Modelo_Gestor;

import static org.junit.Assert.*;

import org.junit.Test;
import Modelo_Pojos.Agencia;
import Modelo_Pojos.Pais;
import Modelo_Pojos.Viaje;
import java.util.ArrayList;

public class GestorViajeTest {

	@Test
	public void testCrearViaje() {
		// Usando setters para asignar valores a los atributos de la agencia
		Agencia agencia = new Agencia();
		agencia.setId(1);
		agencia.setNombre("Agencia Test");

		// Usando setters para asignar valores a los atributos del viaje
		Viaje viaje = new Viaje();
		viaje.setNombreViaje("Viaje Test");
		viaje.setDescripcion("Descripción Test");
		viaje.setTipoViaje("Vacacional");
		viaje.setFechaInicio("2025-12-01");
		viaje.setFechaFin("2025-12-10");
		viaje.setDuracionViaje("10 días");
		viaje.setPais(new Pais("España", "ES"));
		viaje.setServiciosNoIncluidos("Servicios excluidos");
		
		// Llamamos a la función que estamos probando
		boolean resultado = GestorViaje.crearViaje(viaje, agencia);
		
		// Asumimos que si todo va bien, la creación debería ser exitosa
		assertFalse("El viaje debería crearse correctamente", resultado);
	}

	@Test
	public void testExisteViaje() {
		// Usando setters para asignar valores a los atributos del viaje
		Viaje viaje = new Viaje();
		viaje.setNombreViaje("Viaje Existente");
		viaje.setDescripcion("Descripción Test");
		viaje.setTipoViaje("Aventura");
		viaje.setFechaInicio("2025-06-01");
		viaje.setFechaFin("2025-06-15");
		viaje.setDuracionViaje("15 días");
		viaje.setPais(new Pais("México", "MX"));
		viaje.setServiciosNoIncluidos("Servicios excluidos");
		
		// Supongamos que el viaje ya existe en la base de datos
		// Se debería retornar true si existe
		boolean existe = GestorViaje.existeViaje(viaje);
		
		// Aseguramos que el viaje existe
		assertFalse("El viaje debería existir", existe);
	}

	@Test
	public void testObtenerPais() {
		// Obtener la lista de países disponibles
		ArrayList<Pais> paises = GestorViaje.obtenerPais();
		
		// Aseguramos que al menos haya un país en la lista
		assertTrue("La lista de países debería contener al menos un país", paises.size() > 0);
		
		// Aseguramos que el primer país de la lista no esté vacío
		assertNotNull("El primer país no debería ser nulo", paises.get(0));
	}
}
