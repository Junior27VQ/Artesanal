package com.krakedev.artesanal;

public class Negocio {
	private String nombre;
	private Maquina maquina1;
	private int ultimoCodigo = 100;
	
	
	public Negocio() {
		super();
	}
	public Negocio(String nombre, Maquina maquina1) {
		super();
		this.nombre = nombre;
		this.maquina1 = maquina1;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Maquina getMaquina1() {
		return maquina1;
	}
	public void setMaquina1(Maquina maquina1) {
		this.maquina1 = maquina1;
	}
	public void asignarCodigo(Cliente cliente) {
		cliente.setCodigo(ultimoCodigo);
		ultimoCodigo++;
	}
	public void cargarMaquina() {
		maquina1.llenarMaquina();
	}
	public void servirCerveza(Cliente cliente, double ml) {
		double valor=maquina1.servirCerveza(ml);
		cliente.setTotalConsumido(cliente.getTotalConsumido()+valor);
	}

}
