package carfire.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import carfire.web.model.dao.DevolucaoDAO;
import carfire.web.model.dao.EmprestimoDAO;
import carfire.web.model.dao.ItensEmprestimoDAO;
import carfire.web.model.dao.PagamentoCartaoCreditoDAO;
import carfire.web.model.to.DevolucaoTO;
import carfire.web.model.to.EmprestimoTO;
import carfire.web.model.to.ItensEmprestimoTO;
import carfire.web.model.to.PagamentoCartaoCreditoTO;
import carfire.web.util.FuncoesData;



@ManagedBean(name = "emprestimoController")
@RequestScoped
public class EmprestimoController {

	private EmprestimoTO emprestimoTO = null;
	private EmprestimoDAO emprestimoDAO = null;
	private ItensEmprestimoDAO itensDAO = null;
	
	private long veiculoSelecionado_id = 0;
	private long tarifaSelecionada_id = 0;
	public List<SelectItem> acessoriosSelecionados_ids = new ArrayList<SelectItem>();
	
	

	public EmprestimoController() {
		emprestimoTO = new EmprestimoTO();
		emprestimoDAO = new EmprestimoDAO();
		itensDAO = new ItensEmprestimoDAO();
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
		
		//
		//
		//
//		PagamentoCartaoCreditoTO pagamento= new PagamentoCartaoCreditoTO();
//		pagamento.setBandeira("Visa");
//		pagamento.setNome_titular("Fulanox");
//		pagamento.setCpf("122.333.444-22");
//		pagamento.setNumero_cartao("323234.433434.433434");
//		pagamento.setData_validade("22/12/1990");
//		pagamento.setCod_seguranca("322");
//		
//		PagamentoCartaoCreditoDAO pagDAO = new PagamentoCartaoCreditoDAO();
//		pagDAO.inserir(pagamento);
		
		
		//
		// Novo empréstimo
		//
		EmprestimoTO emprestimo = new EmprestimoTO();
		emprestimo.setAgencia_id(1);
		emprestimo.setData(FuncoesData.dataAtual());
		emprestimo.setHora(FuncoesData.horaAtual());
		emprestimo.setStatus("emprestado");
		
		emprestimoDAO.inserir(emprestimo);
		
		//
		// Inserir veículo
		//
		ItensEmprestimoTO itens_emprestimo = new ItensEmprestimoTO();
		itens_emprestimo.setVeiculo_id(veiculoSelecionado_id);
		itens_emprestimo.setEmprestimo_id(emprestimoDAO.lastInsertId());
		
		itensDAO.inserir(itens_emprestimo);
		
		
		
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
		
		//
		// Nova devolução
		//
		DevolucaoTO devolucao = new DevolucaoTO();
		devolucao.setAgencia_id(1);
		devolucao.setData(FuncoesData.dataAtual());
		devolucao.setHora(FuncoesData.horaAtual());
		
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
