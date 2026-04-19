package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestRecargar {
	public static void main(String[] args) {
		Maquina recargar1 = new Maquina("Pilsener","Cerveza fria",0.02,8000, "CN001");
		boolean resultado;
		
		System.out.println("----------ESTADO INICIAL---------");
		recargar1.imprimir();
		
		System.out.println("----------RECARGA 1---------");
		resultado=recargar1.recargarMaquina(3000);
		System.out.println("Se recargo correctamente "+resultado);
		recargar1.imprimir();
		
		System.out.println("----------RECARGA 2---------");
		resultado=recargar1.recargarMaquina(2000);
		System.out.println("Se recargo correctamente "+resultado);
		recargar1.imprimir();
		
		System.out.println("----------RECARGA 3---------");
		resultado=recargar1.recargarMaquina(3000);
		System.out.println("Se recargo correctamente "+resultado);
		recargar1.imprimir();
		
	}

}
