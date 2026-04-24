package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

import java.util.ArrayList;

public class TestNegocioAI {
	@Test
    public void testGenerarCodigoFormatoCorrecto() {
        // Que se prueba: Que el código generado empiece con "M-"
        NegocioMejorado negocio = new NegocioMejorado();
        
        String codigo = negocio.generarCodigo();
        
        // Resultado esperado: El código no es nulo y empieza con el prefijo definido
        assertNotNull(codigo, "El código generado no debe ser nulo");
        assertTrue(codigo.startsWith("M-"), "El código debe iniciar con el prefijo 'M-'");
    }

    @Test
    public void testGenerarCodigoRangoNumerico() {
        // Que se prueba: Que la parte numérica del código esté entre 1 y 100
        NegocioMejorado negocio = new NegocioMejorado();
        
        String codigo = negocio.generarCodigo();
        // Extraemos la parte numérica después del guion
        String parteNumericaStr = codigo.substring(2);
        int numero = Integer.parseInt(parteNumericaStr);
        
        // Resultado esperado: El número extraído debe estar en el rango [1, 100]
        assertTrue(numero >= 1 && numero <= 100, "La parte numérica debe estar entre 1 y 100. Valor obtenido: " + numero);
    }

    @Test
    public void testGestionArrayListMaquinas() {
        // Que se prueba: El funcionamiento de la lista de máquinas y el uso del constructor de Maquina
        NegocioMejorado negocio = new NegocioMejorado();
        ArrayList<Maquina> listaLocal = new ArrayList<>();
        
        // Creamos una instancia de Maquina usando el constructor completo solicitado
        // Parámetros: nombre, descripción, precioMl, capMaxima, codigo
        Maquina m1 = new Maquina("Pilsener", "Cerveza clara", 0.05, 5000.0, negocio.generarCodigo());
        Maquina m2 = new Maquina("Club", "Cerveza premium", 0.08, 3000.0, negocio.generarCodigo());
        
        listaLocal.add(m1);
        listaLocal.add(m2);
        
        // Usamos el setter y getter de la clase NegocioMejorado
        negocio.setMaquinas(listaLocal);
        
        // Resultado esperado: La lista debe contener 2 máquinas y conservar sus datos
        assertEquals(2, negocio.getMaquinas().size(), "La lista debería tener 2 máquinas");
        assertEquals("Pilsener", negocio.getMaquinas().get(0).getNombreCerveZa());
        assertNotNull(negocio.getMaquinas().get(1).getCodigo(), "La segunda máquina debe tener un código generado");
    }

    @Test
    public void testInicializacionListaVacía() {
        // Que se prueba: Que al crear el negocio, la lista no sea nula (constructor)
        NegocioMejorado negocio = new NegocioMejorado();
        
        // Resultado esperado: La lista debe estar inicializada pero vacía
        assertNotNull(negocio.getMaquinas(), "La lista de máquinas debe estar inicializada en el constructor");
        assertEquals(0, negocio.getMaquinas().size());
    }
    
}
