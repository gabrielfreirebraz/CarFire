package carfire.web.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;

import carfire.web.model.dao.ItensTarifaDAO;
import carfire.web.model.to.ItensTarifaTO;



@ManagedBean(name = "itensTarifaController")
@RequestScoped
public class ItensTarifaController {

	private ItensTarifaTO itensTarifaTO = null;
	private ItensTarifaDAO itensTarifaDAO = null;
	


	public ItensTarifaController() {
		itensTarifaTO = new ItensTarifaTO();
		itensTarifaDAO = new ItensTarifaDAO();
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<ItensTarifaTO> itens() {
		return itensTarifaDAO.listarItens();
	}
	
	
	
	/**
	 * Alterar listagem de tarifas quando selecionar um grupo
	 * @param e
	 */
	public ArrayList<ItensTarifaTO> getListaByGrupo(ValueChangeEvent e) {	
		
		long idGrupoSelecionado = Long.parseLong(e.getNewValue().toString());
		return itensTarifaDAO.listarItensByGrupo(idGrupoSelecionado);
	}
	
	
	
	
	/**************************************/
	/* Getter e setters                   */
	/**************************************/
	public ItensTarifaDAO getItensTarifaDAO() {
		return itensTarifaDAO;
	}	
	public ItensTarifaTO getItensTarifaTO() {
		return itensTarifaTO;
	}
	public void setItensTarifaDAO(ItensTarifaDAO itensTarifa) {
		itensTarifaDAO = itensTarifa;
	}
	public void setItensTarifaTO(ItensTarifaTO itensTarifa) {
		itensTarifaTO = itensTarifa;
	}

}
