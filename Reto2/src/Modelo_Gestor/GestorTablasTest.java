package Modelo_Gestor;

import static org.junit.Assert.*;

import org.junit.Test;
import Modelo_Pojos.Agencia;
import Modelo_Pojos.Viaje;
import Modelo_Pojos.Alojamiento;
import Modelo_Pojos.Otros;
import Modelo_Pojos.VuelosIda;
import Modelo_Pojos.VuelosVuelta;

import java.util.ArrayList;

public class GestorTablasTest {

    @Test
    public void testActualizarViajePorAgencia() {
        Agencia agencia = new Agencia();
        agencia.setId(1); // Simulamos una agencia con ID 1
        
        ArrayList<Viaje> viajes = GestorTablas.actualizarViajePorAgencia(agencia);

        // Verificamos que el resultado no sea nulo
        assertNotNull(viajes);
        
        // Verificamos que la lista de viajes no esté vacía
        assertFalse("La lista de viajes no debe estar vacía", viajes.size() > 0);

      
    }

    @Test
    public void testActualizarAlojamientoPorAgencia() {
        Viaje viaje = new Viaje();
        viaje.setId(1); // Asumimos un viaje con ID 1
        
        ArrayList<Alojamiento> alojamientos = GestorTablas.actualizarAlojamientoPorAgencia(viaje);

        // Verificamos que la lista de alojamientos no sea nula ni vacía
        assertNotNull(alojamientos);
        assertFalse("La lista de alojamientos no debe estar vacía", alojamientos.size() > 0);
    }

    @Test
    public void testActualizarOtrosPorAgencia() {
        Viaje viaje = new Viaje();
        viaje.setId(1); // Asumimos un viaje con ID 1
        
        ArrayList<Otros> otros = GestorTablas.actualizarOtrosPorAgencia(viaje);

        // Verificamos que la lista de otros no sea nula ni vacía
        assertNotNull(otros);
        assertFalse("La lista de otros no debe estar vacía", otros.size() > 0);
    }

    @Test
    public void testActualizarVuelosIdaPorAgencia() {
        Viaje viaje = new Viaje();
        viaje.setId(1); // Asumimos un viaje con ID 1
        
        ArrayList<VuelosIda> vuelosIda = GestorTablas.actualizarVuelosIdaPorAgencia(viaje);

        // Verificamos que la lista de vuelos de ida no sea nula ni vacía
        assertNotNull(vuelosIda);
        assertFalse("La lista de vuelos de ida no debe estar vacía", vuelosIda.size() > 0);
    }

    @Test
    public void testActualizarVuelosVueltaPorAgencia() {
        Viaje viaje = new Viaje();
        viaje.setId(12); 
        
        ArrayList<VuelosVuelta> vuelosVuelta = GestorTablas.actualizarVuelosVueltaPorAgencia(viaje);

        assertNotNull(vuelosVuelta);
        assertFalse("La lista de vuelos de vuelta no debe estar vacía", vuelosVuelta.size() > 0);
    }

    @Test
    public void testBorrarViaje() {
        int viajeId = 13; 
        
        boolean resultado = GestorTablas.borrarViaje(viajeId);

        assertFalse("El viaje debe ser borrado correctamente", resultado);
    }

    @Test
    public void testBorrarEvento() {
        int eventoId = 13 ; // Suponemos que el evento existe
        String tipoEvento = "Viaje"; // Tipo de evento que queremos borrar
        
        boolean resultado = GestorTablas.borrarEvento(eventoId, tipoEvento);

        // Verificamos que el evento haya sido borrado correctamente
        assertFalse("El evento debe ser borrado correctamente", resultado);
    }

    @Test
    public void testBorrarEventosPorViaje() {
        int viajeId = 1; // Suponemos que el viaje con ID 1 tiene eventos asociados
        
        boolean resultado = GestorTablas.borrarEventosPorViaje(viajeId);

        // Verificamos que los eventos del viaje fueron borrados correctamente
        assertTrue("Los eventos del viaje deben ser borrados correctamente", resultado);
    }
}
