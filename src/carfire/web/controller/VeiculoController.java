package carfire.web.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import carfire.web.model.Veiculo;

@ManagedBean(name = "veiculoController")
@RequestScoped
public class VeiculoController {

	private Veiculo veiculo = null;
	

	public VeiculoController() {
		veiculo = new Veiculo();
	}

	public ArrayList<Veiculo> itens() {
		return Veiculo.getArrayObjects();
	}

	public String excluir() {

		veiculo.excluir();
		return null;
	}

	public String editar() {

		return "formCar";
	}

	public String salvar() {

		if (veiculo.getId() == 0) {
			veiculo.inserir();

		} else {
			veiculo.editar();
		}
		return "listCars";
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

}
