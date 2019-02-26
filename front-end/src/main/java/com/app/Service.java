package com.app;

import java.net.URI;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.app.entidade.Pessoa;

@Model
public class Service {

	private final String URL_BACKEND = "http://backend:8080/app-backend/";
	
	public Pessoa salvarPessoa(Pessoa pessoa) {
		
		final String operacao = "pessoa/salvar";		
		URI uri = UriBuilder.fromUri(URL_BACKEND).path(operacao).build();
				
		Entity<Pessoa> data = Entity.entity(pessoa, MediaType.APPLICATION_XML_TYPE);
		Response response = ClientBuilder.newClient()
										.target(uri)
										.request(MediaType.APPLICATION_XML)
										.post(data, Response.class);
				
		if(response.getStatusInfo() == Response.Status.OK) {
			pessoa = response.readEntity(Pessoa.class);
			return pessoa;
		}			
		else
			throw new RuntimeException(response.readEntity(String.class));				
	}
	
	public List<Pessoa> getPessoas() {
		
		final String operacao = "pessoa/todas";
		URI uri = UriBuilder.fromUri(URL_BACKEND).path(operacao).build();
		
		Response response = ClientBuilder.newClient()
										.target(uri)
										.request(MediaType.APPLICATION_JSON_TYPE)
										.get(Response.class);
		
		if(response.getStatusInfo() == Response.Status.OK)
			return response.readEntity(List.class);
		else
			throw new RuntimeException("Não foi possível obter a Lista de Pessoas");			
	}
}
