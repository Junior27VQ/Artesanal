package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

import java.util.ArrayList;

public class TestTotalVendidoAI {
	private NegocioMejorado negocio;
    private final double TOLERANCIA = 0.0001;

    @BeforeEach
    public void setUp() {
        // Inicializamos el negocio antes de cada test para asegurar limpieza de datos
        negocio = new NegocioMejorado();
    }

    @Test
    public void testConsultarValoresVendidosConVariosClientes() {
        // 1. Que se prueba: La suma total cuando hay múltiples clientes con consumos distintos.
        
        // Creamos clientes manualmente para tener control total de los datos
        Cliente c1 = new Cliente("Esteban", "17111");
        c1.setTotalConsumido(15.50);
        
        Cliente c2 = new Cliente("Andres", "17222");
        c2.setTotalConsumido(10.25);
        
        Cliente c3 = new Cliente("Marta", "17333");
        c3.setTotalConsumido(5.00);

        ArrayList<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(c1);
        listaClientes.add(c2);
        listaClientes.add(c3);

        // Seteamos la lista en el negocio
        negocio.setClientes(listaClientes);

        // 2. Ejecución
        double totalObtenido = negocio.consultarValoresVendidos();

        // 3. Resultado esperado: 15.50 + 10.25 + 5.00 = 30.75
        assertEquals(30.75, totalObtenido, TOLERANCIA, "La suma total de consumos no coincide");
    }

    @Test
    public void testConsultarValoresVendidosListaVacia() {
        // 1. Que se prueba: El comportamiento del método cuando no se han registrado clientes.
        
        // 2. Ejecución
        double totalObtenido = negocio.consultarValoresVendidos();

        // 3. Resultado esperado: Debe retornar 0.0
        assertEquals(0.0, totalObtenido, TOLERANCIA, "El total vendido en un negocio nuevo debería ser 0.0");
    }

    @Test
    public void testConsultarValoresVendidosTrasConsumoReal() {
        // 1. Que se prueba: Integración. Registrar clientes y simular consumos para ver el total.
        
        // Registramos clientes (códigos 100 y 101)
        negocio.registrarCliente("Usuario A", "111");
        negocio.registrarCliente("Usuario B", "222");

        // Obtenemos las referencias para asignarles consumo directamente
        // (Simulando lo que haría el método registrarConsumo o consumirCerveza)
        negocio.buscarClientePorCodigo(100).setTotalConsumido(100.0);
        negocio.buscarClientePorCodigo(101).setTotalConsumido(200.0);

        // 2. Ejecución
        double totalObtenido = negocio.consultarValoresVendidos();

        // 3. Resultado esperado: 300.0
        assertEquals(300.0, totalObtenido, TOLERANCIA);
    }

    @Test
    public void testConsultarValoresVendidosConUnSoloCliente() {
        // 1. Que se prueba: El caso donde solo existe un cliente en la lista.
        Cliente c1 = new Cliente("Unico", "000");
        c1.setTotalConsumido(45.99);
        
        ArrayList<Cliente> lista = new ArrayList<>();
        lista.add(c1);
        negocio.setClientes(lista);

        // 2. Ejecución
        double totalObtenido = negocio.consultarValoresVendidos();

        // 3. Resultado esperado: 45.99
        assertEquals(45.99, totalObtenido, TOLERANCIA);
    }
    
}
