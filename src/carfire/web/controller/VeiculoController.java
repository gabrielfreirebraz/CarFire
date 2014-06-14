package carfire.web.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import carfire.web.model.Veiculo;

@ManagedBean(name = "veiculoController")
@RequestScoped

public class VeiculoController {

	private Veiculo veiculo = null;
	private String msg = null;
	private String name = "";
	

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public VeiculoController() {
		this.veiculo = new Veiculo();
	}

	
	public ArrayList<Veiculo> itens() {
		return Veiculo.getArrayObjects();
	}
	
	
	public String excluir() {
				
		veiculo.excluir();
		return null;
	}
	
	public String salvar() {
		
		this.veiculo.inserir();
		return "veiculo";
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
