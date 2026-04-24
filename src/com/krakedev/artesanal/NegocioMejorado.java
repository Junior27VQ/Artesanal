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

}
