package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {

	public static void main(String[] args) {
		Maquina servir1 = new Maquina("Pilsener","Cerveza fria",0.02,8000, "CN002");
		double costo;
		
		System.out.println("----------ESTADO INICIAL---------");
		servir1.imprimir();
		
		System.out.println("----------LLENANDO MAQUINA---------");
		servir1.llenarMaquina();
		servir1.imprimir();
		
		System.out.println("----------SERVIR CERVEZA1---------");
		costo=servir1.servirCerveza(1000);
		System.out.println("Valor a pagar: "+costo);
		servir1.imprimir();
		
		System.out.println("----------SERVIR CERVEZA2 ---------");
		costo=servir1.servirCerveza(2000);
		System.out.println("Valor a pagar: "+costo);
		servir1.imprimir();
		
		System.out.println("----------SERVIR CERVEZA3 ---------");
		costo=servir1.servirCerveza(6000);
		System.out.println("Valor a pagar: "+costo);
		servir1.imprimir();
		
	}

}
