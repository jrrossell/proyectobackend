package com.curso.serviciosmultas.servicioclientes.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	private String nombreCliente;
	private String apellidoCliente;
	private String direccionCliente;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer matricula;
	
	public Cliente(String nombreCliente, String apellidoCliente, String direccionCliente) {
		super();
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.direccionCliente = direccionCliente;
	}
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

}
