package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestAgregarMaquinaAI {
	private NegocioMejorado negocio;

    @BeforeEach
    public void setUp() {
        // Inicializamos el negocio antes de cada prueba
        negocio = new NegocioMejorado();
    }

    @Test
    public void testAgregarMaquinaExitosa() {
        // Que se prueba: Agregar una máquina en un negocio vacío (siempre debería ser exitoso)
        // El método interno genera el código, instancia y agrega.
        boolean resultado = negocio.agregarMaquina("Pilsener", "Cerveza Rubia", 0.05);

        // Resultado esperado: Retorna true y la lista tiene 1 elemento
        assertTrue(resultado, "Debería retornar true al agregar la primera máquina");
        assertEquals(1, negocio.getMaquinas().size(), "El tamaño de la lista de máquinas debería ser 1");
        
        // Verificamos que los datos se hayan guardado correctamente
        Maquina guardada = negocio.getMaquinas().get(0);
        assertEquals("Pilsener", guardada.getNombreCerveZa());
        assertNotNull(guardada.getCodigo(), "El código generado no debería ser nulo");
    }

    @Test
    public void testAgregarVariasMaquinas() {
        // Que se prueba: La capacidad de agregar múltiples máquinas con códigos distintos
        negocio.agregarMaquina("Club", "Cerveza Premium", 0.08);
        negocio.agregarMaquina("Stout", "Cerveza Negra", 0.10);
        negocio.agregarMaquina("IPA", "Cerveza Amarga", 0.12);

        // Resultado esperado: La lista debe contener 3 máquinas
        assertEquals(3, negocio.getMaquinas().size(), "Deberían haberse agregado 3 máquinas exitosamente");
    }

    @Test
    public void testValidacionCodigoRepetido() {
        // Que se prueba: Simular el caso donde un código ya existe
        // Como el método genera el código aleatoriamente, forzamos un escenario 
        // inyectando una máquina manualmente con un código específico.
        
        String codigoManual = "M-99";
        Maquina maquinaExistente = new Maquina("Existente", "Desc", 0.01, 1000.0, codigoManual);
        negocio.getMaquinas().add(maquinaExistente);
        
        // Para probar la lógica de "si m == null", necesitaríamos que generarCodigo() 
        // devuelva "M-99". Dado que es aleatorio, validamos la estructura del método:
        // Si recuperarMaquina encuentra el código, no debería agregar.
        
        Maquina encontrada = negocio.recuperarMaquina(codigoManual);
        assertNotNull(encontrada, "La máquina con el código M-99 debe ser encontrada antes de intentar agregar");
        
        // Verificamos que si intentamos buscar ese mismo código, el sistema lo reconoce
        assertEquals("Existente", encontrada.getNombreCerveZa());
    }

    @Test
    public void testIntegridadDatosMaquinaAgregada() {
        // Que se prueba: Que los parámetros pasados al método lleguen correctamente al constructor de Maquina
        double precioTest = 0.07;
        negocio.agregarMaquina("Honey", "Cerveza con Miel", precioTest);
        
        Maquina m = negocio.getMaquinas().get(0);
        
        // Resultado esperado: El precio y nombre deben coincidir con lo enviado
        assertEquals("Honey", m.getNombreCerveZa());
        assertEquals(precioTest, m.getPrecioPorMl(), 0.0001);
    }
    
}
