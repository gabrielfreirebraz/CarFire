package carfire.web.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;

import carfire.web.model.dao.GrupoDAO;
import carfire.web.model.to.GrupoTO;
import carfire.web.model.to.ItensTarifaTO;
import carfire.web.model.to.VeiculoTO;




@ManagedBean(name = "grupoController")
@RequestScoped
public class GrupoController {

	private GrupoTO grupoTO = null;
	private GrupoDAO grupoDAO = null;	
	private ArrayList<VeiculoTO> comboVeiculos = null;
	private ArrayList<ItensTarifaTO> comboItensTarifa = null;

	
	public GrupoController() {
		grupoTO = new GrupoTO();
		grupoDAO = new GrupoDAO();		
		comboVeiculos = new ArrayList<VeiculoTO>();
		comboItensTarifa = new ArrayList<ItensTarifaTO>();
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<GrupoTO> itens() {
		return grupoDAO.listarItens();
	}
	
	
	public void changeCombosRelacionadas(ValueChangeEvent e) {	
	
		if (e.getNewValue() != e.getOldValue()) {
			VeiculoController veiculoController = new VeiculoController();	
			comboVeiculos = veiculoController.getListaByGrupo(e);
			
			ItensTarifaController itensTarifaController = new ItensTarifaController();
			comboItensTarifa = itensTarifaController.getListaByGrupo(e);
		}
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
	public ArrayList<VeiculoTO> getComboVeiculos() {
		return comboVeiculos;
	}
	public void setComboVeiculos(ArrayList<VeiculoTO> comboVeiculos) {
		this.comboVeiculos = comboVeiculos;
	}
	public ArrayList<ItensTarifaTO> getComboItensTarifa() {
		return comboItensTarifa;
	}
	public void setComboItensTarifa(ArrayList<ItensTarifaTO> comboItensTarifa) {
		this.comboItensTarifa = comboItensTarifa;
	}
	
}
