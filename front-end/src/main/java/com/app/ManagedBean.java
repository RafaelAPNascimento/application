package com.app;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import com.app.entidade.Pessoa;

@Model
public class ManagedBean {

	@Inject
	private Service service;
	private Pessoa pessoa = new Pessoa();
	private List<Pessoa> pessoas;
	
	
	public String salvar() {
		
		try {
			pessoa = service.salvarPessoa(pessoa);			
			pessoa = new Pessoa();
			FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
											"salvo com sucesso", "salvo com sucesso"));
		}		
		catch(Exception e) {
			FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, 
												e.getMessage(), e.getMessage()));
		}
		return null;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public List<Pessoa> getPessoas() {
		try {			
			pessoas = service.getPessoas();		
			return pessoas;
		}
		catch(RuntimeException e) {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, 
											e.getMessage(), e.getMessage()));			
		}
		return null;
	}
	public void setPessoas(List<Pessoa> pessoas) {		
		this.pessoas = pessoas;
	}	
}
