package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {
	// Se utiliza una tolerancia (delta) de 0.001 para comparar valores double
	private final double TOLERANCIA = 0.0001;

    @Test
    public void testServirConExitoConstructorCompleto() {
        // 1. Usar constructor con capacidad máxima personalizada (2000 ml)
        // Parámetros: nombre, descripción, precioPorMl, capacidadMaxima
        Maquina maquina = new Maquina("Pilsen", "Cerveza Rubia", 0.05, 2000.0, "CN002");
        
        // Llenar la máquina (cantidadActual será 1900.0/1800)
        maquina.llenarMaquina();
        
        // 2. Intentar servir 500 ml
        // Valor esperado: 500 * 0.05 = 25.0
        double valorRetornado = maquina.servirCerveza(500.0);
        
        // Validar que el valor a pagar sea correcto
        assertEquals(25.0, valorRetornado, TOLERANCIA, "El valor a pagar por 500ml a 0.05 debería ser 25.0");
        
        // Validar que la cantidad en la máquina disminuyó (1900 - 500 = 1400)
        assertEquals(1300.0, maquina.getCantidadActual(), TOLERANCIA, "La cantidad actual debería ser 1400 después de servir");
    }

    @Test
    public void testServirConExitoConstructorReducido() {
        // 1. Usar constructor que asume capacidad máxima de 1000 ml
        // Parámetros: nombre, descripción, precioPorMl
        Maquina maquina = new Maquina("Stout", "Cerveza Negra", 0.10, "CN003");
        
        // Recargar la máquina con 400 ml (cantidadActual pasa de 0 a 400)
        maquina.recargarMaquina(400.0);
        
        // 2. Servir 150 ml
        // Valor esperado: 150 * 0.10 = 15.0
        double valorRetornado = maquina.servirCerveza(150.0);
        
        assertEquals(15.0, valorRetornado, TOLERANCIA, "El valor a pagar por 150ml a 0.10 debería ser 15.0");
        
        // Validar cantidad restante (400 - 150 = 250)
        assertEquals(250.0, maquina.getCantidadActual(), TOLERANCIA, "La cantidad actual debería ser 250");
    }

    @Test
    public void testServirSinSuficienteCerveza() {
        // 1. Inicializar máquina con poca cerveza
        Maquina maquina = new Maquina("IPA", "Cerveza Amarga", 0.08, 1000.0, "CN004");
        maquina.recargarMaquina(100.0); // Solo hay 100 ml disponibles
        
        // 2. Intentar servir 150 ml (más de lo que hay)
        double valorRetornado = maquina.servirCerveza(150.0);
        
        // Validar que retorna 0 porque no pudo servir
        assertEquals(0.0, valorRetornado, TOLERANCIA, "Debe retornar 0 si no hay suficiente cerveza");
        
        // Validar que la cantidad actual NO se modificó (sigue en 100)
        assertEquals(100.0, maquina.getCantidadActual(), TOLERANCIA, "La cantidad actual no debe cambiar si no se sirve");
    }

    @Test
    public void testServirLimiteExacto() {
        // 1. Preparar máquina con una cantidad exacta
        Maquina maquina = new Maquina("Honey", "Cerveza con miel", 0.06, 500.0, "CN005");
        maquina.recargarMaquina(200.0);
        
        // 2. Servir exactamente los 200 ml que hay disponibles
        double valorRetornado = maquina.servirCerveza(200.0);
        
        // Valor esperado: 200 * 0.06 = 12.0
        assertEquals(12.0, valorRetornado, TOLERANCIA, "Debe permitir servir si la cantidad es igual a la disponible");
        
        // Validar que la máquina queda vacía (0)
        assertEquals(0.0, maquina.getCantidadActual(), TOLERANCIA, "La máquina debería quedar en 0 ml");
    }

    @Test
    public void testServirEnMaquinaVacia() {
        // 1. Máquina recién creada (cantidadActual es 0 por defecto)
        Maquina maquina = new Maquina("Light", "Baja en calorías", 0.04, "CN006");
        
        // 2. Intentar servir cualquier cantidad
        double valorRetornado = maquina.servirCerveza(10.0);
        
        // Validar que retorna 0 y la cantidad sigue en 0
        assertEquals(0.0, valorRetornado, TOLERANCIA);
        assertEquals(0.0, maquina.getCantidadActual(), TOLERANCIA);
    }

}
