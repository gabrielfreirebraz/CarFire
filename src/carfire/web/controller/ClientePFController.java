package carfire.web.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import carfire.web.model.ClientePF;

@ManagedBean(name = "clientePFController")
@RequestScoped
public class ClientePFController {

	private ClientePF cliente = null;
	
	
	public ClientePFController() {
		cliente = new ClientePF();
	}

	public ArrayList<ClientePF> itens() {
		return ClientePF.getArrayObjects();
	}

	public String excluir() {

		cliente.excluir();
		return null;
	}

	public String editar() {

		return "formClientPF";
	}

	public String salvar() {

		if (cliente.getId() == 0) {
			cliente.inserir();

		} else {
			cliente.editar();
		}
		return "listClientsPF";
	}	
	
	
	public static boolean validarCPF(long cpf) {		
//		Serasa.validarCPF(cpf);
		return true;
	}	
	
	public ClientePF getCliente() {
		return cliente;
	}
	public void setCliente(ClientePF cliente) {
		this.cliente = cliente;
	}	

}
