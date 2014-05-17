package carfire.web.controller;

import carfire.web.model.ClientePF;
import carfire.web.model.ClientePJ;


public class ClienteController {

	private String idioma   = null;
	private ClientePF clientePF = null; 
	private ClientePJ clientePJ = null;
	
	
	public ClienteController(String idioma) {
		this.idioma = idioma;
	}

	public void setObject(ClientePF cliente) {
		this.clientePF = cliente;
	}

	public void setObject(ClientePJ cliente) {
		this.clientePJ = cliente;
	}
	
	public void executarPF() {


	}
	
	public void executarPJ() {
	

	}
	
	
	public static boolean inserirPF(ClientePF cliente) {
		cliente.inserir();		
		return true;
	}
		
	public static boolean inserirPJ(ClientePJ cliente) {
		cliente.inserir();		
		return true;
	}
	
	public static boolean editarPF(ClientePF cliente) {
		cliente.editar();		
		return true;
	}
		
	public static boolean editarPJ(ClientePJ cliente) {
		cliente.editar();		
		return true;
	}
	
	public static boolean validarCPF(long cpf) {		
//		Serasa.validarCPF(cpf);
		return true;
	}
	
}
