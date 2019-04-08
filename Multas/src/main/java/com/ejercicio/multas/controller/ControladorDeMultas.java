package com.ejercicio.multas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.multas.Multa;
import com.ejercicio.multas.MultaRepository;

@RestController
public class ControladorDeMultas {
	
	private final MultaRepository repository;
	
	public ControladorDeMultas(MultaRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/multa")
	public List<Multa> multa(){
		return repository.findAll();
	}
	@GetMapping("/multa/{id}")
	public Multa multa(@PathVariable Integer id) {
		return repository.findById(id)
				.orElse(null);
	}
	
	@PostMapping("/multa")
	public Multa nuevaMulta(@RequestBody Multa multa) {
		return repository.save(multa);
	}
	
	@DeleteMapping("/multa/{id}")
	public void borrarMulta(@PathVariable Integer id) {
		repository.deleteById(id);
	}
	@PutMapping("/multa/{id}")
	public Multa actualizarCliente(@RequestBody Multa multa,@PathVariable Integer id) {
		return repository.findById(id)
			.map(c -> {
					c.setMatricula(multa.getMatricula());
					c.setCategoria(multa.getCategoria());
					c.setCantidad(multa.getCantidad());
					return repository.save(c);
				})
			.orElseGet(()->{
				multa.setId(id);
				return repository.save(multa);
			});
			
	}
}
