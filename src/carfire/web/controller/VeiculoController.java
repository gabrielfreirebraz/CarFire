package carfire.web.controller;

import carfire.web.model.Veiculo;


public class VeiculoController {

	private Veiculo veiculo = null;
	private String msg = null;
	
	
	
	public VeiculoController() {
		this.veiculo = new Veiculo();
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
