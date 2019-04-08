package com.example.demo;

import java.awt.List;
import java.util.Collection;

public class Multa {
	
	private String id;
	private String matricula;
	private String categoria;
	private float cantidad;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	
	Collection<Multa> listaMultas;//= new List<Multa>();
	public void createMulta (String id, String matricula, String categoria, float cantidad) {
		Multa multa1 = new Multa();
		multa1.setId(id);
		multa1.setMatricula(matricula);
		multa1.setCategoria(categoria);
		multa1.setCantidad(cantidad);
		listaMultas.add(multa1);
	}
	
	public void readMulta() {
		
	}
	
	public void updateMulta() {
		
	}
	
	public void deleteMulta(Multa multa1) {
		listaMultas.remove(multa1);
	}

}
