package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

	public static void main(String[] args) {
		Maquina maquina1 = new Maquina("Pilsener","Cerveza fria",0.02,8000, "CN002");
		maquina1.imprimir();
		
		maquina1.llenarMaquina();
		maquina1.imprimir();
		
		Maquina maquina2 = new Maquina("Club","Cerveza buena",0.05, "CN003");
		maquina2.llenarMaquina();
		maquina2.imprimir();

	}

}
