package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

import java.util.ArrayList;

public class TestRrcuperarMaquinaAI {
	private NegocioMejorado negocio;

    @BeforeEach
    public void setUp() {
        // Inicializamos el objeto antes de cada test para garantizar limpieza
        negocio = new NegocioMejorado();
    }

    @Test
    public void testRecuperarMaquinaExistente() {
        // 1. Que se prueba: Buscar un código que sí está presente en la lista.
        // Usamos el constructor de Maquina solicitado: nombre, desc, precio, capMax, codigo.
        Maquina m1 = new Maquina("Pilsener", "Rubia", 0.05, 5000.0, "M-10");
        Maquina m2 = new Maquina("Club", "Premium", 0.08, 3000.0, "M-20");
        
        ArrayList<Maquina> lista = new ArrayList<>();
        lista.add(m1);
        lista.add(m2);
        negocio.setMaquinas(lista);

        // 2. Ejecutar búsqueda
        Maquina encontrada = negocio.recuperarMaquina("M-20");

        // 3. Resultado esperado: Debe retornar el objeto m2.
        assertNotNull(encontrada, "La máquina debería encontrarse.");
        assertEquals("Club", encontrada.getNombreCerveZa(), "El nombre de la máquina encontrada debe coincidir.");
        assertEquals("M-20", encontrada.getCodigo(), "El código de la máquina encontrada debe ser M-20.");
    }

    @Test
    public void testRecuperarMaquinaNoExistente() {
        // 1. Que se prueba: Buscar un código que NO está en la lista.
        Maquina m1 = new Maquina("Honey", "Dulce", 0.10, 2000.0, "M-50");
        ArrayList<Maquina> lista = new ArrayList<>();
        lista.add(m1);
        negocio.setMaquinas(lista);

        // 2. Ejecutar búsqueda de un código inexistente
        Maquina encontrada = negocio.recuperarMaquina("M-99");

        // 3. Resultado esperado: Debe retornar null.
        assertNull(encontrada, "Debe retornar null si el código no coincide con ninguna máquina.");
    }

    @Test
    public void testRecuperarEnListaVacia() {
        // 1. Que se prueba: Buscar en un negocio que no tiene máquinas.
        // La lista está inicializada vacía por el constructor de NegocioMejorado.
        
        // 2. Ejecutar búsqueda
        Maquina encontrada = negocio.recuperarMaquina("M-1");

        // 3. Resultado esperado: Debe retornar null.
        assertNull(encontrada, "Debe retornar null si la lista de máquinas está vacía.");
    }

    @Test
    public void testRecuperarPrimerElemento() {
        // 1. Que se prueba: Validar que el bucle recorre correctamente desde el inicio (posición 0).
        Maquina m1 = new Maquina("IPA", "Amarga", 0.12, 1000.0, "M-01");
        Maquina m2 = new Maquina("Stout", "Negra", 0.15, 1500.0, "M-02");
        
        ArrayList<Maquina> lista = new ArrayList<>();
        lista.add(m1);
        lista.add(m2);
        negocio.setMaquinas(lista);

        // 2. Ejecutar búsqueda del primer elemento
        Maquina encontrada = negocio.recuperarMaquina("M-01");

        // 3. Resultado esperado: Debe retornar m1.
        assertNotNull(encontrada);
        assertEquals("IPA", encontrada.getNombreCerveZa());
    }
    
}
