package com.curso.serviciosmultas.servicioclientes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.serviciosmultas.servicioclientes.model.ClienteRepository;
import com.curso.serviciosmultas.servicioclientes.model.entities.Cliente;

@RestController
public class ControllerCliente {
	private final ClienteRepository repository;
	
	public ControllerCliente(ClienteRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/clientes")
	public List<Cliente> clientes(){
		return repository.findAll();
	}
	
	@GetMapping("/clientes/{matricula}")
	public Cliente cliente(@PathVariable Integer matricula) {
		return repository.findById(matricula)
				.orElse(null);
	}
	
	@PostMapping("/clientes")
	public Cliente nuevoCliente(@RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
	
	@DeleteMapping("/clientes/{matricula}")
	public void borrarCliente(@PathVariable Integer matricula) {
		repository.deleteById(matricula);
	}
	
	@PutMapping("/clientes/{matricula}")
	public Cliente actualizarCliente(@RequestBody Cliente cliente,@PathVariable Integer matricula) {
		return repository.findById(matricula)
			.map(c -> {
					c.setNombreCliente(cliente.getNombreCliente());
					c.setApellidoCliente(cliente.getApellidoCliente());
					c.setDireccionCliente(cliente.getDireccionCliente());
					return repository.save(c);
				})
			.orElseGet(()->{
				cliente.setMatricula(matricula);
				return repository.save(cliente);
			});
			
	}
}
