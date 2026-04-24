package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {

	public static void main(String[] args) {
		NegocioMejorado nm=new NegocioMejorado();
		Cliente c=new Cliente();
		
		c.registrarCliente("Ramon", "0147852369");
		System.out.println(c.getNombre()+" "+c.getCedula());

	}

}
