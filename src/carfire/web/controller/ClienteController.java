package carfire.web.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import carfire.web.model.ClientePF;
import carfire.web.model.ClientePJ;

@ManagedBean(name = "clienteController")
@RequestScoped
public class ClienteController {

	private ClientePF clientePF = null; 
	private ClientePJ clientePJ = null;
	
	
	public ClienteController() {
		clientePF = new ClientePF();
		clientePJ = new ClientePJ();
	}


	
	public ArrayList<ClientePF> itensPF() {
		return ClientePF.getArrayObjects();
	}

	public String excluir() {

		clientePF.excluir();
		return null;
	}

	public String editar() {

		return "formClient";
	}

	public String salvar() {

		if (clientePF.getId() == 0) {
			clientePF.inserir();

		} else {
			clientePF.editar();
		}
		return "listClientsPF";
	}
	
	
	
	public static boolean validarCPF(long cpf) {		
//		Serasa.validarCPF(cpf);
		return true;
	}
	
	
	
	/*********************************/
	/*    Propriedades Cliente       */
	/*********************************/
	
	public ClientePF getClientePF() {
		return clientePF;
	}

	public void setClientePF(ClientePF cliente) {
		clientePF = cliente;
	}
	
	public ClientePJ getClientPJ() {
		return clientePJ;
	}
	
	public void setClientePJ(ClientePJ cliente) {
		clientePJ = cliente;
	}
}
