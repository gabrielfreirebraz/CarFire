package carfire.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ValueChangeEvent;

import carfire.web.model.dao.CidadeDAO;
import carfire.web.model.to.AgenciaTO;
import carfire.web.model.to.CidadeTO;



@ManagedBean(name = "cidadeController")
@RequestScoped
public class CidadeController {

	private CidadeTO cidadeTO = null;
	private CidadeDAO cidadeDAO = null;
	private List<AgenciaTO> comboAgenciasRetirada = null;
	private List<AgenciaTO> comboAgenciasDevolucao = null;
	
	
	
	public CidadeController() {
		cidadeTO = new CidadeTO();
		cidadeDAO = new CidadeDAO();
		comboAgenciasRetirada = new ArrayList<AgenciaTO>();	
		comboAgenciasDevolucao = new ArrayList<AgenciaTO>();	
	}
	
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<CidadeTO> itens() {
		return cidadeDAO.listarItens();
	}
	

	/**
	 * Carregar combobox de agências da cidade selecionada
	 * @param e
	 */
	public void changeComboAgenciasRetirada(ValueChangeEvent e) {	
		
		if (e.getNewValue() != e.getOldValue()) {
			AgenciaController agenciaController = new AgenciaController();	
			comboAgenciasRetirada = agenciaController.getListaByCidade(e);			
		}
	}
	
	/**
	 * Carregar combobox de agências da cidade selecionada
	 * @param e
	 */
	public void changeComboAgenciasDevolucao(ValueChangeEvent e) {	
		
		if (e.getNewValue() != e.getOldValue()) {
			AgenciaController agenciaController = new AgenciaController();	
			comboAgenciasDevolucao = agenciaController.getListaByCidade(e);			
		}
	}
	

	
	/**************************************/
	/* Getter e setters                   */
	/**************************************/
	public CidadeDAO getCidadeDAO() {
		return cidadeDAO;
	}	
	public CidadeTO getCidadeTO() {
		return cidadeTO;
	}
	public void setCidadeDAO(CidadeDAO cidade) {
		cidadeDAO = cidade;
	}
	public void setCidadeTO(CidadeTO cidade) {
		cidadeTO = cidade;
	}
	public List<AgenciaTO> getComboAgenciasRetirada() {
		return comboAgenciasRetirada;
	}
	public void setComboAgenciasRetirada(List<AgenciaTO> comboAgencias) {
		this.comboAgenciasRetirada = comboAgencias;
	}
	public List<AgenciaTO> getComboAgenciasDevolucao() {
		return comboAgenciasDevolucao;
	}
	public void setComboAgenciasDevolucao(List<AgenciaTO> comboAgencias) {
		this.comboAgenciasDevolucao = comboAgencias;
	}

}
