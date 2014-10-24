package carfire.web.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import carfire.web.model.dao.VeiculoDAO;
import carfire.web.model.to.VeiculoTO;

@ManagedBean(name = "veiculoController")
@SessionScoped
public class VeiculoController {

	private VeiculoTO veiculoTO = null;
	private VeiculoDAO veiculoDAO = null;
	private ArrayList<VeiculoTO> listaVeiculos = null;

	
	public VeiculoController() {
		veiculoTO = new VeiculoTO();
		veiculoDAO = new VeiculoDAO();
		listaVeiculos = new ArrayList<VeiculoTO>();
	}

	
	/**
	 * 
	 * @return
	 */
	public ArrayList<VeiculoTO> itens() {
		return veiculoDAO.listarItens();
	}

	
	/**
	 * Alterar combo de veículos quando selecionar um grupo
	 * @param e
	 */
	public void changeVeiculo(ValueChangeEvent e) {	
		
		if (e.getNewValue() != e.getOldValue()) { 
			long grupo_id = Long.parseLong(e.getNewValue().toString());
			listaVeiculos = veiculoDAO.listarItensByGrupo(grupo_id);
		}
	}


	/**
	 * 
	 * @return
	 */
	public String excluir() {	
		veiculoDAO.excluir(veiculoTO.getId());
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public String editar() {
		return "formCar";
	}

	/**
	 * 
	 * @return
	 */
	public String salvar() {
		if (veiculoTO.getId() == 0) {
			veiculoDAO.inserir(veiculoTO);

		} else {
			veiculoDAO.editar(veiculoTO);
		}
		return "listCars";
	}

	
	
	/**************************************/
	/* Getter e setters                   */
	/**************************************/
	public VeiculoDAO getVeiculoDAO() {
		return veiculoDAO;
	}	
	public VeiculoTO getVeiculoTO() {
		return veiculoTO;
	}
	public void setVeiculoDAO(VeiculoDAO veiculo) {
		veiculoDAO = veiculo;
	}
	public void setVeiculoTO(VeiculoTO veiculo) {
		veiculoTO = veiculo;
	}
	public ArrayList<VeiculoTO> getLista() {
		return listaVeiculos;
	}
	public void setLista(ArrayList<VeiculoTO> veiculos) {
		listaVeiculos = veiculos;
	}
}
