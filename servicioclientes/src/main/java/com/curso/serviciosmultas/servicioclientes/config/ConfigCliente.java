package com.curso.serviciosmultas.servicioclientes.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.curso.serviciosmultas.servicioclientes.model.ClienteRepository;
import com.curso.serviciosmultas.servicioclientes.model.entities.Cliente;


@Configuration
public class ConfigCliente {

	@Bean
	public CommandLineRunner iniciarBaseDeDatos(ClienteRepository repository) {
		return args -> {
			repository.save(new Cliente("Junior", "Rossell", "Madrid"));
			repository.save(new Cliente("Jose", "Perez", "Madrid"));
			repository.save(new Cliente("Luisana", "Margarita", "Madrid"));
		};
	}
	
}
