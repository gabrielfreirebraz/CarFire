package carfire.web.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import carfire.web.model.dao.GrupoDAO;
import carfire.web.model.to.GrupoTO;



@ManagedBean(name = "grupoController")
@RequestScoped
public class GrupoController {

	private GrupoTO grupoTO = null;
	private GrupoDAO grupoDAO = null;
	

	public GrupoController() {
		grupoTO = new GrupoTO();
		grupoDAO = new GrupoDAO();
	}

	
	/**
	 * 
	 * @return
	 */
	public ArrayList<GrupoTO> itens() {
		return GrupoDAO.listarItens();
	}

	
	
	/**************************************/
	/* Getter e setters                   */
	/**************************************/
	public GrupoDAO getGrupoDAO() {
		return grupoDAO;
	}	
	public GrupoTO getGrupoTO() {
		return grupoTO;
	}
	public void setGrupoDAO(GrupoDAO grupo) {
		grupoDAO = grupo;
	}
	public void setGrupoTO(GrupoTO grupo) {
		grupoTO = grupo;
	}
}
