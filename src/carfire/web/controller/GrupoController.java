package carfire.web.controller;

import java.util.ArrayList;
import java.util.List;

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
	private List<VeiculoTO> comboVeiculos = null;
	private List<ItensTarifaTO> comboItensTarifa = null;

	
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
	
	
	/**
	 * Carregar combobox de veículo e tarifas do grupo selecionado
	 * @param e
	 */
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
	public List<VeiculoTO> getComboVeiculos() {
		return comboVeiculos;
	}
	public void setComboVeiculos(ArrayList<VeiculoTO> comboVeiculos) {
		this.comboVeiculos = comboVeiculos;
	}
	public List<ItensTarifaTO> getComboItensTarifa() {
		return comboItensTarifa;
	}
	public void setComboItensTarifa(ArrayList<ItensTarifaTO> comboItensTarifa) {
		this.comboItensTarifa = comboItensTarifa;
	}
	
}
