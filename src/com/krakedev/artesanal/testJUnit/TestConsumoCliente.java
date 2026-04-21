package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestConsumoCliente {
	@Test
	public void probarConsumo() {
		Maquina m1=new Maquina("Pilsener", "Negra", 0.002, 8000, "CN001");
		Negocio n1=new Negocio("Bar de Moe", m1);
		Cliente c1=new Cliente("Andres", "0123456789");
		
		n1.cargarMaquina();
		
		n1.servirCerveza(c1, 100);
		assertEquals(7700, m1.getCantidadActual(), 0.001);
		assertEquals(0.2, c1.getTotalConsumido(), 0.001);
		
		n1.servirCerveza(c1, 200);
		assertEquals(7500, m1.getCantidadActual(), 0.001);
		assertEquals(0.6, c1.getTotalConsumido(), 0.001);
	}

}
