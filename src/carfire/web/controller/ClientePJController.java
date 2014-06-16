package carfire.web.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import carfire.web.model.ClientePJ;

@ManagedBean(name = "clientePJController")
@RequestScoped
public class ClientePJController {

	private ClientePJ cliente = null;
	
	
	public ClientePJController() {
		cliente = new ClientePJ();
	}
	
	public ArrayList<ClientePJ> itens() {
		return ClientePJ.getArrayObjects();
	}
	
	public String excluir() {
		
		cliente.excluir();
		return null;
	}
	
	public String editar() {
		
		return "formClientPJ";
	}
	
	public String salvar() {
		
		if (cliente.getId() == 0) {
			cliente.inserir();
			
		} else {
			cliente.editar();
		}
		return "listClientsPJ";
	}
	
	public String cancelar() {
		return "listClientsPJ";
	}
	
	public ClientePJ getCliente() {
		return cliente;
	}	
	public void setCliente(ClientePJ cliente) {
		this.cliente = cliente;
	}
}
