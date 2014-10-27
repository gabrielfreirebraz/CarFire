package carfire.web.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;

import carfire.web.model.dao.AgenciaDAO;
import carfire.web.model.to.AgenciaTO;



@ManagedBean(name = "agenciaController")
@RequestScoped
public class AgenciaController {

	private AgenciaTO agenciaTO = null;
	private AgenciaDAO agenciaDAO = null;
	
	
	
	public AgenciaController() {
		agenciaTO = new AgenciaTO();
		agenciaDAO = new AgenciaDAO();		
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<AgenciaTO> itens() {
		return agenciaDAO.listarItens();
	}
	
	/**
	 * Alterar combo de agências quando selecionar uma cidade
	 * @param e
	 */
	public ArrayList<AgenciaTO> getListaByCidade(ValueChangeEvent e) {	
		
		long idCidadeSelecionada = Long.parseLong(e.getNewValue().toString());
		return agenciaDAO.listarAgenciasByCidade(idCidadeSelecionada);
	}
	
	


	
	/**************************************/
	/* Getter e setters                   */
	/**************************************/
	public AgenciaDAO getAgenciaDAO() {
		return agenciaDAO;
	}	
	public AgenciaTO getAgenciaTO() {
		return agenciaTO;
	}
	public void setAgenciaDAO(AgenciaDAO agencia) {
		agenciaDAO = agencia;
	}
	public void setAgenciaTO(AgenciaTO agencia) {
		agenciaTO = agencia;
	}

}
