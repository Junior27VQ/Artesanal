package com.krakedev.artesanal.testNegocio;

import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestNegocio {
	public static void main(String[] args) {
		Maquina nuevaM1=new Maquina("Corona","Full stack",0.64,"CN008");
		Negocio n1=new Negocio("Mi negocio", nuevaM1);
		
		System.out.println("Nombre: "+n1.getNombre());
		System.out.println("Nombre: "+n1.getMaquina1());
		
		Maquina m1=n1.getMaquina1();
		double capacidad = m1.getCapasidadMAxima(); 
		System.out.println(capacidad);
	}

}
