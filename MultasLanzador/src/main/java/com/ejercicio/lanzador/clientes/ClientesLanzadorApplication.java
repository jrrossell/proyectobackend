package com.ejercicio.lanzador.clientes;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.curso.serviciosmultas.servicioclientes.model.entities.Cliente;

public class ClientesLanzadorApplication {
	public static void main(String[] args) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Cliente[]> httpEntity = new HttpEntity<Cliente[]>(headers);
		RestTemplate template = new RestTemplate();

		ResponseEntity<Cliente[]> response = template.exchange("http://localhost:8080/clientes", HttpMethod.GET,
				httpEntity, Cliente[].class);
		HttpStatus statusCode = response.getStatusCode();

		if (statusCode == HttpStatus.OK) {
			Cliente[] clientes = response.getBody();
			if (clientes != null) {
				for (Cliente cliente : clientes) {
					System.out.println(cliente.getMatricula());
				}
			}
		}
	}
}
