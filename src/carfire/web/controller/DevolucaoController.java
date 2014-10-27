package carfire.web.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import carfire.web.model.dao.DevolucaoDAO;
import carfire.web.model.to.DevolucaoTO;



@ManagedBean(name = "devolucaoController")
@RequestScoped
public class DevolucaoController {

	private DevolucaoTO devolucaoTO = null;
	private DevolucaoDAO devolucaoDAO = null;
	
	
	
	public DevolucaoController() {
		devolucaoTO = new DevolucaoTO();
		devolucaoDAO = new DevolucaoDAO();
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<DevolucaoTO> itens() {
		return devolucaoDAO.listarItens();
	}
	

	

	
	
	
	/**************************************/
	/* Getter e setters                   */
	/**************************************/
	public DevolucaoDAO getDevolucaoDAO() {
		return devolucaoDAO;
	}	
	public DevolucaoTO getDevolucaoTO() {
		return devolucaoTO;
	}
	public void setDevolucaoDAO(DevolucaoDAO devolucao) {
		devolucaoDAO = devolucao;
	}
	public void setDevolucaoTO(DevolucaoTO devolucao) {
		devolucaoTO = devolucao;
	}
	
}
