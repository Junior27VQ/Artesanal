package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {

	public static void main(String[] args) {
		Maquina cliente1 = new Maquina("Pilsener","Cerveza",0.02, "CN001");
		cliente1.imprimir();
		
		cliente1.setNombreCerveZa("Club");
		cliente1.setDescipcion("Cervesa con aroma mas intenso");
		cliente1.imprimir();
		
		cliente1.setNombreCerveZa("Corona");
		cliente1.setPrecioPorMl(0.64);
		cliente1.imprimir();

	}

}
