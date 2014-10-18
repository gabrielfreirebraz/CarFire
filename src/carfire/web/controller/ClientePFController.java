package carfire.web.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import carfire.web.model.dao.ClientePessoaFisicaDAO;
import carfire.web.model.to.ClientePessoaFisicaTO;


@ManagedBean(name = "clientePFController")
@RequestScoped
public class ClientePFController {

	private ClientePessoaFisicaTO clienteTO = null;
	private ClientePessoaFisicaDAO clienteDAO = null;
	
	
	public ClientePFController() {
		clienteTO = new ClientePessoaFisicaTO();
		clienteDAO = new ClientePessoaFisicaDAO();
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<ClientePessoaFisicaTO> itens() {
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
		return "formClientPF";
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
		return "listClientsPF";
	}	
	
	
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	public static boolean validarCPF(long cpf) {		
//		Serasa.validarCPF(cpf);
		return true;
	}	
	
	
	/**************************************/
	/* Getter e setters                   */
	/**************************************/
	public ClientePessoaFisicaDAO getClienteDAO() {
		return clienteDAO;
	}	
	public ClientePessoaFisicaTO getClienteTO() {
		return clienteTO;
	}
	public void setClienteTO(ClientePessoaFisicaTO cliente) {
		clienteTO = cliente;
	}
	public void setClienteDAO(ClientePessoaFisicaDAO cliente) {
		clienteDAO = cliente;
	}
}
