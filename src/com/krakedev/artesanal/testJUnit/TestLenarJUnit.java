package com.krakedev.artesanal.testJUnit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.krakedev.artesanal.Maquina;

public class TestLenarJUnit {
	
	@Test
	public void testLlenarMaquina() {
		Maquina maquina1 = new Maquina("Pilsener","Cerveza fria",0.02,8000,"CN001");
 
		maquina1.llenarMaquina();
		
		assertEquals(7800,maquina1.getCantidadActual(),0.0001);
	}

}
