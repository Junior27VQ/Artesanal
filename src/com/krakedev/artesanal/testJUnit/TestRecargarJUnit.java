package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

@SuppressWarnings("unused")
public class TestRecargarJUnit {
	@Test
	public void testRecargaExitosa() {
		Maquina maquina1 = new Maquina("Pilsener","Cerveza fria",0.02,8000,"CN002");
 
		boolean resultado = maquina1.recargarMaquina(3000);
		
		assertTrue(resultado);
		assertEquals(3000,maquina1.getCantidadActual(),0.0001);
	}
	@Test
	public void testRecargaFallida() {
		Maquina maquina2 = new Maquina("Club","Cerveza Full aroma",0.05,8000, "CN003");
		
		maquina2.recargarMaquina(7000);
		boolean resultado = maquina2.recargarMaquina(1000);
		
		assertTrue(resultado);
		assertEquals(3000,maquina2.getCantidadActual(),0.0001);
	}

}
