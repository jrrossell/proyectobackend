package com.curso.serviciosmultas.servicioclientes.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.serviciosmultas.servicioclientes.model.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
}
