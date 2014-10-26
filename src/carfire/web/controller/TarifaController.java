package carfire.web.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import carfire.web.model.dao.TarifaDAO;
import carfire.web.model.to.TarifaTO;



@ManagedBean(name = "tarifaController")
@RequestScoped
public class TarifaController {

	private TarifaTO tarifaTO = null;
	private TarifaDAO tarifaDAO = null;
	

	public TarifaController() {
		tarifaTO = new TarifaTO();
		tarifaDAO = new TarifaDAO();
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<TarifaTO> itens() {
		return tarifaDAO.listarItens();
	}
	
	
	
	/**************************************/
	/* Getter e setters                   */
	/**************************************/
	public TarifaDAO getTarifaDAO() {
		return tarifaDAO;
	}	
	public TarifaTO getTarifaTO() {
		return tarifaTO;
	}
	public void setTarifaDAO(TarifaDAO tarifa) {
		tarifaDAO = tarifa;
	}
	public void setTarifaTO(TarifaTO tarifa) {
		tarifaTO = tarifa;
	}
}
