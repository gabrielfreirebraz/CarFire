package carfire.web.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import carfire.web.model.dao.ClientePessoaJuridicaDAO;
import carfire.web.model.to.ClientePessoaJuridicaTO;

@ManagedBean(name = "clientePJController")
@RequestScoped
public class ClientePJController {

	private ClientePessoaJuridicaTO clienteTO = null;
	private ClientePessoaJuridicaDAO clienteDAO = null;
	
	
	public ClientePJController() {
		clienteTO = new ClientePessoaJuridicaTO();
		clienteDAO = new ClientePessoaJuridicaDAO();
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<ClientePessoaJuridicaTO> itens() {
		return clienteDAO.listarItens();
	}
	
	/**
	 * 
	 * @return
	 */
	public String excluir() {		
		clienteDAO.excluir(clienteTO.getId());
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public String editar() {		
		return "formClientPJ";
	}
	
	/**
	 * 
	 * @return
	 */
	public String salvar() {		
		if (clienteTO.getId() == 0) {
			clienteDAO.inserir(clienteTO);
			
		} else {
			clienteDAO.editar(clienteTO);
		}
		return "listClientsPJ";
	}
	
	/**
	 * 
	 * @return
	 */
	public String cancelar() {
		return "listClientsPJ";
	}
	
	
	
	/**************************************/
	/* Getter e setters                   */
	/**************************************/
	public ClientePessoaJuridicaDAO getClienteDAO() {
		return clienteDAO;
	}	
	public ClientePessoaJuridicaTO getClienteTO() {
		return clienteTO;
	}	
	public void setClienteDAO(ClientePessoaJuridicaDAO cliente) {
		clienteDAO = cliente;
	}
	public void setClienteTO(ClientePessoaJuridicaTO cliente) {
		clienteTO = cliente;
	}
}
