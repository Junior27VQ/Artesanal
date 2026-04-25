package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestConsumirCervezaAI {
	private NegocioMejorado negocio;
    private final double TOLERANCIA = 0.0001;

    @BeforeEach
    public void setUp() {
        // Inicializamos el negocio antes de cada test
        negocio = new NegocioMejorado();
    }

    @Test
    public void testConsumirCervezaExitoso() {
        // 1. ESCENARIO: Registrar un cliente (recibirá el código 100)
        negocio.registrarCliente("Juan Perez", "1712345678");
        Cliente cliente = negocio.buscarClientePorCodigo(100);
        cliente.setTotalConsumido(10.0); // Saldo inicial previo

        // 2. ESCENARIO: Configurar una máquina manualmente y agregarla a la lista
        // Parámetros: nombre, descripcion, precioPorMl, capacidadMaxima, codigo
        String codigoM = "M-TEST-01";
        double precioMl = 0.05;
        Maquina maquina = new Maquina("Pilsener", "Rubia", precioMl, 1200.0, codigoM);
        //maquina.setCantidadActual(1000.0); // Aseguramos que tenga cerveza para servir
        maquina.llenarMaquina();
        
        ArrayList<Maquina> listaMaquinas = new ArrayList<>();
        listaMaquinas.add(maquina);
        negocio.setMaquinas(listaMaquinas);

        // 3. EJECUCIÓN: Consumir 100ml
        // Cantidad servida (s) = 100.0
        // Valor consumo = 100.0 * 0.05 = 5.0
        // Total esperado = 10.0 (inicial) + 5.0 (nuevo) = 15.0
        negocio.consumirCerveza(100, codigoM, 100.0);

        // 4. VALIDACIÓN
        // Validar Cliente actualizado
        assertEquals(15.0, cliente.getTotalConsumido(), TOLERANCIA, "El total consumido del cliente no se calculó correctamente");
        
        // Validar Máquina afectada (Asumiendo que servirCerveza resta la cantidad)
        // Si servirCerveza funciona correctamente, la cantidad actual debería bajar de 1000 a 900
        assertEquals(900.0, maquina.getCantidadActual(), TOLERANCIA, "La cantidad actual de la máquina debería haber disminuido");
    }

    @Test
    public void testConsumirCervezaAcumulativo() {
        // QUE VALIDA: Que múltiples consumos se sumen correctamente al total del cliente
        negocio.registrarCliente("Maria Lopez", "1722334455");
        
        String codigoM = "M-77";
        Maquina maquina = new Maquina("Club", "Premium", 0.10, 1200.0, codigoM);
        //maquina.setCantidadActual(1000.0);
        maquina.llenarMaquina();
        negocio.getMaquinas().add(maquina);

        // Primer consumo: 50ml * 0.10 = 5.0
        negocio.consumirCerveza(100, codigoM, 50.0);
        // Segundo consumo: 20ml * 0.10 = 2.0
        negocio.consumirCerveza(100, codigoM, 20.0);

        Cliente c = negocio.buscarClientePorCodigo(100);
        assertEquals(7.0, c.getTotalConsumido(), TOLERANCIA, "El total consumido debe ser la suma acumulada de todos los consumos");
    }

    @Test
    public void testRecuperarDatosIntegridad() {
        // QUE VALIDA: Que buscarCliente y recuperarMaquina funcionan para alimentar el proceso de consumo
        negocio.registrarCliente("Carlos", "999999");
        
        String codigoM = "M-X";
        Maquina m = new Maquina("Artesanal", "Negra", 0.15, 1000.0, codigoM);
        negocio.getMaquinas().add(m);

        assertNotNull(negocio.buscarClientePorCodigo(100), "El método buscarClientePorCodigo falló");
        assertNotNull(negocio.recuperarMaquina(codigoM), "El método recuperarMaquina falló");
    }

    @Test
    public void testConsumoConCantidadCero() {
        // QUE VALIDA: Que un consumo de 0 no altere los valores económicos
        negocio.registrarCliente("Solo Mira", "000000");
        Cliente c = negocio.buscarClientePorCodigo(100);
        c.setTotalConsumido(100.0);

        String codigoM = "M-0";
        Maquina m = new Maquina("Agua", "Sin gas", 0.01, 100.0, codigoM);
        negocio.getMaquinas().add(m);

        negocio.consumirCerveza(100, codigoM, 0.0);

        assertEquals(100.0, c.getTotalConsumido(), TOLERANCIA, "El consumo de 0 no debe afectar el total acumulado");
    }
}
