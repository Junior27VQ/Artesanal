package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
	ArrayList<Maquina> maquinas;

	public NegocioMejorado() {
		this.maquinas = new ArrayList<Maquina>();
	}

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
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

}
