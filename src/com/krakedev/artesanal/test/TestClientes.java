package com.krakedev.artesanal.test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {

	public static void main(String[] args) {
		NegocioMejorado nm=new NegocioMejorado();
		
		nm.registrarCliente("Ramon", "Vargas");
		System.out.println(nm.getClientes());

	}

}
