package com.ejercicio.multas.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ejercicio.multas.Multa;
import com.ejercicio.multas.MultaRepository;

@Configuration
public class Configuracion {
	@Bean
	public CommandLineRunner iniciarBaseDeDatos(MultaRepository repo) {
		return args -> {
			repo.save(new Multa(01, "ABCD01", "Exceso de velocidad", 400));
			repo.save(new Multa(02, "ABCD02", "Desobediencia a la autoridad", 200));
			repo.save(new Multa(03, "ABCD03", "Mal aparcado", 150));
		};
	}

}
