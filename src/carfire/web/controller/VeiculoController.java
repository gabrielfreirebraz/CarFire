package carfire.web.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import carfire.web.model.dao.VeiculoDAO;
import carfire.web.model.to.VeiculoTO;

@ManagedBean(name = "veiculoController")
@RequestScoped
public class VeiculoController {

	private VeiculoTO veiculoTO = null;
	private VeiculoDAO veiculoDAO = null;
	

	public VeiculoController() {
		veiculoTO = new VeiculoTO();
		veiculoDAO = new VeiculoDAO();
	}

	
	/**
	 * 
	 * @return
	 */
	public ArrayList<VeiculoTO> itens() {
		return VeiculoDAO.listarItens();
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
}
