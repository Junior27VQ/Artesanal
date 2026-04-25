package com.krakedev.artesanal;

import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private String cedula;
	private int codigo;
	private int ultimoCodigo=100;
	private double totalConsumido;
	private ArrayList<Cliente> clientes=new ArrayList<Cliente>();
	
	public Cliente() {}
	public Cliente(String nombre, String cedula) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public double getTotalConsumido() {
		return totalConsumido;
	}
	public void setTotalConsumido(double totalConsumido) {
		this.totalConsumido = totalConsumido;
	}
	public void registrarCliente(String nombre, String cedula) {
		Cliente c=new Cliente(nombre, cedula);
		c.setCodigo(ultimoCodigo);
		clientes.add(c);
		ultimoCodigo++;
	}
	public Cliente buscarClientePorCedula(String cedula) {
		for(int i=0; i<clientes.size(); i++) {
			Cliente c=clientes.get(i);
			if(c.getCedula().equals(cedula)) {
				return c;
			}
		}
		return null;
	}
	public Cliente buscarClientePorCodigo(int codigo) {
		for(int i=0; i<clientes.size(); i++) {
			Cliente c=clientes.get(i);
			if(c.getCodigo() == codigo) {
				return c;
			}
		}
		return null;
	}
	public void consumirCerveza(int codigoCliente, String codigoMaquina, double cantidad) {
		NegocioMejorado nm=new NegocioMejorado();
		Maquina m=nm.recuperarMaquina(codigoMaquina);
		Cliente c=buscarClientePorCodigo(codigoCliente);
		double s=m.servirCerveza(cantidad);
	}

}
