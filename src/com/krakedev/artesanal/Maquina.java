package com.krakedev.artesanal;

public class Maquina {
	private String nombreCerveza;
	private String descripcion;
	private double precioPorMl;
	private double capacidadMaxima;
	private double cantidadActual;
	private String codigo;
	
	
	public Maquina() {
		super();
	}
	public Maquina(String nombreCerveza, String descripcion, double precioPorMl, double capacidadMaxima, String codigo) {
		super();
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = capacidadMaxima;
		this.cantidadActual = 0;
		this.codigo = codigo;
	}
	public Maquina(String nombreCerveza, String descripcion, double precioPorMl, String codigo) {
		super();
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = 1000;
		this.cantidadActual = 0;
		this.codigo = codigo;
	}

	public String getNombreCerveZa() {
		return nombreCerveza;
	}
	public void setNombreCerveZa(String nombreCerveZa) {
		this.nombreCerveza = nombreCerveZa;
	}
	public String getDescipcion() {
		return descripcion;
	}
	public void setDescipcion(String descipcion) {
		this.descripcion = descipcion;
	}
	public double getPrecioPorMl() {
		return precioPorMl;
	}
	public void setPrecioPorMl(double precioPorMl) {
		this.precioPorMl = precioPorMl;
	}
	public double getCapasidadMAxima() {
		return capacidadMaxima;
	}
	
	public double getCantidadActual() {
		return cantidadActual;
	}
	public String getCodigo() {
		return codigo;
	}
	
	public void imprimir() {
		String mensaje="Codigo: "+codigo
					  +"Nombre de la cerveza: "+nombreCerveza
					  +" Descripcion: "+descripcion
					  +" Precio por mililitros: "+precioPorMl
					  +" Capacidad MAxima: "+capacidadMaxima
					  +" Cantidad Actual: "+cantidadActual;
		System.out.println(mensaje);

	}
	public void llenarMaquina() {
		this.cantidadActual=this.capacidadMaxima - 200;
	}
	public boolean recargarMaquina(double cantidad) {
		double limitePermitido = capacidadMaxima - 200;
		if(cantidadActual+cantidad<=limitePermitido) {
			cantidadActual=cantidadActual+cantidad;
			return true;
		}else {
			System.out.println("Se lleno el contenedor");
			return false;}
	}
	public double servirCerveza(double cantidad) {
		if(cantidadActual>=cantidad) {
			cantidadActual=cantidadActual-cantidad;
			double valor=cantidad*precioPorMl;
			return valor;
		}else {
			return 0;
		}
	}
	
}
