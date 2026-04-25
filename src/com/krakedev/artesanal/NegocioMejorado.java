package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	private ArrayList<Maquina> maquinas;
	private ArrayList<Cliente> clientes=new ArrayList<Cliente>();
	private int ultimoCodigo=100;

	public NegocioMejorado() {
		this.maquinas = new ArrayList<Maquina>();
	}

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}
	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String generarCodigo() {
		int aleatorio=(int)(Math.random()*100)+1;
		String codigo="M-"+aleatorio;
		return codigo;
	}
	public boolean agregarMaquina(String nombre, String descripcion, double precio) {
		String codigo=generarCodigo();
		Maquina m=recuperarMaquina(codigo);
		if(m == null) {
			Maquina maquina=new Maquina(nombre,descripcion,precio,codigo);
			maquinas.add(maquina);
			return true;
			}
		return false;
	}
	public void cargarMaquina() {
		for(int i=0; i<maquinas.size(); i++) {
			Maquina m=maquinas.get(i);
			m.llenarMaquina();
		}
	}
	public Maquina recuperarMaquina(String codigo) {
		for(int i=0; i<maquinas.size(); i++) {
			Maquina m=maquinas.get(i);
			if(m.getCodigo().equals(codigo)) {
				return m;
			}
		}
		return null;
	}
	public void registrarConsumo(Cliente cliente, Maquina maquina, double cantidad) {
		double acomulado=cliente.getTotalConsumido();
		cliente.setTotalConsumido(acomulado+cantidad);
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
		Maquina m= recuperarMaquina(codigoMaquina);
		Cliente c=buscarClientePorCodigo(codigoCliente);
		double s=m.servirCerveza(cantidad);
		registrarConsumo(c,m,s);
	}
	public double consultarValoresVendidos() {
		double total=0;
		for(int i=0; i<clientes.size(); i++) {
			Cliente c=clientes.get(i);
			total+=c.getTotalConsumido();
		}
		return total;
	}

}
