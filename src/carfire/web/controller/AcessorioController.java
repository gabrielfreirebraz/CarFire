package carfire.web.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import carfire.web.model.dao.AcessorioDAO;
import carfire.web.model.to.AcessorioTO;



@ManagedBean(name = "acessorioController")
@RequestScoped
public class AcessorioController {

	private AcessorioTO acessorioTO = null;
	private AcessorioDAO acessorioDAO = null;
	

	public AcessorioController() {
		acessorioTO = new AcessorioTO();
		acessorioDAO = new AcessorioDAO();
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<AcessorioTO> itens() {
		return acessorioDAO.listarItens();
	}
	
	
	
	/**************************************/
	/* Getter e setters                   */
	/**************************************/
	public AcessorioDAO getAcessorioDAO() {
		return acessorioDAO;
	}	
	public AcessorioTO getAcessorioTO() {
		return acessorioTO;
	}
	public void setAcessorioDAO(AcessorioDAO acessorio) {
		acessorioDAO = acessorio;
	}
	public void setAcessorioTO(AcessorioTO acessorio) {
		acessorioTO = acessorio;
	}
}
