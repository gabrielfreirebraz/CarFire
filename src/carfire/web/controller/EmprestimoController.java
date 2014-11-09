package carfire.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import carfire.web.model.dao.DevolucaoDAO;
import carfire.web.model.dao.EmprestimoDAO;
import carfire.web.model.to.DevolucaoTO;
import carfire.web.model.to.EmprestimoTO;



@ManagedBean(name = "emprestimoController")
@RequestScoped
public class EmprestimoController {

	private EmprestimoTO emprestimoTO = null;
	private EmprestimoDAO emprestimoDAO = null;
	
	private long veiculoSelecionado_id = 0;
	private long tarifaSelecionada_id = 0;
	public List<SelectItem> acessoriosSelecionados_ids = new ArrayList<SelectItem>();
	
	

	public EmprestimoController() {
		emprestimoTO = new EmprestimoTO();
		emprestimoDAO = new EmprestimoDAO();
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<EmprestimoTO> itens() {
		return emprestimoDAO.listarItens();
	}
	

	
	public String salvarPasso1() {
		
//		int i=0;
//		while (i < (acessoriosSelecionados_ids.size())) {
//			
//			System.out.println(acessoriosSelecionados_ids.get(i)+"\n");
//			
//			i++;
//		}		
		
		return "emprestimoPasso2.jsf";
	}
	public String salvarPasso2() {		
		return "emprestimoPasso3.jsf";
	}
	public String salvarPasso3() {		
		return "listEmprestimo.jsf";
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String cancelar() {	
		emprestimoDAO.cancelar(emprestimoTO.getId());
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public String fazerDevolucao() {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
		
		String data = dateFormat.format(new Date());
		String hora = hourFormat.format(new Date());


		//
		// Nova devolução
		//
		DevolucaoTO devolucao = new DevolucaoTO();
		devolucao.setAgencia_id(1);
		devolucao.setData(data);
		devolucao.setHora(hora);
		
		DevolucaoDAO devolucaoDAO = new DevolucaoDAO();
		devolucaoDAO.inserir(devolucao);
		
		// 
		// Alterar status do empréstimo
		//
		emprestimoTO.setDevolucao_id(devolucaoDAO.lastInsertId());
		emprestimoDAO.fazerDevolucao(emprestimoTO);
		
		return null;
	}
	
	
	/**************************************/
	/* Getter e setters                   */
	/**************************************/
	public EmprestimoDAO getEmprestimoDAO() {
		return emprestimoDAO;
	}	
	public EmprestimoTO getEmprestimoTO() {
		return emprestimoTO;
	}
	public void setEmprestimoDAO(EmprestimoDAO emprestimo) {
		emprestimoDAO = emprestimo;
	}
	public void setEmprestimoTO(EmprestimoTO emprestimo) {
		emprestimoTO = emprestimo;
	}
	public long getVeiculoSelecionado_id() {
		return veiculoSelecionado_id;
	}
	public void setVeiculoSelecionado_id(long veiculoSelecionado_id) {
		this.veiculoSelecionado_id = veiculoSelecionado_id;
	}
	public long getTarifaSelecionada_id() {
		return tarifaSelecionada_id;
	}
	public void setTarifaSelecionada_id(long tarifaSelecionada_id) {
		this.tarifaSelecionada_id = tarifaSelecionada_id;
	}
	public List<SelectItem> getAcessoriosSelecionados_ids() {
		return acessoriosSelecionados_ids;
	}
	public void setAcessoriosSelecionados_ids(
			List<SelectItem> acessoriosSelecionados_ids) {
		this.acessoriosSelecionados_ids = acessoriosSelecionados_ids;
	}
	
}
