package com.example.demo;

import java.util.HashMap;

public class MultaDao {
	
	HashMap<String, Multa> listaMultas;
	public void createMulta (String id, String matricula, String categoria, float cantidad) {
		Multa multa1 = new Multa();
		multa1.setId(id);
		multa1.setMatricula(matricula);
		multa1.setCategoria(categoria);
		multa1.setCantidad(cantidad);
		listaMultas.put(id, multa1);
	}
	
	public Multa readMulta(String id) {
		return listaMultas.get(id);
	}
	
	public void updateMulta(Multa multa) {
		listaMultas.put(multa.getId(), multa);
	}
	
	public void deleteMulta(Multa multa1) {
		listaMultas.remove(multa1);
	}

}
